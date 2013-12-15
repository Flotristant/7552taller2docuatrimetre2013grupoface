package com.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.utils.NotificacionFactory;
import com.ws.parsers.ActividadParser;
import com.ws.pojos.Actividad;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;

public class TestIntegracionActividad {
	private IntegracionWS integracionWS;
	
    @Before
    public void setUp() throws Exception {
    	this.integracionWS = new IntegracionWS();
        IntegracionWS.setMockService(false);
    }	
	
	//******************************************ACTIVIDAD************************************************\\
    @Test
    public void testActividad() {
        // guardar actividad
        Actividad actividad = crearActividadNegocio();
        String actividadXML = getActividadNegocioXML(actividad);
        String resultadoTransaccion = integracionWS.guardarDatos(actividadXML);
        Assert.assertTrue(resultadoTransaccion.contains("La entidad ha sido almacenada con exito"));

        // consultar actividad por props
        resultadoTransaccion = integracionWS.seleccionarDatos(actividadXML);
        Actividad actividad_leido = getMessageFromResult(resultadoTransaccion);
        assertActividadsIguales(actividad, actividad_leido);

        // consultar actividad por id
        Actividad actividad_con_solo_id = new Actividad();
        actividad_con_solo_id.setId(actividad_leido.getId());
        String resultadoTransaccion2 = integracionWS.seleccionarDatos(getActividadNegocioXML(actividad_con_solo_id));
        Actividad actividad_leido2 = getMessageFromResult(resultadoTransaccion2);
        assertActividadsIguales(actividad, actividad_leido2);        

        // eliminar actividad por id
        actividad.setId(actividad_leido.getId());
        resultadoTransaccion = integracionWS.eliminarDatos(getActividadNegocioXML(actividad));
        Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), resultadoTransaccion);
    }
    
    private Actividad getMessageFromResult(String resultadoTransaccion) {
		resultadoTransaccion=resultadoTransaccion.replace("<list>", "");
		resultadoTransaccion=resultadoTransaccion.replace("</list>", "");
        ActividadParser parser = new ActividadParser();
        Actividad actividad_leido = (Actividad) parser.getEntidadNegocio(resultadoTransaccion);
		return actividad_leido;
	}

	private void assertActividadsIguales(Actividad actividad, Actividad actividad_leida) {
		Assert.assertTrue(actividad_leida.getId() != null);
        Assert.assertEquals(actividad.getDescripcion(), actividad_leida.getDescripcion());
        Assert.assertEquals(actividad.getGruposExclusivo(), actividad_leida.getGruposExclusivo());
        Assert.assertEquals(actividad.getTipo(), actividad_leida.getTipo());
        Assert.assertEquals(actividad.getTipoEscala(), actividad_leida.getTipoEscala());
        Assert.assertEquals(actividad.getActividadSuperiorId(), actividad_leida.getActividadSuperiorId());
	}

    private Actividad crearActividadNegocio() {
        Actividad actividad = new Actividad();
        Long date = System.currentTimeMillis();
        actividad.setDescripcion("prueba integracion con Actividad"+date.toString());
        actividad.setNombre("mi actividad"+ date.toString());
        actividad.setFechaInicio(System.currentTimeMillis());
        actividad.setFechaFin(date + 2000L);
        actividad.setGruposExclusivo(false);
        actividad.setTipo("individual");
        actividad.setTipoEscala("");
        return actividad;
    }

    private String getActividadNegocioXML(Actividad actividad) {
    	XStream xstream = new XStream();
    	xstream.alias("Actividad", Actividad.class);
    	String xml = xstream.toXML(actividad);
    	return "<WS>"+xml+"</WS>";
    	
    }
}
