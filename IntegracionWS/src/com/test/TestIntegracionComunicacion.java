package com.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.utils.NotificacionFactory;
import com.ws.parsers.MensajeParser;
import com.ws.parsers.SeccionParser;
import com.ws.parsers.SubforoParser;
import com.ws.parsers.TemaParser;
import com.ws.pojos.Mensaje;
import com.ws.pojos.Seccion;
import com.ws.pojos.Subforo;
import com.ws.pojos.Tema;
import com.ws.serializers.MensajeSerializer;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;

public class TestIntegracionComunicacion {
	private IntegracionWS integracionWS;
	
    @Before
    public void setUp() throws Exception {
    	this.integracionWS = new IntegracionWS();
        IntegracionWS.setMockService(false);
    }

    //******************************************MENSAJE************************************************\\
    @Test
    public void testMensaje() {
        // guardar mensaje
        Mensaje mensaje = crearMensajeNegocio();
        String mensajeXML = getMensajeNegocioXML(mensaje);
        String resultadoTransaccion = integracionWS.guardarDatos(mensajeXML);
        Assert.assertTrue(resultadoTransaccion.contains("La entidad ha sido almacenada con exito"));

        // consultar mensaje por props
        resultadoTransaccion = integracionWS.seleccionarDatos(mensajeXML);
        Mensaje mensaje_leido = getMessageFromResult(resultadoTransaccion);
        assertMensajesIguales(mensaje, mensaje_leido);

        // consultar mensaje por id
        Mensaje mensaje_con_solo_id = new Mensaje();
        mensaje_con_solo_id.setId(mensaje_leido.getId());
        String resultadoTransaccion2 = integracionWS.seleccionarDatos(getMensajeNegocioXML(mensaje_con_solo_id));
        Mensaje mensaje_leido2 = getMessageFromResult(resultadoTransaccion2);
        assertMensajesIguales(mensaje, mensaje_leido2);        

        // eliminar mensaje por id
        mensaje.setId(mensaje_leido.getId());
        resultadoTransaccion = integracionWS.eliminarDatos(getMensajeNegocioXML(mensaje));
        Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), resultadoTransaccion);
    }

	private Mensaje getMessageFromResult(String resultadoTransaccion) {
		resultadoTransaccion=resultadoTransaccion.replace("<list>", "");
		resultadoTransaccion=resultadoTransaccion.replace("</list>", "");
        MensajeParser parser = new MensajeParser();
        Mensaje mensaje_leido = (Mensaje) parser.getEntidadNegocio(resultadoTransaccion);
		return mensaje_leido;
	}

	private void assertMensajesIguales(Mensaje mensaje, Mensaje mensaje_leido) {
		Assert.assertTrue(mensaje_leido.getId() != null);
        Assert.assertEquals(mensaje.getContenido(), mensaje_leido.getContenido());
	}

    private Mensaje crearMensajeNegocio() {
        Mensaje mensaje = new Mensaje();
        Long date = System.currentTimeMillis();
        mensaje.setContenido("Hola querido!, como estas??"+date.toString());
        return mensaje;
    }

    private String getMensajeNegocioXML(Mensaje mensaje) {
    	XStream xstream = new XStream();
    	xstream.alias("Mensaje", Mensaje.class);
    	String xml = xstream.toXML(mensaje);
    	return "<WS>"+xml+"</WS>";
    	
    }
    
  //******************************************TEMA************************************************\\
    @Test
    public void testTema() {
        // guardar mensaje
    	Tema tema = crearTemaNegocio();
        String mensajeXML = getTemaNegocioXML(tema);
        String resultadoTransaccion = integracionWS.guardarDatos(mensajeXML);
        Assert.assertTrue(resultadoTransaccion.contains("La entidad ha sido almacenada con exito"));

        // consultar mensaje por props
        resultadoTransaccion = integracionWS.seleccionarDatos(mensajeXML);
        Tema tema_leido = getTemaFromResult(resultadoTransaccion);
        assertTemasIguales(tema, tema_leido);

        // consultar mensaje por id
        Tema tema_con_solo_id = new Tema();
        tema_con_solo_id.setId(tema_leido.getId());
        String resultadoTransaccion2 = integracionWS.seleccionarDatos(getTemaNegocioXML(tema_con_solo_id));
        Tema mensaje_leido2 = getTemaFromResult(resultadoTransaccion2);
        assertTemasIguales(tema, mensaje_leido2);        

        // eliminar mensaje
        resultadoTransaccion = integracionWS.eliminarDatos(getTemaNegocioXML(tema));
        Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), resultadoTransaccion);
    }

	private Tema getTemaFromResult(String resultadoTransaccion) {
		resultadoTransaccion.replace("<list>", "");
        resultadoTransaccion.replace("</list>", "");
        TemaParser parser = new TemaParser();
        Tema tema_leido = (Tema) parser.getEntidadNegocio(resultadoTransaccion);
		return tema_leido;
	}

	private void assertTemasIguales(Tema tema, Tema tema_leido) {
		Assert.assertTrue(tema_leido.getId() != null);
        System.out.println("Tema leido de la BD: "+ tema_leido.toString());
        Assert.assertEquals(tema.getAutor(), tema_leido.getAutor());
        Assert.assertEquals(tema.getTitulo(), tema_leido.getTitulo());
        Assert.assertEquals(tema.getEsSticky(), tema_leido.getEsSticky());
        Assert.assertEquals(tema.getIdSubforo(), tema_leido.getIdSubforo());
        Assert.assertEquals(tema.getFecha(), tema_leido.getFecha());
	}

    private Tema crearTemaNegocio() {
    	Tema tema = new Tema();
    	tema.setAutor("pepe");
    	tema.setFecha("12/12/2013");
    	tema.setTitulo("Pruebas de integracion");
    	tema.setEsSticky(false);
    	//TODO: como se manejan los mensajes del foro?
        return tema;
    }

    private String getTemaNegocioXML(Tema tema) {
    	XStream xstream = new XStream();
    	xstream.alias("Tema", Tema.class);
    	String xml = xstream.toXML(tema);
    	return "<WS>"+xml+"</WS>";
    	
    }
    
    //******************************************SUBFORO************************************************\\
    @Test
    public void testSubforo() {
//    	Seccion seccion = crearSeccionNegocio();
//    	String seccionXML = getSeccionNegocioXML(seccion);
//    	String resultadoTransaccion = integracionWS.guardarDatos(seccionXML);
//        //Assert.assertTrue(resultadoTransaccion.contains("La entidad ha sido almacenada con exito"));
//    	
//        // consultar mensaje por props
//        resultadoTransaccion = integracionWS.seleccionarDatos(seccionXML);
//        Seccion seccion_leida = getSeccionFromResult(resultadoTransaccion);
//        //assertSubforosIguales(seccion, seccion_leida);
        
        // guardar mensaje
    	Subforo subforo = crearSubforoNegocio();
    	subforo.setIdSeccion(1L);
        String mensajeXML = getSubforoNegocioXML(subforo);
        String resultadoTransaccion = integracionWS.guardarDatos(mensajeXML);
        Assert.assertTrue(resultadoTransaccion.contains("La entidad ha sido almacenada con exito"));

        // consultar mensaje por props
        resultadoTransaccion = integracionWS.seleccionarDatos(mensajeXML);
        Subforo subforo_leido = getSubforoFromResult(resultadoTransaccion);
        assertSubforosIguales(subforo, subforo_leido);

        // consultar mensaje por id
        Subforo subforo_con_solo_id = new Subforo();
        subforo_con_solo_id.setId(subforo_leido.getId());
        String resultadoTransaccion2 = integracionWS.seleccionarDatos(getSubforoNegocioXML(subforo_con_solo_id));
        Subforo mensaje_leido2 = getSubforoFromResult(resultadoTransaccion2);
        assertSubforosIguales(subforo, mensaje_leido2);        

        // eliminar mensaje
        resultadoTransaccion = integracionWS.eliminarDatos(getSubforoNegocioXML(subforo));
        Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), resultadoTransaccion);
    }

	private Subforo getSubforoFromResult(String resultadoTransaccion) {
		resultadoTransaccion.replace("<list>", "");
        resultadoTransaccion.replace("</list>", "");
        SubforoParser parser = new SubforoParser();
        Subforo subforo_leido = (Subforo) parser.getEntidadNegocio(resultadoTransaccion);
		return subforo_leido;
	}
	
	private Seccion getSeccionFromResult(String resultadoTransaccion) {
		resultadoTransaccion.replace("<list>", "");
        resultadoTransaccion.replace("</list>", "");
        SeccionParser parser = new SeccionParser();
        Seccion subforo_leido = (Seccion) parser.getEntidadNegocio(resultadoTransaccion);
		return subforo_leido;
	}

	private void assertSubforosIguales(Subforo subforo, Subforo subforo_leido) {
		Assert.assertTrue(subforo_leido.getId() != null);
        System.out.println("Tema leido de la BD: "+ subforo_leido.toString());
        Assert.assertEquals(subforo.getNombre(), subforo_leido.getNombre());
        Assert.assertEquals(subforo.getIdForo(), subforo_leido.getIdForo());
        Assert.assertEquals(subforo.getIdSeccion(), subforo_leido.getIdSeccion());
        Assert.assertEquals(subforo.getIdSubforoPadre(), subforo_leido.getIdSubforoPadre());
	}

    private Subforo crearSubforoNegocio() {
    	Subforo subforo = new Subforo();
    	subforo.setNombre("Mi subforo");
        return subforo;
    }

    private String getSubforoNegocioXML(Subforo subforo) {
    	XStream xstream = new XStream();
    	xstream.alias("Subforo", Subforo.class);
    	String xml = xstream.toXML(subforo);
    	return "<WS>"+xml+"</WS>";
    	
    }
    
    private Seccion crearSeccionNegocio() {
    	Seccion seccion = new Seccion();
    	Long time = System.currentTimeMillis();
    	seccion.setNombre("Mi seccion"+time.toString());
        return seccion;
    }

    private String getSeccionNegocioXML(Seccion seccion) {
    	XStream xstream = new XStream();
    	xstream.alias("Seccion", Seccion.class);
    	String xml = xstream.toXML(seccion);
    	return "<WS>"+xml+"</WS>";
    	
    }
}
