package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.SubforoTags;


public class SubforoQueryBuilder extends QueryBuilder{

	public SubforoQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Subforo");
	}

	//TODO ver bien cual es el nombre de la clase de datos
	
	@Override
	public String getAllByAttributes(Map<String, String> attributes) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
		if(attributes.containsKey(SubforoTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(SubforoTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(SubforoTags.ID_TAG);
		}
		
		criteria.add(Restrictions.allEq(attributes));   
		return QueryBuilder.getSerializedCriteria(criteria);
	}

}
