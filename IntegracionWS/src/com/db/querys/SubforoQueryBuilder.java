package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class SubforoQueryBuilder extends QueryBuilder{

	//TODO ver bien cual es el nombre de la clase de datos
	private static final String CLASS_NAME = "ar.fiuba.redsocedu.datalayer.dtos.Subforo";
	
	@Override
	public String getAllById(Long id) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(CLASS_NAME);
		criteria.add(Restrictions.idEq(id));
		return QueryBuilder.getSerializedCriteria(criteria);
	}

	@Override
	public String getAllByAttributes(Map<String, String> attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
