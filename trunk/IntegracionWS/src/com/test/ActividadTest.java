package com.test;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Actividad;
import ar.fiuba.redsocedu.datalayer.ws.Ambito;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.thoughtworks.xstream.XStream;
import com.utils.NotificacionFactory;
import com.ws.parsers.ActividadParser;
import com.ws.serializers.ActividadSerializer;
import com.ws.serializers.UsuarioSerializer;
import com.ws.serializers.XMLCalendarConverter;
import com.ws.services.IntegracionWS;
import com.ws.tags.UsuarioTags;

public class ActividadTest extends TestCase {
	Ambito ambito;
	
	DataService service;
	IData port;
	IntegracionWS ws;
	Actividad actividad;
	
	@Before 
	public void setUp() {
		ws = new IntegracionWS();
		service = new DataService();
		port = service.getDataPort();
		crearYguardarActividad();
	}
	
	public void crearYguardarActividad() {
		actividad = new ar.fiuba.redsocedu.datalayer.ws.Actividad();
		actividad.setNombre("MiActividadParaModificar");
		actividad.setTipo("Individual");
		actividad.setDescripcion("descripcion");
		actividad.setFechaInicio(111111L);
		actividad.setFechaFin(121212L);
		Long id_actividad = TestHelper.guardarDatos(actividad, "ar.fiuba.redsocedu.datalayer.dtos.Actividad", service, port);
		actividad.setId(id_actividad);
	}
	
	@Test
	public void testGuardarActividad() throws Exception {
		String xml = "<?xml version=\"1.0\"?><WS><Actividad>" +
		"<nombre>El mago asesino</nombre>" +
		"<tipo>Individual</tipo>" +
		"<descripcion>nada q ver nada q oler</descripcion>" +
		"<fechaInicio>111111</fechaInicio>" +
		"<fechaFin>121212</fechaFin>" +
		"</Actividad></WS>";
		
		String mje = ws.guardarDatos(xml);
		System.out.println(mje);
		Assert.assertTrue(mje.contains(NotificacionFactory.ExitoGuardado("").getMensaje()));
	}
	
	@Test
	public void testActualizarActividad() {			
		String xml = "<WS><Actividad><id>"+actividad.getId()+"</id>" +
		"<nombre>Modifico</nombre>" +
		"<tipo>Individual</tipo>" +
		"<descripcion>Cabio descripción</descripcion>" +
		"<fechaInicio>111111</fechaInicio>" +
		"<fechaFin>121212</fechaFin>" +
		"</Actividad></WS>";
		String mje = ws.actualizarDatos(xml);
		System.out.println(mje);
		Assert.assertTrue(mje.contains(NotificacionFactory.Exito().getMensaje()));
	}

	@Test
	public void testGuardarActividadConAmbito() {
		ambito = new Ambito();
		Long id_ambito = TestHelper.guardarDatos(ambito, "ar.fiuba.redsocedu.datalayer.dtos.Ambito", service, port);
		ambito.setAmbitoId(id_ambito);
		ambito.setId(id_ambito);
		
		String xml = "<?xml version=\"1.0\"?><WS><Actividad><nombre>Actividad con ambito</nombre>" +
					"<tipo>Individual</tipo><ambitoSuperiorId>" + id_ambito.toString() + "</ambitoSuperiorId>" +
					"<descripcion>SE prueba guarar una actividad con un ambito superior</descripcion>" +
					"<fechaInicio>111111</fechaInicio><fechaFin>121212</fechaFin></Actividad></WS>";
		String mje = ws.guardarDatos(xml);
		System.out.println(mje);
		Assert.assertTrue(mje.contains(NotificacionFactory.ExitoGuardado("").getMensaje()));
	} 
	
	@Test
	public void testGuardarYObtenerActividadConAmbito() {
		ambito = new Ambito();
		Long id_ambito = TestHelper.guardarDatos(ambito, "ar.fiuba.redsocedu.datalayer.dtos.Ambito", service, port);
		ambito.setAmbitoId(id_ambito);
		ambito.setId(id_ambito);
		this.actividad.setAmbitoSuperiorId(id_ambito);
		Long id_actividad = TestHelper.guardarDatos(actividad, "ar.fiuba.redsocedu.datalayer.dtos.Actividad", service, port);
		Assert.assertEquals(actividad.getId(), id_actividad);
		
		String mje = ws.seleccionarDatos("<WS><Actividad><id>"+actividad.getId()+"</id></Actividad></WS>");
		System.out.println(mje);
		Assert.assertFalse(mje.contains(NotificacionFactory.Error().getMensaje()) || 
				mje.contains(NotificacionFactory.sinResultados().getMensaje()));
	}
	
