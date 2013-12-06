package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.ChatTags;

public class NoticiaQueryBuilder extends QueryBuilder {

	public NoticiaQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Noticia");
	}

	@Override
	public String getAllByAttributes(Map<String, String> attributes) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
		if(attributes.containsKey(ChatTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(ChatTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(ChatTags.ID_TAG);
		}
		
		criteria.add(Restrictions.allEq(attributes));   
		return QueryBuilder.getSerializedCriteria(criteria);
	}
	
	private Boolean esJoin(Map<String, String> attributes){
		
		if (attributes.containsKey("join")) return true;
		else return false;
	}
}
