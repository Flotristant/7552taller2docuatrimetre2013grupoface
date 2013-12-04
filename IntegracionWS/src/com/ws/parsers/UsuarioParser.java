package com.ws.parsers;

import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.ws.pojos.Usuario;
import com.ws.tags.UsuarioTags;

public class UsuarioParser extends Parser {

	
	public UsuarioParser() {
		super(UsuarioTags.CLASS_TAG);
	}
	
	@Override
	public Long getId(){		
		return Long.parseLong((String)this.campos.get(UsuarioTags.ID_TAG));
	}
	
	
//	public Map<String, String> inicializarCampos(String xml) {
//		xml = limpiarXML(xml);		
//		xml = xml.replace("<Usuario>", "<com.ws.pojos.Usuario>");
//		XStream xstream = new XStream();
//		com.ws.pojos.Usuario usuario = (com.ws.pojos.Usuario) xstream.fromXML(xml);
//		if (usuario.getHabilitado() != null) {
//			this.campos.put(UsuarioTags.HABILITADO_TAG, usuario.getHabilitado().toString());
//		}
//		if (usuario.getActivado() != null) {
//			this.campos.put(UsuarioTags.ACTIVADO_TAG, usuario.getActivado().toString());
//		}
//		if (usuario.getId() != null) {
//			this.campos.put(UsuarioTags.ID_TAG, usuario.getId().toString());
//		}
//		if (usuario.getNombre() != null) {
//			this.campos.put(UsuarioTags.NOMBRE_TAG, usuario.getNombre());
//		}
//		if (usuario.getApellido() != null) {
//			this.campos.put(UsuarioTags.APELLIDO_TAG, usuario.getApellido());
//		}
//		if (usuario.getUsername() != null) {
//			this.campos.put(UsuarioTags.USERNANME_TAG, usuario.getUsername());
//		}
//		if (usuario.getPassword() != null) {
//			this.campos.put(UsuarioTags.PASSWORD_TAG, usuario.getPassword());
//		}
//		if (usuario.getEmail() != null) {
//			this.campos.put(UsuarioTags.EMAIL_TAG, usuario.getEmail());
//		}
//		if (usuario.getFechaNacimiento() != null) {
//			this.campos.put(UsuarioTags.FECHANAC_TAG, usuario.getFechaNacimiento().toString());
//		}
//		return this.campos;
//	}
	
	private String limpiarXML(String xml) {
		xml =xml.replace("<WS>","" );
		xml =xml.replace("</WS>","" );
		return xml;
	}
	
	/**
	 * Este método recibe el xml de negocio y lo transforma en un pojo de la BD
	 */
	@Override
	public Object getDBObject(String xml) {
		xml = xml.replace("<Usuario>", "<com.ws.pojos.Usuario>");
		xml = xml.replace("</Usuario>", "</com.ws.pojos.Usuario>");
		//transformo a un Usuario de negocio
		XStream xmlReader = new XStream();
		xml = removeSuperTags(xml);
		Usuario usuario = (Usuario) xmlReader.fromXML(xml);
		//Con el usuario de negocio armo un usuario de DB
		ar.fiuba.redsocedu.datalayer.ws.Usuario DBUser = new ar.fiuba.redsocedu.datalayer.ws.Usuario();
		DBUser.setActivado(usuario.getActivado());
		DBUser.setHabilitado(usuario.getHabilitado());
		DBUser.setEmail(usuario.getEmail());
		DBUser.setNombre(usuario.getNombre());
		DBUser.setApellido(usuario.getApellido());
		DBUser.setUsername(usuario.getUsername());
		DBUser.setPassword(usuario.getPassword());
		DBUser.setPadron(usuario.getPadron());
		DBUser.setUsuarioId(usuario.getId());
		return DBUser;
		//DBUser.setRolId(usuario.getIdRol());
	}

	private String removeSuperTags(String xml) {
		xml = xml.replace("<WS>", "");
		xml = xml.replace("</WS>", "");
		return xml;
	}

	/**
	 * Este método retorna una instancia de usuario que representa el Usuario en la capa de Negocio.
	 * @return
	 */

	@Override
	public Object getEntidad(String xml) {
		xml = xml.replace("<Usuario>", "<com.ws.pojos.Usuario>");
		xml = xml.replace("</Usuario>", "</com.ws.pojos.Usuario>");
		//transformo a un Usuario de negocio
		XStream xmlReader = new XStream();
		xml = removeSuperTags(xml);
		return (Usuario) xmlReader.fromXML(xml);
	}
	
	
//	private XMLGregorianCalendar stringToXMLGregorianCalendar(String s) throws ParseException, 
//																		DatatypeConfigurationException {
//		XMLGregorianCalendar result = null;
//		Date date;
//		SimpleDateFormat simpleDateFormat;
//		GregorianCalendar gregorianCalendar;
//
//		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss");
//        try {
//			date = simpleDateFormat.parse(s);
//			gregorianCalendar = 
//		    (GregorianCalendar)GregorianCalendar.getInstance();
//		    gregorianCalendar.setTime(date);
//		    result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
//		} catch (java.text.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}        
//        
//        return result;
//	}


}
