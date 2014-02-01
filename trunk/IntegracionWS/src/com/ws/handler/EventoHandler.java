package com.ws.handler;

import com.db.querys.EventoQueryBuilder;
import com.ws.parsers.EventoParser;
import com.ws.serializers.EventoSerializer;

public class EventoHandler extends Handler {

	public EventoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Evento", new EventoParser(), new EventoSerializer(), new EventoQueryBuilder());
	}


}
