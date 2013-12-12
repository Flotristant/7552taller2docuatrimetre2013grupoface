package com.ws.parsers;

import com.ws.pojos.MensajeChat;
import com.ws.tags.MensajeChatTags;

public class MensajeChatParser extends Parser {

	public MensajeChatParser(){
		super(MensajeChatTags.CLASS_TAG);
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MensajeChatTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		MensajeChat mensajeChat = (MensajeChat) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.MensajeChat mensajeChatDb = new ar.fiuba.redsocedu.datalayer.ws.MensajeChat();
		mensajeChatDb.setContenido(mensajeChat.getContenido());
		mensajeChatDb.setId(mensajeChat.getId());
		mensajeChatDb.setMensajeChatId(mensajeChat.getIdChat());
		//mensajeChatDb.setFecha(XMLCalendarConverter(mensajeChat.getFecha());
		return mensajeChatDb;
		
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
