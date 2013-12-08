package com.db.querys;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ws.tags.MensajeTags;

public class MensajeQueryBuilder extends QueryBuilder {
	
	public MensajeQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Mensaje", MensajeTags.ID_TAG);
	}
	
	//TODO A este metodo no se llega nunca
	public static String getMensajesByMiembro(String idmiembro) { // Mover a getAllByAttributes
		
		DetachedCriteria criteria = DetachedCriteria.forEntityName("Mensajes","mensajes");
		criteria.createAlias("mensajes.miembro","miembro");
		criteria.add(Restrictions.eq("miembro.nombre",idmiembro));
		return QueryBuilder.getSerializedCriteria(criteria);
		
	}
}
