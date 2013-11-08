package com.ws.serializers;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.ws.pojos.Usuario;

public class UsuarioSerializer {
	
	
	/*
	 * Esta clase permite manipular la forma en la que el Xstream arma el xml
	 * En este caso el XMLGregorianblahblah tiene un metodo especial que devuelve
	 * la fecha muy linda, uso ese.
	 */
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
	
	
	public static String getXMLfromPojo(Usuario miusuario ){
		XStream xstream = new XStream();
		xstream.alias("usuario", Usuario.class);    //Para que no ponga los nombre de clase, se ponene alias (queda mejor el XML)
		xstream.registerConverter(new XMLCalendarConverter());
		xstream.alias("fechaNac", XMLGregorianCalendar.class, XMLGregorianCalendarImpl.class);
		String xml = xstream.toXML(miusuario);		
		return xml;
	}
	
	public static String getXMLfromPojo(Collection<?> misusuarios ){
		XStream xstream = new XStream();
		xstream.alias("usuario", Usuario.class);
		xstream.registerConverter(new XMLCalendarConverter());
		xstream.alias("fechaNac", XMLGregorianCalendar.class, XMLGregorianCalendarImpl.class);
		String xml = xstream.toXML(misusuarios);		
		return xml;
	}
	
// El siguiente es un ejemplo de como queda la salida de un usuario en XML
//
//	  <usuario>
//	    <usuarioId>12</usuarioId>
//	    <activado>true</activado>
//	    <apellido>sanchez</apellido>
//	    <email>ap@fiuba.edu.ar</email>
//	    <fechaNac>1986-05-05</fechaNac>
//	    <habilitado>true</habilitado>
//	    <nombre>Alfonso</nombre>
//	    <padron>999999</padron>
//	    <password>123456</password>
//	    <username>Pepe</username>
//	  </usuario>
	
}
