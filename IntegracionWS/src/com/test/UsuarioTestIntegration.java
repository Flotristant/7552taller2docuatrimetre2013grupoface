package com.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import ar.fiuba.redsocedu.datalayer.ws.Actividad;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.thoughtworks.xstream.XStream;
import com.utils.NotificacionFactory;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;

public class UsuarioTestIntegration extends TestCase {

	//ATENCION: el nombre del usuario tiene que ser uno que no exista en la BD si no se corre en modo mock.
	private static String xmlUser;
    private Usuario usuarioBD;
    private com.ws.pojos.Usuario usuarioNegocio;
	private IntegracionWS integracionWS;
	private DataService service;
	private IData port;

    @Before
    public void setUp() throws Exception {
    	crearNuevoUsuarioNegocio();
    	serializarUsuarioNegocio();
    	integracionWS = new IntegracionWS();
        IntegracionWS.setMockService(false); 
        try {
        	this.service = new DataService();
        	this.port = service.getDataPort();
        } catch (Exception e) {
        	Assert.fail("no se pudo crear el puerto y/o el servicio");
        }
    }
    
    @Test
    public void testCreateQueryUpdateAndDeleteUser() throws SAXException, IOException, ParserConfigurationException {
        guardarDatos(xmlUser, integracionWS);        
        System.out.println(xmlUser);
        String nuevoXml1 = consultarDatos(xmlUser);
        System.out.println(nuevoXml1);
        if(nuevoXml1 != null) {
        	usuarioBD = obtenerUsuarioBD(nuevoXml1);
        }
    	Assert.assertTrue(usuarioBD != null);
	    if(usuarioBD == null || usuarioBD.getId() == null) {
	    	Assert.fail("No se pudo recuperar el usuario");
	    }
    	this.usuarioNegocio.setId(this.usuarioBD.getId());
    	this.usuarioNegocio.setEmail("lalala@gmail.com");
    	this.serializarUsuarioNegocio();
    	String message = this.integracionWS.actualizarDatos(xmlUser);
    	Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), message);
    	if(this.integracionWS.isMock()) {
    		message = integracionWS.eliminarDatos(xmlUser);
    		Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), message);
    	} else {
    		String prefix = "<?xml version=\"1.0\"?><WS><Usuario><id>";
    		String suffix = "</id></Usuario></WS>";
    		String xmlUser1 = createDeleteUserByIdXML(prefix, suffix, usuarioBD);
    		if (xmlUser1 != "") {
    			message = integracionWS.eliminarDatos(xmlUser1);
    		}
    		Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), message);
    	}
    }
    
    @Test
    public void testUpdateUser() throws SAXException, IOException, ParserConfigurationException {
    	guardarDatos(xmlUser, integracionWS);        
    	System.out.println(xmlUser);
    	String nuevoXml1 = consultarDatos(xmlUser);
    	System.out.println(nuevoXml1);
    	if(nuevoXml1 != null) {
    		usuarioBD = obtenerUsuarioBD(nuevoXml1);
    	}
    	if(usuarioBD == null || usuarioBD.getId() == null) {
    		Assert.fail("No se pudo recuperar el usuario");
    	}
    	this.usuarioNegocio.setId(this.usuarioBD.getId());
    	this.usuarioNegocio.setEmail("lalala@gmail.com");
    	this.serializarUsuarioNegocio();
    	String message = this.integracionWS.actualizarDatos(xmlUser);
    	Assert.assertEquals(message, NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), message);
    }
    
    
    @Test
    public void testguardarUsuarioConActividades() {
    	com.ws.pojos.Actividad actividad = new com.ws.pojos.Actividad();
    	Long lal =  System.currentTimeMillis()/1000L;
    	actividad.setNombre("actividadPrueba" + lal.toString());
    	actividad.setDescripcion("actividad de prueba con usuario");
    	actividad.setFechaInicio(111111L);
    	actividad.setFechaFin(121212L);  
    	actividad.setTipo("Individual");

    	Actividad actividadDB = (Actividad) actividad.getDatabaseEntity();
    	Long id_actividad = TestHelper.guardarDatos(actividadDB, "ar.fiuba.redsocedu.datalayer.dtos.Actividad",service , port );
    	actividad.setId(id_actividad);
    	System.out.println("id de la actividad asociada: " + id_actividad);
    	if(id_actividad <= 0) {
    		Assert.fail("no se pudo guardar la actividad");
    	}
    	crearNuevoUsuarioNegocio();   
    	this.usuarioNegocio.setActividades(new ArrayList<com.ws.pojos.Actividad>());
    	this.usuarioNegocio.getActividades().add(actividad);
    	serializarUsuarioNegocio();
    	xmlUser=xmlUser.replace(" class=\"linked-list\"", "");
    	
    	String response =integracionWS.guardarDatos(xmlUser);
    	System.out.println(response);
    	Assert.assertTrue(response.contains("exito"));
    	
    	Long id = getId(response);
    	System.out.println(id);
    	String xml_consulta = "<WS><Usuario><id>"+id+"</id></Usuario></WS>";
    	response = integracionWS.seleccionarDatos(xml_consulta);
    	System.out.println(response);

    	xml_consulta = "<WS><Actividad><id>"+id_actividad+"</id></Actividad></WS>";
    	response = integracionWS.seleccionarDatos(xml_consulta);
    	System.out.println(response);
    	
    	xml_consulta = "<WS><Actividad><join><Usuario><id>"+id+"</id></Usuario></join></Actividad></WS>";
    	response = integracionWS.seleccionarDatos(xml_consulta);
    	System.out.println(response);
    }
    
    private Long getId(String response) {
    	String datos_inicio = "<datos>";
    	String datos_fin = "</datos>";
		int init = response.indexOf(datos_inicio);
		int end = response.indexOf(datos_fin);
    	if(init < 0 || end < 0) {
    		return 0L;
    	}
    	String value = response.substring(init + datos_inicio.length(), end);
    	return Long.parseLong(value);    	
    }
    
    @Test
    public void testObtenerMasDeUnUsuarioTest() {
    	usuarioNegocio = new com.ws.pojos.Usuario();
    	usuarioNegocio.setActivado(true);
    	usuarioNegocio.setHabilitado(true);
    	this.serializarUsuarioNegocio();
    	String nuevoXml1 = integracionWS.seleccionarDatos(xmlUser);
    	Assert.assertFalse(nuevoXml1, nuevoXml1.contains(NotificacionFactory.sinResultados().getMensaje()));
    }


	private void serializarUsuarioNegocio() {
		XStream xstream = new XStream();
		xstream.alias("Usuario", Usuario.class);
		//xstream.alias("Actividad", Actividad.class);
        xmlUser = xstream.toXML(usuarioNegocio);
        xmlUser = "<WS>"+xmlUser+"</WS>";
	}

	private void crearNuevoUsuarioNegocio() {
		usuarioNegocio = new com.ws.pojos.Usuario();
		String time = ((Long)System.currentTimeMillis()).toString();
        usuarioNegocio.setUsername("pupi"+time);
        usuarioNegocio.setPassword("123456");
        usuarioNegocio.setActivado(true);
        usuarioNegocio.setHabilitado(true);
	}
    
    private Usuario obtenerUsuarioBD(String xml) throws SAXException, IOException, ParserConfigurationException {
        UsuarioParser parser = new UsuarioParser();
		xml =xml.replace("<list>","" );
		xml =xml.replace("</list>","" );
        return (Usuario) parser.getDBObjectFromBusinessXML(xml);
        
    }
    
    private void guardarDatos(String xml, IntegracionWS integracionWS) {
    	String mensaje = integracionWS.guardarDatos(xml);
        if (!mensaje.contains("La entidad ha sido almacenada con exito")) {
            Assert.fail("no se pudieron guardar los datos de: " + xml + "mensaje obtenido: " + mensaje);
        }
    }

    private String consultarDatos(String xml) {
        String usuarios = integracionWS.seleccionarDatos(xml);
        if (usuarios == null || usuarios.isEmpty()) {
            Assert.fail("no se pudieron obtener los datos de: " + xml);
        }
        return usuarios;
    }

    private String createDeleteUserByIdXML(String preffix, String suffix, Usuario user) {
        if (user.getId() != null) {
            return preffix + user.getId().toString() + suffix;
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
    
    
    private String createDeleteUserByUsernameXML(Usuario user) {
        if (user.getUsername() != null) {
            return "<?xml version=\"1.0\"?><WS><Usuario><username>" + user.getUsername() + "</username></Usuario></WS>";
        }
        return "";
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
