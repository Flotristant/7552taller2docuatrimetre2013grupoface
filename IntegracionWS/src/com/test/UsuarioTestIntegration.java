package com.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.utils.NotificacionFactory;
import com.ws.handler.UsuarioHandlerMock;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;

public class UsuarioTestIntegration {

    Usuario usuario1, usuario2;

    @Before
    public void setUp() throws Exception {
        IntegracionWS integracionWS = new IntegracionWS();
        IntegracionWS.setNotMockService();
        String xmlUser1 = "<?xml version=\"1.0\"?><WS><Usuario><username>usuario_prueba1</username><password>1234</password><activado>true</activado><habilitado>true</habilitado></Usuario></WS>";

        guardarDatos(xmlUser1, integracionWS);

        String nuevoXml1 = consultarDatos(xmlUser1, integracionWS);
        usuario1 = obtenerUsuario(nuevoXml1, integracionWS);
    }

    @After
    public void cleanUp() throws Exception {
        IntegracionWS integracionWS = new IntegracionWS();
        String prefix = "<?xml version=\"1.0\"?><WS><Usuario><id>";
        String suffix = "</id></Usuario></WS>";
        String xmlUser1 = createDeleteUserByIdXML(prefix, suffix, usuario1);
        if (xmlUser1 != "") {
            integracionWS.eliminarDatos(xmlUser1);
        }
    }

    private Usuario obtenerUsuario(String xml, IntegracionWS integracionWS) throws SAXException, IOException, ParserConfigurationException {
        xml = xml.replace("\n", "");
        xml = xml.replace(" ", "");
        UsuarioHandlerMock handler = new UsuarioHandlerMock();
        UsuarioParser parser1 = new UsuarioParser();
        parser1.inicializarDocumento(integracionWS.getXMLDocument(xml));
        return (Usuario) handler.toDatabaseEntity((com.ws.pojos.Usuario) parser1.getEntidad());
    }

    private void guardarDatos(String xml, IntegracionWS integracionWS) {
        if (!integracionWS.guardarDatos(xml).equals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()))) {
            Assert.fail("no se pudieron guardar los datos de: " + xml);
        }
    }

    private String consultarDatos(String xml, IntegracionWS integracionWS) {
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
    
    @Test
    public void removeByIdTest() {
        IntegracionWS integracionWS = new IntegracionWS();
        String prefix = "<?xml version=\"1.0\"?><WS><Usuario><id>";
        String suffix = "</id></Usuario></WS>";
        String xml1 = createDeleteUserByIdXML(prefix, suffix, usuario1);
        
        Object obteinedMessage = integracionWS.eliminarDatos(xml1);
        Object expectedMessage = NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
        
        String errorMessage = "No se pudo eliminar el usuario: " + xml1;
        Assert.assertEquals(errorMessage, obteinedMessage, expectedMessage);
    }

    @Test
    public void removeByUsernameTest() {
        IntegracionWS integracionWS = new IntegracionWS();
        String xml1 = createDeleteUserByUsernameXML(usuario1);
        
        Object obteinedMessage = integracionWS.eliminarDatos(xml1);
        Object expectedMessage = NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
        
        String errorMessage = "No se pudo eliminar el usuario: " + xml1;
        Assert.assertEquals(errorMessage, obteinedMessage, expectedMessage);
    }

    @Test
    public void selectOneUserTest() {
        try {
            IntegracionWS integracionWS = new IntegracionWS();
            String xml = createSelectUserXML(usuario1);
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
        IntegracionWS integracionWS = new IntegracionWS();
        String xml = createCreateUserXML(usuario1);

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
        IntegracionWS integracionWS = new IntegracionWS();
        String xml = createUpdateUserXML(usuario1);
        
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

    }

}
