package com.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.thoughtworks.xstream.XStream;
import com.utils.NotificacionFactory;
import com.ws.handler.UsuarioHandlerMock;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;
import com.ws.tags.UsuarioTags;

public class UsuarioTestIntegration {

	//ATENCION: el nombre del usuario tiene que ser uno que no exista en la BD si no se corre en modo mock.
	private static String xmlUser1;
    private Usuario usuarioBD;
    private com.ws.pojos.Usuario usuarioNegocio;
    private IntegracionWS integracionWS;

    @Before
    public void setUp() throws Exception {
    	crearUsuarioNegocio();
    	serializarUsuarioNegocio();

    	integracionWS = new IntegracionWS();
        IntegracionWS.setMockService(false);  
        //guardarDatos(xmlUser1, integracionWS);
        
        System.out.println(xmlUser1);
        integracionWS.eliminarDatos(xmlUser1);
        String nuevoXml1 = consultarDatos(xmlUser1);
        if(nuevoXml1 != null) {
        	usuarioBD = obtenerUsuario(nuevoXml1);
        }
    }

	private void serializarUsuarioNegocio() {
		XStream xstream = new XStream();
		xstream.alias("Usuario", Usuario.class);
        xmlUser1 = xstream.toXML(usuarioNegocio);
        xmlUser1 = "<WS>"+xmlUser1+"</WS>";
	}

	private void crearUsuarioNegocio() {
		usuarioNegocio = new com.ws.pojos.Usuario();
		//usuarioNegocio.setId(172L);
        usuarioNegocio.setUsername("fl0r3nc1a750");
        usuarioNegocio.setPassword("123456");
        usuarioNegocio.setActivado(true);
        usuarioNegocio.setHabilitado(true);
	}

    @After
    public void cleanUp() throws Exception {
        IntegracionWS integracionWS = new IntegracionWS();
        if(usuarioBD == null) {
        	return;
        }
        String prefix = "<?xml version=\"1.0\"?><WS><Usuario><id>";
        String suffix = "</id></Usuario></WS>";
        String xmlUser1 = createDeleteUserByIdXML(prefix, suffix, usuarioBD);
        if (xmlUser1 != "") {
            integracionWS.eliminarDatos(xmlUser1);
        }
    }
    
    @Test
    public void CreateQueryAndDeleteUser() {
    	Assert.assertTrue(usuarioBD != null);
    }

    
    private Usuario obtenerUsuario(String xml) throws SAXException, IOException, ParserConfigurationException {
        UsuarioParser parser = new UsuarioParser();
		xml =xml.replace("<list>","" );
		xml =xml.replace("</list>","" );
        return (Usuario) parser.getDBObject(xml);
        
    }

    
    private void guardarDatos(String xml, IntegracionWS integracionWS) {
        if (!integracionWS.guardarDatos(xml).equals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()))) {
            Assert.fail("no se pudieron guardar los datos de: " + xml);
        }
    }

    private String consultarDatos(String xml) {
        String usuarios = integracionWS.seleccionarDatos(xml);
        if (usuarios == null || usuarios == "") {
            Assert.fail("no se pudieron obtener los datos de: " + xml);
        }
        return usuarios;
    }

    private String createDeleteUserByIdXML(String preffix, String suffix, Usuario user) {
        if (user.getUsuarioId() != null) {
            return preffix + user.getUsuarioId().toString() + suffix;
        }
        return "";
    }

    private String createDeleteUserByUsernameXML(Usuario user) {
        if (user.getUsername() != null) {
            return "<?xml version=\"1.0\"?><WS><Usuario><username>" + user.getUsername() + "</username></Usuario></WS>";
        }
        return "";
    }
    
    /*
    @Test
    public void removeByIdTest() {
        String prefix = "<?xml version=\"1.0\"?><WS><Usuario><id>";
        String suffix = "</id></Usuario></WS>";
        
        if((usuarioBD.getUsuarioId() == null) && (integracionWS.isMock())) {
        	usuarioBD.setUsuarioId(1L);
        }

        String xml1 = createDeleteUserByIdXML(prefix, suffix, usuarioBD);
        
        if(integracionWS.isMock()) {
        	integracionWS.guardarDatos(xml1);
        }        
        
        Object obteinedMessage = integracionWS.eliminarDatos(xml1);
        Object expectedMessage = NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
        
        String validacion = "notificacion de exito";
        Assert.assertEquals(validacion, obteinedMessage, expectedMessage);
    }

    @Test
    public void removeByUsernameTest() {
        String xml1 = createDeleteUserByUsernameXML(usuarioBD);
        
        Object obteinedMessage = integracionWS.eliminarDatos(xml1);
        Object expectedMessage = NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
        
        String errorMessage = "No se pudo eliminar el usuario: " + xml1;
        Assert.assertEquals(errorMessage, obteinedMessage, expectedMessage);
    }

    /*
    @Test
    public void selectOneUserTest() {
        try {
            String xml = createSelectUserXML(usuarioBD);
            String salida = integracionWS.seleccionarDatos(xml);
            System.out.println("Datos selección: " + salida);
            
            String notExpectedMessage = NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
            Assert.assertNotSame(notExpectedMessage, salida);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String createSelectUserXML(Usuario usuario) {
        return "<?xml version=\"1.0\"?><WS><Usuario><username>usuario_prueba1</username></Usuario></WS>";
    }

    @Test
    public void saveOneUserTest() {
        String xml = createCreateUserXML(usuarioBD);

        Object obteinedMessage = NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
        Object expectedMessage = integracionWS.guardarDatos(xml);
        
        String errorMessage = "No se pudo guardar el usuario: " + xml;
        Assert.assertEquals(errorMessage, obteinedMessage, expectedMessage);        
    }

    private String createCreateUserXML(Usuario usuario) {
        return "<?xml version=\"1.0\"?><WS><Usuario><username>" + usuario.getUsername() + "</username><password>" + usuario.getPassword() + "</password><activado>" + usuario.isActivado().toString() + "</activado><habilitado>" + usuario.isHabilitado().toString() + "</habilitado></Usuario></WS>";
    }

    @Test
    public void updateOneUserTest() {
        String xml = createUpdateUserXML(usuarioBD);
        
        Object obteinedMessage = NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
        Object expectedMessage = integracionWS.eliminarDatos(xml);
        
        String errorMessage = "No se pudo actualizar el usuario: " + xml;
        Assert.assertEquals(errorMessage, obteinedMessage, expectedMessage);        
    }

    private String createUpdateUserXML(Usuario usuario) {
        if (usuario.getUsuarioId() != null) {
            return "<?xml version=\"1.0\"?><WS><Usuario><id>" + usuario.getUsuarioId().toString() + "</id><username>" + usuario.getUsername() + "</username><password>" + usuario.getPassword() + "</password><activado>" + usuario.isActivado() + "</activado><habilitado>" + usuario.isHabilitado() + "</habilitado></Usuario></WS>";
        } else {
            return "<?xml version=\"1.0\"?><WS><Usuario><username>" + usuario.getUsername() + "</username><password>" + usuario.getPassword() + "</password><activado>" + usuario.isActivado() + "</activado><habilitado>" + usuario.isHabilitado() + "</habilitado></Usuario></WS>";
        }

    }*/

}
