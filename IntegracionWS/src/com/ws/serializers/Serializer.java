package com.ws.serializers;

import java.io.StringWriter;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;

public abstract class Serializer {
	
	private static String addSuperTags(String body) {
		
		return "<WS>"+body+"</WS>";
	}

	//TODO: esto es para recibir un pojo de negocio o de BD?
	public String getXMLfromPojo(Object dto) {
		XStream xstream = new XStream();
		this.setAttributeMappings(xstream);
		
		StringWriter sw = new StringWriter();
		xstream.marshal(dto, new CompactWriter(sw));
		
		//String xml = xstream.toXML(dto);		
		return addSuperTags(sw.toString());
	}

	public String getXMLfromPojo(Collection<?> dtos) {
		XStream xstream = new XStream();
		this.setAttributeMappings(xstream);
		String xml = xstream.toXML(dtos);		
		return addSuperTags(xml);
	}
	
	protected abstract void setAttributeMappings(XStream xstream);
	
}
