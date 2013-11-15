package com.ws.serializers;

import java.util.Collection;


import com.thoughtworks.xstream.XStream;


public abstract class Serializer {


	/**
	 * Metodo que mapea todos los nombres de atributo desde los pojos de DB
	 * hacia los objetos de modelo. 
	 * @param xstream
	 */
	protected static void setAttributeMappings(XStream xstream){}
	

	private static String addSuperTags(String body) {
		
		return "<WS>"+body+"</WS>";
	}

	public static String getXMLfromPojo(Object dto) {
		XStream xstream = new XStream();
		setAttributeMappings(xstream);
		String xml = xstream.toXML(dto);		
		return addSuperTags(xml);
	}

	public static String getXMLfromPojo(Collection<?> dtos) {
		XStream xstream = new XStream();
		setAttributeMappings(xstream);
		String xml = xstream.toXML(dtos);		
		return addSuperTags(xml);
	}

	public Serializer() {
		super();
	}

}