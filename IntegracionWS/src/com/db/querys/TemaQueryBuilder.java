package com.db.querys;

import java.util.Map;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.TemaTags;

public class TemaQueryBuilder extends QueryBuilder {

	public TemaQueryBuilder()	 {
		super("ar.fiuba.redsocedu.datalayer.dtos.Tema");
	}

	@Override
	public String getAllByAttributes(Map<String, String> attributes) {		
		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
		if(attributes.containsKey(TemaTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(TemaTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(TemaTags.ID_TAG);
		}		
		criteria.add(Restrictions.allEq(attributes));
		return QueryBuilder.getSerializedCriteria(criteria);
	}

}
