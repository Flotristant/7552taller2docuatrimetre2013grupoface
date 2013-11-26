package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.ForoTags;

public class ForoQueryBuilder extends QueryBuilder{

	//TODO poner el nombre de la clase de base de datos
	private static final String CLASS_NAME = "ar.fiuba.redsocedu.datalayer.dtos.Foro";

	@Override
	public String getAllById(Long id) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(CLASS_NAME);
		criteria.add(Restrictions.idEq(id));
		return QueryBuilder.getSerializedCriteria(criteria);
	}

	@Override
	public String getAllByAttributes(Map<String, String> attributes) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(CLASS_NAME);
		if(attributes.containsKey(ForoTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(ForoTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(ForoTags.ID_TAG);
		}
		
		criteria.add(Restrictions.allEq(attributes));   
		return QueryBuilder.getSerializedCriteria(criteria);
	}

	@Override
	public String removeById(Long id) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(CLASS_NAME);
		criteria.add(Restrictions.idEq(id));
		String xml = QueryBuilder.getSerializedCriteria(criteria);
		return xml;
	}

}
