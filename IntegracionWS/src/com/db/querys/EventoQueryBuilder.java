package com.db.querys;

import com.ws.tags.EventoTags;

public class EventoQueryBuilder extends QueryBuilder {

	public EventoQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Evento", EventoTags.ID_TAG);
	}

}
