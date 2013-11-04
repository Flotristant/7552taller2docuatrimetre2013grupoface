package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.thoughtworks.xstream.XStream;

public abstract class QueryBuilder {
	
	protected static String getXMLfromCriteria(DetachedCriteria crit){
		XStream xstream = new XStream();
		String xml = xstream.toXML(crit);		
		return xml;
	}
		
	public abstract String getAllById(String id);
	public abstract String getAllByAttributes(Map<String, String> attributes);
	public abstract String removeById(String id);
}
