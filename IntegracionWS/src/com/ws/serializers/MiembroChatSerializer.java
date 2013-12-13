package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.MiembroChat;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.MiembroChatTags;


public class MiembroChatSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.alias(MiembroChatTags.CLASS_TAG, MiembroChat.class);
		xstream.aliasField(MiembroChatTags.ID_TAG, MiembroChat.class, "id");
		xstream.aliasField(MiembroChatTags.NOMBRE_TAG, MiembroChat.class, "nombre");
		xstream.aliasField(MiembroChatTags.ESTADO_TAG, MiembroChat.class, "estado");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		
	}

}
