package com.ws.serializers;

import java.io.StringWriter;
import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.ws.pojos.Usuario;
import com.ws.tags.UsuarioTags;

public class UsuarioPojoSerializer {
	
	protected static void setAttributeMappings(XStream xstream) {
		
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(UsuarioTags.CLASS_TAG, Usuario.class);
				
		//alias implementacion interfaz
		xstream.alias("fechaNac", XMLGregorianCalendar.class, XMLGregorianCalendarImpl.class);
		
		//Conversor de la clase XMLGregorian para que devuelva la fecha en el formato indicado
		xstream.registerConverter(new XMLCalendarConverter());
	}
	
	private static String addSuperTags(String body) {
		
		return "<WS>"+body+"</WS>";
	}

	public static String getXMLfromPojo(Object dto) {
		XStream xstream = new XStream();
		setAttributeMappings(xstream);
		
		StringWriter sw = new StringWriter();
		xstream.marshal(dto, new CompactWriter(sw));
		
		//String xml = xstream.toXML(dto);		
		return addSuperTags(sw.toString());
	}

	public static String getXMLfromPojo(Collection<?> dtos) {
		XStream xstream = new XStream();
		setAttributeMappings(xstream);
		String xml = xstream.toXML(dtos);		
		return addSuperTags(xml);
	}
		
}
