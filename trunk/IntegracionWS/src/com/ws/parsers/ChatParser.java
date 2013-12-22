package com.ws.parsers;


import com.ws.pojos.Chat;
import com.ws.tags.CarteleraTags;
import com.ws.tags.ChatTags;
import com.ws.tags.ForoTags;
import com.ws.tags.MensajeChatTags;
import com.ws.tags.MiembroChatTags;
import com.ws.tags.MuroTags;

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
    public Object getDBObject(String xml) {

        Chat miChatNegocio = (Chat) getEntidadNegocio(xml);

        ar.fiuba.redsocedu.datalayer.ws.Chat miChatDB = new ar.fiuba.redsocedu.datalayer.ws.Chat();

        miChatDB.setChatId(miChatNegocio.getIdChat());

        //miChatDB.setIdAmbito(miChatNegocio.getIdAmbito());

        return miChatDB;
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
