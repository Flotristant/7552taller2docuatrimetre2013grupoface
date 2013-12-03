package com.ws.parsers;

import com.ws.pojos.MensajeChat;
import com.ws.tags.MensajeChatTags;

public class MensajeChatParser extends Parser {

	public MensajeChatParser(){
		super(MensajeChatTags.CLASS_TAG);
	}

	@Override
	public Object getEntidad() {
		MensajeChat mensajeChat = new MensajeChat();
		if (this.campos.get(MensajeChatTags.ID_TAG) != null){
			mensajeChat.setId(Long.parseLong(this.campos.get(MensajeChatTags.ID_TAG)));
		}
		if (this.campos.get(MensajeChatTags.ID_CHAT_TAG) != null){
			mensajeChat.setId(Long.parseLong(this.campos.get(MensajeChatTags.ID_CHAT_TAG)));
		}
		mensajeChat.setFecha(java.sql.Timestamp.valueOf(this.campos.get(MensajeChatTags.FECHA_TAG)));
		mensajeChat.setContenido(this.campos.get(MensajeChatTags.CONTENIDO_TAG));
		
		return mensajeChat;
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MensajeChatTags.ID_TAG));
	}
}
