package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.MiembroChatTags;

public class MiembroChatQueryBuilder extends QueryBuilder{

	public MiembroChatQueryBuilder(){
		super("ar.fiuba.redsocedu.datalayer.dtos.MiembroChat");
	}
	
	@Override
	public String getAllByAttributes(Map<String, String> attributes) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
		if(attributes.containsKey(MiembroChatTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(MiembroChatTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(MiembroChatTags.ID_TAG);
		}		
		criteria.add(Restrictions.allEq(attributes));
		return QueryBuilder.getSerializedCriteria(criteria);
	}

}
