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
	public Object getDBObjectFromBusinessXML(String xml) {
		Evento eventoNegocio = (Evento) getEntidadNegocio(xml);
		return eventoNegocio.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		return false;
	}

}
