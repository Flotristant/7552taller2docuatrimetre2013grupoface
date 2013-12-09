package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Chat;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.ChatTags;


public class ChatSerializer extends Serializer {

	
	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		xstream.alias(ChatTags.CLASS_TAG, Chat.class);
		xstream.aliasField(ChatTags.ID_TAG, Chat.class, "id");
		xstream.omitField(Chat.class, "ChatId");
		xstream.aliasField(ChatTags.ID_AMBITO_TAG, Chat.class, "idAmbito");
		
		// Siguiendo los lineamientos del PDF, al devolver el chat, no devolveriamos el listado
		// de miembros y mensajes. si alguien quiere consultar eso debiera hacer a la inversa
		// pidiendo todos los miembros (o mensajes) tal que pertenezcan a cierto chat
		// Por eso omito en la salida las listas de mensajes asociados.
		xstream.omitField(Chat.class, "mensajesChat");
		xstream.omitField(Chat.class, "miembrosChat");
		
	}
	
	
}
