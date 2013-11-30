package com.db.querys;

import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.MensajeTags;

public class MensajeQueryBuilder extends QueryBuilder {
	
	public MensajeQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Mensaje");
	}
	
	public static String getMensajesByMiembro(String idmiembro) { // Mover a getAllByAttributes
		
		DetachedCriteria criteria = DetachedCriteria.forEntityName("Mensajes","mensajes");
		criteria.createAlias("mensajes.miembro","miembro");
		criteria.add(Restrictions.eq("miembro.nombre",idmiembro));
		return QueryBuilder.getSerializedCriteria(criteria);
		
	}

	@Override
	public String getAllByAttributes(Map<String, String> attributes) {		
		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
		if(attributes.containsKey(MensajeTags.ID_TAG)) {
			Long id = Long.parseLong(attributes.get(MensajeTags.ID_TAG));
			criteria.add(Restrictions.idEq(id));
			attributes.remove(MensajeTags.ID_TAG);
		}		
		criteria.add(Restrictions.allEq(attributes));
		return QueryBuilder.getSerializedCriteria(criteria);
	}
}
