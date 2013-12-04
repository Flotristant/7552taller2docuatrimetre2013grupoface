package com.ws.parsers;

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
	
	/**
	 * Este método recibe el xml de negocio y lo transforma en un pojo de la BD
	 */
	@Override
	public Object getDBObject(String xml) {
		//obtengo la entidad de usuario desde el xml de negocio.
		Usuario usuario = (Usuario) getEntidadNegocio(xml);
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
