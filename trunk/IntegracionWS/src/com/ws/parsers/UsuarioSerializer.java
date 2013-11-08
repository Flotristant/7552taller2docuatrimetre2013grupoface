package com.ws.parsers;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.ws.pojos.Usuario;

public class UsuarioSerializer {
	
	private static class XMLCalendarConverter extends AbstractSingleValueConverter {

		@SuppressWarnings("rawtypes")
        public boolean canConvert(Class clazz) {
        	return clazz.equals(XMLGregorianCalendarImpl.class);
        }
        
        public String toString(Object obj){
        	
        	if (obj == null) return "";
        	XMLGregorianCalendarImpl fechaimp = (XMLGregorianCalendarImpl) obj;
        	return fechaimp.toXMLFormat();
        	
        }

		@Override
		public Object fromString(String arg0) {
			return null;
		}
	}
	
	
	public static String getXMLfromUsuario(Usuario miusuario ){
		XStream xstream = new XStream();
		xstream.alias("usuario", Usuario.class);
		xstream.processAnnotations(Usuario.class);
		xstream.registerConverter(new XMLCalendarConverter());
		xstream.alias("fechaNac", XMLGregorianCalendar.class, XMLGregorianCalendarImpl.class);
		String xml = xstream.toXML(miusuario);		
		return xml;
	}
	
	public static String getXMLfromUsuario(Collection<?> misusuarios ){
		XStream xstream = new XStream();
		xstream.alias("usuario", Usuario.class);
		xstream.processAnnotations(Usuario.class);
		xstream.registerConverter(new XMLCalendarConverter());
		xstream.alias("fechaNac", XMLGregorianCalendar.class, XMLGregorianCalendarImpl.class);
		String xml = xstream.toXML(misusuarios);		
		return xml;
	}
	
}
