package com.ws.serializers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.ws.tags.UsuarioTags;

public class UsuarioSerializer {
	
	
	/*
	 * Esta clase permite manipular la forma en la que el Xstream arma el xml
	 * En este caso el XMLGregorianblahblah tiene que ajustarse a la fecha necesria
	 * por eso se manipula su salida. de ser necesario se sacará esta clase y hará publica.
	 */
	private static class XMLCalendarConverter extends AbstractSingleValueConverter {

		@SuppressWarnings("rawtypes")
        public boolean canConvert(Class clazz) {
        	return clazz.equals(XMLGregorianCalendarImpl.class);
        }
        
        public String toString(Object obj){
        	
        	if (obj == null) return "";
        	
        	XMLGregorianCalendarImpl fechaimp = (XMLGregorianCalendarImpl) obj;
        	
        	Calendar calendar = fechaimp.toGregorianCalendar();
        	
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss");
        	String dateString = formatter.format(calendar.getTime());
        	
        	return dateString;
        	
        }

		@Override
		public Object fromString(String arg0) {
			return null;
		}
	}
	
	/**
	 * Metodo que mapea todos los nombres de atributo desde los pojos de DB
	 * hacia los objetos de modelo. 
	 * @param xstream
	 */
	private static void setAttributeMappings(XStream xstream){
		
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(UsuarioTags.CLASS_TAG, Usuario.class);
		
		//Mapeos de los nombres de atributo
		xstream.aliasField(UsuarioTags.ID_TAG, Usuario.class, "usuarioId");
		xstream.aliasField(UsuarioTags.ACTIVADO_TAG, Usuario.class, "activado");
		xstream.aliasField(UsuarioTags.APELLIDO_TAG, Usuario.class, "apellido");
		xstream.aliasField(UsuarioTags.EMAIL_TAG, Usuario.class, "email");
		xstream.aliasField(UsuarioTags.FECHANAC_TAG, Usuario.class, "fechaNac");
		xstream.aliasField(UsuarioTags.HABILITADO_TAG, Usuario.class, "habilitado");
		xstream.aliasField(UsuarioTags.NOMBRE_TAG, Usuario.class, "nombre");
		xstream.aliasField(UsuarioTags.PADRON_TAG, Usuario.class, "padron");
		xstream.aliasField(UsuarioTags.PASSWORD_TAG, Usuario.class, "password");
		xstream.aliasField(UsuarioTags.USERNANME_TAG, Usuario.class, "username");
		
		//alias implementacion interfaz
		xstream.alias("fechaNac", XMLGregorianCalendar.class, XMLGregorianCalendarImpl.class);
		
		//Conversor de la clase XMLGregorian para que devuelva la fecha en el formato indicado
		xstream.registerConverter(new XMLCalendarConverter());
	}
	
	
	public static String getXMLfromPojo(Usuario miusuario ){
		XStream xstream = new XStream();
		setAttributeMappings(xstream);
		String xml = xstream.toXML(miusuario);		
		return xml;
	}
	
	public static String getXMLfromPojo(Collection<?> misusuarios ){
		XStream xstream = new XStream();
		setAttributeMappings(xstream);
		String xml = xstream.toXML(misusuarios);		
		return xml;
	}
		
}
