package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Chat;
import ar.fiuba.redsocedu.datalayer.ws.Evento;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.EventoTags;

public class EventoSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.alias(EventoTags.CLASS_TAG, Chat.class);
		xstream.aliasField(EventoTags.ID_TAG, Chat.class, "id");
		xstream.omitField(Evento.class, "EventoId");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
	}

}
