package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.MensajeChatTags;



public class MensajeChatQueryBuilder extends QueryBuilder{
	
	public MensajeChatQueryBuilder(){
		super("ar.fiuba.redsocedu.datalayer.dtos.MensajeChat");
	}

	@Override
	public String getAllByAttributes(Map<String, String> attributes) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
		if(attributes.containsKey(MensajeChatTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(MensajeChatTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(MensajeChatTags.ID_TAG);
		}		
		criteria.add(Restrictions.allEq(attributes));
		return QueryBuilder.getSerializedCriteria(criteria);
	
	}
	

}
