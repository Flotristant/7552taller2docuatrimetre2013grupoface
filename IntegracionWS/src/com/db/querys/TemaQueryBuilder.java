package com.db.querys;

import java.util.Map;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.TemaTags;

public class TemaQueryBuilder extends QueryBuilder {

	private static final String CLASS_NAME = "ar.fiuba.redsocedu.datalayer.dtos.Tema";
	
	@Override
	public String getAllById(Long id) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(CLASS_NAME);
		criteria.add(Restrictions.idEq(id));
		return QueryBuilder.getSerializedCriteria(criteria);
	}
	
	@Override
	public String getAllByAttributes(Map<String, String> attributes) {		
		DetachedCriteria criteria = DetachedCriteria.forEntityName(CLASS_NAME);
		if(attributes.containsKey(TemaTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(TemaTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(TemaTags.ID_TAG);
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
