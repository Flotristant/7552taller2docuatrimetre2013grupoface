package com.ws.parsers;

import com.ws.pojos.MensajeChat;
import com.ws.tags.MensajeChatTags;

public class MensajeChatParser extends Parser {

	public MensajeChatParser(){
		super(MensajeChatTags.CLASS_TAG);
		this.relaciones.put(MensajeChatParser.class.toString(), "mensajesChat"); //TODO: chequear nombre
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MensajeChatTags.ID_TAG));
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		MensajeChat mensajeChat = (MensajeChat) getEntidadNegocio(xml);
		return mensajeChat.getDatabaseEntity();
		
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
