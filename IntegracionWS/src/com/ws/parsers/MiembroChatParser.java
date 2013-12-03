package com.ws.parsers;

import com.ws.pojos.MiembroChat;
import com.ws.tags.MiembroChatTags;

public class MiembroChatParser extends Parser {

	public MiembroChatParser(){
		super(MiembroChatTags.CLASS_TAG);
	}
	
	@Override
	public Object getEntidad() {
		MiembroChat miembroChat = new MiembroChat();
		if (this.campos.get(MiembroChatTags.ID_TAG) != null){
			miembroChat.setId(Long.parseLong(this.campos.get(MiembroChatTags.ID_TAG)));
		}
		miembroChat.setEstado(Boolean.parseBoolean(this.campos.get(MiembroChatTags.ESTADO_TAG)));
		miembroChat.setNombre(this.campos.get(MiembroChatTags.NOMBRE_TAG));
		
		return miembroChat;	
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MiembroChatTags.ID_TAG));
	}

}
