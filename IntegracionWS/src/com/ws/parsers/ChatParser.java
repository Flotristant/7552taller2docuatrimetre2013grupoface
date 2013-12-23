package com.ws.parsers;


import java.util.List;

import com.db.querys.DBManager;
import com.ws.pojos.Chat;
import com.ws.pojos.MensajeChat;
import com.ws.pojos.MiembroChat;
import com.ws.tags.ChatTags;
import com.ws.tags.MensajeChatTags;
import com.ws.tags.MiembroChatTags;

public class ChatParser extends Parser {

    public ChatParser() {
        super(ChatTags.CLASS_TAG);
        relaciones.put(MensajeChatParser.class.toString(), "mensajesChat");
        relaciones.put(MiembroChatParser.class.toString(), "miembrosChat");
        relaciones.put(ChatParser.class.toString(), "chats");
        
    }

    @Override
    protected Boolean validateJoinParser(Parser parser) {
        return (parser instanceof MensajeChatParser) || (parser instanceof MiembroChatParser);
    }

    @Override
    public Long getId() {
        return Long.parseLong(this.campos.get(ChatTags.ID_TAG));
    }

    @Override
    public Object getDBObjectFromBusinessXML(String xml)  {
        Chat miChatNegocio = (Chat) getEntidadNegocio(xml);
        return miChatNegocio.getDatabaseEntity();
    }
    
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(MensajeChatTags.CLASS_TAG, "com.ws.pojos."
				+ MensajeChatTags.CLASS_TAG);
		xml = xml.replace(MiembroChatTags.CLASS_TAG, "com.ws.pojos."
				+ MiembroChatTags.CLASS_TAG);
		return xml;
	}

    
}
