package com.db.querys;

import java.util.HashMap;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class UsuarioQueryBuilder extends QueryBuilder{

	@Override
	public String getAllById(String id) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName("User");
		criteria.add(Restrictions.idEq(id));
		return QueryBuilder.getXMLfromCriteria(criteria);
	}

	@Override
	public String getAllByAttributes(HashMap<String, String> attributes) {
		// TODO Auto-generated method stub
		return null;
	}

}
