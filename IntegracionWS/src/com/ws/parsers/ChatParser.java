package com.ws.parsers;



import com.ws.pojos.Chat;
import com.ws.tags.ChatTags;
import com.ws.tags.MensajeChatTags;
import com.ws.tags.MiembroChatTags;
import com.ws.tags.NotaTags;

public class ChatParser extends Parser {

    public ChatParser() {
        super(ChatTags.CLASS_TAG);
        relaciones_directas.put(MensajeChatParser.class.toString(), "mensajesChat");
        relaciones_directas.put(MiembroChatParser.class.toString(), "miembrosChat");
        
    }

    @Override
    protected Boolean validateJoinParser(Parser parser) {
        return (parser instanceof MensajeChatParser) || (parser instanceof MiembroChatParser);
    }


    @Override
    public Object getDBObjectFromBusinessXML(String xml)  {
        Chat miChatNegocio = (Chat) getEntidadNegocio(xml);
        return miChatNegocio.getDatabaseEntity();
    }
    
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace("<"+MensajeChatTags.CLASS_TAG+">", "<com.ws.pojos."
				+ MensajeChatTags.CLASS_TAG + ">");
		xml = xml.replace("</"+MensajeChatTags.CLASS_TAG+">", "</com.ws.pojos."
				+ MensajeChatTags.CLASS_TAG + ">");
		
		xml = xml.replace("<"+MiembroChatTags.CLASS_TAG+">", "<com.ws.pojos."
				+ MiembroChatTags.CLASS_TAG + ">");
		xml = xml.replace("</"+MiembroChatTags.CLASS_TAG+">", "</com.ws.pojos."
				+ MiembroChatTags.CLASS_TAG + ">");
		
		return xml;
	}

    
}
