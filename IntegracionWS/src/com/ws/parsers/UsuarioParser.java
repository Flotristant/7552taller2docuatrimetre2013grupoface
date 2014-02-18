package com.ws.parsers;

import com.ws.pojos.Usuario;
import com.ws.tags.ActividadTags;
import com.ws.tags.EventoTags;
import com.ws.tags.GrupoTags;
import com.ws.tags.NotaTags;
import com.ws.tags.UsuarioTags;

public class UsuarioParser extends Parser {
	
	public UsuarioParser() {
		super(UsuarioTags.CLASS_TAG);
		this.relaciones_directas.put(ActividadParser.class.toString(), "actividades");
		this.relaciones_directas.put(NotaParser.class.toString(), "notas");
		this.relaciones_directas.put(GrupoParser.class.toString(), "grupos");
	}
	
	@Override
	public Long getId(){		
		return Long.parseLong((String)this.campos.get(UsuarioTags.ID_TAG));
	}
	
	/**
	 * Este método recibe el xml de negocio y lo transforma en un pojo de la BD
	 */
	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		//obtengo la entidad de usuario desde el xml de negocio.
		Usuario usuario = (Usuario) getEntidadNegocio(xml);
		return usuario.getDatabaseEntity();
		//DBUser.setRolId(usuario.getIdRol());
	}

	private String removeSuperTags(String xml) {
		xml = xml.replace("<WS>", "");
		xml = xml.replace("</WS>", "");
		return xml;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace("<" + NotaTags.CLASS_TAG + ">", "com.ws.pojos."
				+ NotaTags.CLASS_TAG);
		xml = xml.replace("<" + GrupoTags.CLASS_TAG + ">", "com.ws.pojos."
				+ GrupoTags.CLASS_TAG);
		xml = xml.replace("<" + ActividadTags.CLASS_TAG + ">", "com.ws.pojos."
				+ ActividadTags.CLASS_TAG);
		return xml;
	}

}
