package com.ws.parsers;

import com.ws.pojos.Evento;
import com.ws.tags.EventoTags;

public class EventoParser extends Parser {

	public EventoParser() {
		super(EventoTags.CLASS_TAG);
		this.relaciones_directas.put(EventoParser.class.toString(), "eventos");
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
