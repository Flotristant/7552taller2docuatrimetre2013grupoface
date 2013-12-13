package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.MensajeChat;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.MensajeChatTags;


public class MensajeChatSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.alias(MensajeChatTags.CLASS_TAG, MensajeChat.class);
		xstream.aliasField(MensajeChatTags.ID_TAG, MensajeChat.class, "id");
		xstream.aliasField(MensajeChatTags.ID_CHAT_TAG, MensajeChat.class, "idChat");
		xstream.aliasField(MensajeChatTags.FECHA_TAG, MensajeChat.class, "fecha");
		xstream.aliasField(MensajeChatTags.CONTENIDO_TAG, MensajeChat.class,"contenido");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
	}

}
