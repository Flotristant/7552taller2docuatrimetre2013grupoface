package com.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;
import com.utils.NotificacionFactory;
import com.ws.parsers.ForoParser;
import com.ws.pojos.Foro;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;

public class ForoTest {

	String xmlForo;
	Foro foroNegocio;
	ar.fiuba.redsocedu.datalayer.ws.Foro foroBD;
	IntegracionWS integracionWS;
	
    @Before
    public void setUp() throws Exception {
    	crearNuevoForoSinAmbito();
    	serializarForoNegocio();
    	integracionWS = new IntegracionWS();
        IntegracionWS.setMockService(false);  
    }
    
    @Test
    public void CreateQueryUpdateAndDeleteForo() throws SAXException, IOException, ParserConfigurationException {
        guardarDatos(xmlForo, integracionWS);        
        System.out.println("XMl CONSULTA: \n" + xmlForo);
        String nuevoXmlForo = consultarDatos(xmlForo);
        System.out.println(nuevoXmlForo);
        if(nuevoXmlForo != null) {
        	foroBD = obtenerForoBD(nuevoXmlForo);
        }
    	Assert.assertTrue(foroBD != null);
	    if(foroBD == null || foroBD.getId() == null) {
	    	Assert.fail("No se pudo recuperar el usuario");
	    }
    	this.foroNegocio.setId(this.foroBD.getId());
    	this.foroNegocio.setNombre(this.foroBD.getNombre());
    	
    	this.serializarForoNegocio();
    	String message = this.integracionWS.actualizarDatos(xmlForo);
    	Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), message);
	    String prefix = "<?xml version=\"1.0\"?><WS><Usuario><id>";
	    String suffix = "</id></Usuario></WS>";
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
	
	private void serializarForoNegocio() {
		XStream xstream = new XStream();
		xstream.alias("Foro", Foro.class);
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

