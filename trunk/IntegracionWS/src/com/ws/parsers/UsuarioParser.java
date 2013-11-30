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
		
		return Long.parseLong(this.campos.get(UsuarioTags.ID_TAG));
	}
	
	/**
	 * Este método recibe el xml de negocio y lo transforma en un pojo de la BD
	 */
	public ar.fiuba.redsocedu.datalayer.ws.Usuario getDBUser(String xml) {
		XStream xmlReader = new XStream();
		Usuario usuario = (Usuario) xmlReader.fromXML(xml);
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


	/**
	 * Este método retorna una instancia de usuario que representa el Usuario en la capa de Negocio.
	 * @return
	 */

	@Override
	public Object getEntidad() {
		Usuario usuario = new Usuario();
		
		usuario.setUsername(this.campos.get(UsuarioTags.USERNANME_TAG));
		usuario.setPassword (this.campos.get(UsuarioTags.PASSWORD_TAG));
		usuario.setNombre(this.campos.get(UsuarioTags.NOMBRE_TAG));
		usuario.setApellido(this.campos.get(UsuarioTags.APELLIDO_TAG));
		usuario.setPadron(this.campos.get(UsuarioTags.PADRON_TAG));
		usuario.setEmail(this.campos.get(UsuarioTags.EMAIL_TAG));
	
		if(this.campos.get(UsuarioTags.ID_TAG) != null) {
			usuario.setId(Long.parseLong(this.campos.get(UsuarioTags.ID_TAG)));
		}
		
		//Conversion de fecha a XMLGregorianCalendar
		//XMLGregorianCalendar fecha;
		if(this.campos.get(UsuarioTags.FECHANAC_TAG) != null)
		{
			//fecha = XmlGregorianConverter.string2XMLGregorian((this.campos.get(UsuarioTags.FECHANAC_TAG)));
			usuario.setFechaNacimiento(this.campos.get(UsuarioTags.FECHANAC_TAG));
		}
		usuario.setHabilitado(Boolean.parseBoolean(this.campos.get(UsuarioTags.HABILITADO_TAG)));
		usuario.setActivado(Boolean.parseBoolean(this.campos.get(UsuarioTags.ACTIVADO_TAG)));
		
		return usuario;
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
