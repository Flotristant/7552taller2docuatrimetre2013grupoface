package com.db.querys;

import java.util.HashMap;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.pojos.Usuario;

public class UsuarioQueryBuilder extends QueryBuilder{

	private static final String CLASS_NAME = "User";

	@Override
	public String getAllById(String id) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(CLASS_NAME);
		criteria.add(Restrictions.idEq(id));
		return QueryBuilder.getXMLfromCriteria(criteria);
	}

	@Override
	public String getAllByAttributes(HashMap<String, String> attributes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String removeById(String id) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(CLASS_NAME);
		criteria.add(Restrictions.idEq(id));
		String xml = QueryBuilder.getXMLfromCriteria(criteria);
		return xml;
	}
}
