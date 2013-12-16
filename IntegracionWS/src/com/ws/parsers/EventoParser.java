package com.ws.parsers;

import java.util.HashMap;

import com.ws.pojos.Evento;
import com.ws.tags.EventoTags;

public class EventoParser extends Parser {

	public EventoParser() {
		super(EventoTags.CLASS_TAG);
		this.relaciones.put(EventoParser.class.toString(), "eventos");
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(EventoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Evento eventoNegocio = (Evento) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Evento eventoDB = new ar.fiuba.redsocedu.datalayer.ws.Evento();

		eventoDB.setEventoId(eventoNegocio.getEventoId());
		eventoDB.setId(eventoNegocio.getId());
		eventoDB.setMuroId(eventoNegocio.getMuroId());
		eventoDB.setNombre(eventoNegocio.getNombre());
		
		return eventoDB;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		return false;
	}

}
