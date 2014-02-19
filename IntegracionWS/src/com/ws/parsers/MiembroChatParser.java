package com.ws.parsers;

import com.ws.pojos.MiembroChat;
import com.ws.tags.ChatTags;
import com.ws.tags.MensajeChatTags;
import com.ws.tags.MiembroChatTags;

public class MiembroChatParser extends Parser {

    public MiembroChatParser() {
        super(MiembroChatTags.CLASS_TAG);
        this.relaciones_directas.put(MensajeChatParser.class.toString(), "mensajesChat");
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
    
    /**
     * Por favor, mantener los "<" ">" porque sino se confunden Chat con MiembroChat por ejemplo (contiene 'Chat').
     */
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace("<"+ChatTags.CLASS_TAG+">", "<com.ws.pojos."
				+ ChatTags.CLASS_TAG+">");
		xml = xml.replace("</"+ChatTags.CLASS_TAG+">", "</com.ws.pojos."
				+ ChatTags.CLASS_TAG+">");
		xml = xml.replace("<"+MensajeChatTags.CLASS_TAG+">", "<com.ws.pojos."
				+ MensajeChatTags.CLASS_TAG +">");
		xml = xml.replace("</"+MensajeChatTags.CLASS_TAG+">", "</com.ws.pojos."
				+ MensajeChatTags.CLASS_TAG +">");
		return xml;
	}

}
