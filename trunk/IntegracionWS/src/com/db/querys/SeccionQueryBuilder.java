package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.SeccionTags;

public class SeccionQueryBuilder  extends QueryBuilder{

	public SeccionQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Seccion");
	}

	@Override
	public String getAllByAttributes(Map<String, String> attributes) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
		if(attributes.containsKey(SeccionTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(SeccionTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(SeccionTags.ID_TAG);
		}
		return QueryBuilder.getSerializedCriteria(criteria);
	}

}
