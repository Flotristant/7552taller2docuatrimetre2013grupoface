package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;

import com.thoughtworks.xstream.XStream;
import com.utils.NotificacionFactory;
import com.ws.parsers.ForoParser;
import com.ws.pojos.Foro;
import com.ws.pojos.Mensaje;
import com.ws.pojos.Seccion;
import com.ws.pojos.Subforo;
import com.ws.pojos.Tema;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;
import com.ws.tags.ForoTags;

public class ForoTest extends TestCase {

	DataService service;
	IData port;
	String xmlForo;
	Foro foroNegocio;
	ar.fiuba.redsocedu.datalayer.ws.Foro foroBD;
	IntegracionWS integracionWS;
	
    @Before
    public void setUp() throws Exception {
		service = new DataService();
		port = service.getDataPort();    	
    	integracionWS = new IntegracionWS();
        IntegracionWS.setMockService(false);  
    }
    
    @After
    public void tearDown() throws Exception {
    	if (foroBD != null ) {
    		TestHelper.borrarDatos(foroBD, "ar.fiuba.redsocedu.datalayer.dtos.Foro", service, port);
    	}
    }
    
    @Test
    public void testCreateQueryUpdateAndDeleteForo() throws SAXException, IOException, ParserConfigurationException {
    	crearNuevoForoSinAmbito();
    	serializarForoNegocio();

    	guardarDatos(xmlForo, integracionWS);        
        System.out.println("XMl CONSULTA: \n" + xmlForo);
        String nuevoXmlForo = consultarDatos(xmlForo);
        System.out.println(nuevoXmlForo);
        if(nuevoXmlForo != null) {
        	foroBD = obtenerForoBD(nuevoXmlForo);
        }
    	Assert.assertTrue(foroBD != null);
	    if(foroBD == null || foroBD.getId() == null) {
	    	Assert.fail("No se pudo recuperar el foro");
	    }
    	this.foroNegocio.setId(this.foroBD.getId());
    	this.foroNegocio.setNombre(this.foroBD.getNombre());
    	
    	this.serializarForoNegocio();
    	String message = this.integracionWS.actualizarDatos(xmlForo);
    	Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), message);
	    String prefix = "<?xml version=\"1.0\"?><WS><Foro><id>";
	    String suffix = "</id></Foro></WS>";
	    String xmlForo = createDeleteForoByIdXML(prefix, suffix, foroBD);
	    if (xmlForo != "") {
	        message = integracionWS.eliminarDatos(xmlForo);
	    }
	    Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), message);    	
    }
    
	private void crearNuevoForoSinAmbito() {
		foroNegocio = new Foro();
		foroNegocio.setNombre("ForoNuevo");
	}
	
	@Test
	public void testSeccion() {
		String request = "<WS><Seccion><nombre>mi_seccion</nombre></Seccion></WS>";
		String response = integracionWS.guardarDatos(request);
		System.out.println(response);
		Assert.assertTrue(response.contains("exito"));
	}
	@Test
	public void testForoCompleto() {
		crearForoCompleto();
		serializarForoNegocio();
		String response = this.integracionWS.guardarDatos(xmlForo);
		Assert.assertTrue(response.contains("exito"));
	}
	
	private void crearForoCompleto() {
		foroNegocio = new Foro();
		Seccion seccion = new Seccion();
		Subforo subforo = new Subforo();
		Tema tema = new Tema();
		Mensaje mensaje = new Mensaje();
		
		//mensaje
		mensaje.setContenido("Hellooo!");
		mensaje.setUsername("flo"+System.currentTimeMillis());
		Long mensajeId = TestHelper.guardarDatos((ar.fiuba.redsocedu.datalayer.ws.Mensaje)mensaje.getDatabaseEntity(), "ar.fiuba.redsocedu.datalayer.dtos.Mensaje", service, port);
		assertCorrectlySaved(mensajeId);
		mensaje.setId(mensajeId);
		
		//tema
		tema.setAutor("pepe" + System.currentTimeMillis());
		List<com.ws.pojos.Mensaje> mensajes = new ArrayList<com.ws.pojos.Mensaje>(); 
		mensajes.add(mensaje);
		tema.setMensajes(mensajes);
		Long temaId = TestHelper.guardarDatos((ar.fiuba.redsocedu.datalayer.ws.Tema)tema.getDatabaseEntity(), "ar.fiuba.redsocedu.datalayer.pojos.Tema", service, port);
		assertCorrectlySaved(temaId);
		tema.setId(temaId);
		
		//subforo
		subforo.setNombre("subforo de flo");
		ArrayList<Tema> temas = new ArrayList<Tema>();
		temas.add(tema);
		subforo.setTemas(temas);
		Long subforoId = TestHelper.guardarDatos((ar.fiuba.redsocedu.datalayer.ws.Subforo)subforo.getDatabaseEntity(),"ar.fiuba.redsocedu.datalayer.dtos.Subforo", service, port);
		assertCorrectlySaved(subforoId);
		subforo.setId(subforoId);
		
		//seccion
		seccion.setNombre("La seccion");
		ArrayList<Subforo> subforos = new ArrayList<Subforo>();
		subforos.add(subforo);
		seccion.setSubforos(subforos);
		Long seccionId = TestHelper.guardarDatos((ar.fiuba.redsocedu.datalayer.ws.Seccion)seccion.getDatabaseEntity(),"ar.fiuba.redsocedu.datalayer.dtos.Seccion", service, port);
		assertCorrectlySaved(seccionId);
		seccion.setId(seccionId);
		
		List<Seccion> secciones = new ArrayList<Seccion>();
		secciones.add(seccion);
		this.foroNegocio.setSecciones(secciones);
	}

	private void assertCorrectlySaved(Long id) {
		if(id <=0) {
			Assert.fail("no se puede almacenar, id:" + id);
		}
	}
	private void serializarForoNegocio() {
		XStream xstream = new XStream();
		xstream.alias(ForoTags.CLASS_TAG, Foro.class);
		xstream.aliasField(ForoTags.ID_TAG, Foro.class, "id");
		xstream.omitField(Foro.class, "foroId");
		xstream.aliasField(ForoTags.NOMBRE_TAG, Foro.class, "nombre");
		xstream.aliasField(ForoTags.ID_AMBITO_TAG, Foro.class, "ambitoId");
		xmlForo = xstream.toXML(foroNegocio);
		xmlForo = "<WS>"+xmlForo+"</WS>";
	}

    private void guardarDatos(String xml, IntegracionWS integracionWS) {
    	String mensaje = integracionWS.guardarDatos(xml);
        if (!mensaje.contains("La entidad ha sido almacenada con exito")) {
            Assert.fail("no se pudieron guardar los datos de: " + xml + "mensaje obtenido: " + mensaje);
        }
    }
    
    private String consultarDatos(String xml) {
        String foros = integracionWS.seleccionarDatos(xml);
        if (foros == null || foros == "") {
            Assert.fail("no se pudieron obtener los datos de: " + xml);
        }
        return foros;
    }

    private ar.fiuba.redsocedu.datalayer.ws.Foro obtenerForoBD(String xml) throws SAXException, IOException, ParserConfigurationException {
        ForoParser parser = new ForoParser();
		xml =xml.replace("<list>","" );
		xml =xml.replace("</list>","" );
        return (ar.fiuba.redsocedu.datalayer.ws.Foro) parser.getDBObjectFromBusinessXML(xml);
        
    }


    private String createDeleteForoByIdXML(String preffix, String suffix, ar.fiuba.redsocedu.datalayer.ws.Foro foro) {
        if (foro.getId() != null) {
            return preffix + foro.getId().toString() + suffix;
        }
        return "";
    }
}