	@Test
	public void testGuardarActividadConAmbitoyUsuarios() {
		ambito = new Ambito();
		Long id_ambito = TestHelper.guardarDatos(ambito, "ar.fiuba.redsocedu.datalayer.dtos.Ambito", service, port);
		ambito.setAmbitoId(id_ambito);
		ambito.setId(id_ambito);
		
		String xml = "<?xml version=\"1.0\"?><WS><Actividad>" +
					"<nombre>Actividad con ambito</nombre>" +
					"<tipo>Individual</tipo><ambitoSuperiorId>" + id_ambito.toString() + "</ambitoSuperiorId>" +
					"<descripcion>SE prueba guarar una actividad con un ambito superior</descripcion>" +
					"<fechaInicio>111111</fechaInicio><fechaFin>121212</fechaFin>" +
					"<usuarios><Usuario><id>60</id></Usuario></usuarios>"+
					"</Actividad></WS>";
		String mje = ws.guardarDatos(xml);
		System.out.println(mje);
		Assert.assertTrue(mje.contains(NotificacionFactory.ExitoGuardado("").getMensaje()));
	}
	
	@Test
	public void testSerializacionActividadConUsuario() {
		
		String xml = "<?xml version=\"1.0\"?><WS><Actividad>" +
				"<nombre>Actividad con ambito</nombre>" +
				"<tipo>Individual</tipo><ambitoSuperiorId>3</ambitoSuperiorId>" +
				"<descripcion>SE prueba guarar una actividad con un ambito superior</descripcion>" +
				"<fechaInicio>111111</fechaInicio><fechaFin>121212</fechaFin>" +
				"<usuarios><Usuario><id>60</id></Usuario></usuarios>"+
				"</Actividad></WS>";
		ActividadParser ap = new ActividadParser();
		
		Actividad act = (Actividad)ap.getDBObjectFromBusinessXML(xml);
		
		ActividadSerializer as = new ActividadSerializer();
		
		String salida = as.getXMLfromPojo(act);
		
		System.out.println(salida);
	}
	
	@Test
	public void testDesasociarUsuarioEnActividad() {
		List<com.ws.pojos.Usuario> usuarios_habilitados =getUsuariosHabilitados();
		com.ws.pojos.Actividad actividadNegocio = new com.ws.pojos.Actividad();
		actividadNegocio.setUsuarios(usuarios_habilitados);
		XStream xstream = new XStream();
		String actividadXML = xstream.toXML(actividadNegocio);
		actividadXML = "<WS>"+actividadXML+"</WS>";
		String saveResponse = ws.guardarDatos(actividadXML);
		System.out.println(saveResponse);
		Assert.assertTrue(saveResponse.contains("exito"));
	}

	private List<com.ws.pojos.Usuario> getUsuariosHabilitados() {
		com.ws.pojos.Usuario usuarioFiltro = new com.ws.pojos.Usuario();
		usuarioFiltro.setHabilitado(true);
		XStream converter = new XStream();
		String userXML = converter.toXML(usuarioFiltro);
		userXML = "<WS>"+userXML+"</WS>";
		String responseUsers = this.ws.seleccionarDatos(userXML);
		System.out.println(responseUsers);
		responseUsers = responseUsers.replace("<WS>", "");
		responseUsers = responseUsers.replace("</WS>", "");
		setAttributeMappings(converter);
		return (List<com.ws.pojos.Usuario>)converter.fromXML(responseUsers);
	}
	
	private void setAttributeMappings(XStream xstream) {
		
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(UsuarioTags.CLASS_TAG, com.ws.pojos.Usuario.class);
		
		//Mapeos de los nombres de atributo
		xstream.aliasField(UsuarioTags.ID_TAG, Usuario.class, "id");
		xstream.omitField(Usuario.class, "usuarioId");
		xstream.aliasField(UsuarioTags.ACTIVADO_TAG, Usuario.class, "activado");
		xstream.aliasField(UsuarioTags.APELLIDO_TAG, Usuario.class, "apellido");
		xstream.aliasField(UsuarioTags.EMAIL_TAG, Usuario.class, "email");
		xstream.aliasField(UsuarioTags.FECHANAC_TAG, Usuario.class, "fechaNac");
		xstream.aliasField(UsuarioTags.HABILITADO_TAG, Usuario.class, "habilitado");
		xstream.aliasField(UsuarioTags.NOMBRE_TAG, Usuario.class, "nombre");
		xstream.aliasField(UsuarioTags.PADRON_TAG, Usuario.class, "padron");
		xstream.aliasField(UsuarioTags.PASSWORD_TAG, Usuario.class, "password");
		xstream.aliasField(UsuarioTags.USERNANME_TAG, Usuario.class, "username");
//		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		
		//alias implementacion interfaz
		xstream.alias("fechaNac", XMLGregorianCalendar.class, XMLGregorianCalendarImpl.class);

		
		//Conversor de la clase XMLGregorian para que devuelva la fecha en el formato indicado
		xstream.registerConverter(new XMLCalendarConverter());
	}
	
	
}
