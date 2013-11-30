package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.ForoTags;

public class ForoQueryBuilder extends QueryBuilder{

	public ForoQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Foro");
	}
	
	//TODO poner el nombre de la clase de base de datos

	@Override
	public String getAllByAttributes(Map<String, String> attributes) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
		if(attributes.containsKey(ForoTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(ForoTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(ForoTags.ID_TAG);
		}
		
		criteria.add(Restrictions.allEq(attributes));   
		return QueryBuilder.getSerializedCriteria(criteria);
	}

}
