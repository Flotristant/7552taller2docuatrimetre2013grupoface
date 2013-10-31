package com.db.querys;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.thoughtworks.xstream.XStream;

public class QueryBuilder {
	
	
	public static String getForoById(String id){
		
		DetachedCriteria criteria = DetachedCriteria.forEntityName("Foros");
		criteria.add(Restrictions.idEq(id));
		return getXMLfromCriteria(criteria);
		
	}
	
	
	public static String getMensajesByMiembro(String idmiembro){
		
		DetachedCriteria criteria = DetachedCriteria.forEntityName("Mensajes","mensajes");
		criteria.createAlias("mensajes.miembro","miembro");
		criteria.add(Restrictions.eq("miembro.nombre",idmiembro));
		return getXMLfromCriteria(criteria);
		
	}
	
	private static String getXMLfromCriteria(DetachedCriteria crit){
		
		XStream xstream = new XStream();
		String xml = xstream.toXML(crit);		
		return xml;
		
	}
	
}
