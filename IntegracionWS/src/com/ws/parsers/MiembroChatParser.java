package com.ws.parsers;

import ar.fiuba.redsocedu.datalayer.ws.Chat;

import com.ws.pojos.MiembroChat;
import com.ws.tags.ChatTags;
import com.ws.tags.MensajeChatTags;
import com.ws.tags.MiembroChatTags;

public class MiembroChatParser extends Parser {

    public MiembroChatParser() {
        super(MiembroChatTags.CLASS_TAG);
        this.relaciones.put(MiembroChatParser.class.toString(), "miembrosChat"); //TODO: chequear nombre
    }

    @Override
    public Long getId() {
        return Long.parseLong(this.campos.get(MiembroChatTags.ID_TAG));
    }

    @Override
    public Object getDBObjectFromBusinessXML(String xml) {
        MiembroChat miembroChat = (MiembroChat) getEntidadNegocio(xml);
        return miembroChat.getDatabaseEntity();
    }

    @Override
    protected Boolean validateJoinParser(Parser parser) {
        // TODO Auto-generated method stub
        return null;
    }
    
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(ChatTags.CLASS_TAG, "com.ws.pojos."
				+ ChatTags.CLASS_TAG);
		xml = xml.replace(MensajeChatTags.CLASS_TAG, "com.ws.pojos."
				+ MensajeChatTags.CLASS_TAG);
		return xml;
	}

}
