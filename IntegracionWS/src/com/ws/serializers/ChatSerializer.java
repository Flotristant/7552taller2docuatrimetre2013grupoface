package com.ws.serializers;

import java.util.Collection;

import ar.fiuba.redsocedu.datalayer.ws.Chat;
import ar.fiuba.redsocedu.datalayer.ws.MiembroChat;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.ChatTags;


public class ChatSerializer extends Serializer {

	
	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		xstream.alias(ChatTags.CLASS_TAG, Chat.class);
		xstream.aliasField(ChatTags.ID_TAG, Chat.class, "id");
		xstream.omitField(Chat.class, "chatId");
		xstream.aliasField(ChatTags.ID_AMBITO_TAG, Chat.class, "ambitoId");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
				
	}
	
	@Override
	protected String addExtraFields(String xml, Collection<?> dtos){
//		Chat chat = (Chat) dtos.iterator().next();
//		if( chat.getMiembrosChat() != null) {
//			xml += "<miembrosChat>";
//			for(MiembroChat miembro: chat.getMiembrosChat()) {
//				xml += miembro.
//			}
//		}
		return xml; 
	}
}
