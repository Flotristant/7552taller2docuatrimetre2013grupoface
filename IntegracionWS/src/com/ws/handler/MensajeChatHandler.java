package com.ws.handler;

import com.db.querys.MensajeChatQueryBuilder;
import com.ws.parsers.MensajeChatParser;
import com.ws.serializers.MensajeChatSerializer;



public class MensajeChatHandler extends Handler{
	
	public MensajeChatHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.MensajeChat", new  MensajeChatParser(), new MensajeChatSerializer());
		this.queryBuilder = new MensajeChatQueryBuilder();
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		// TODO ver bien esto
		/*com.ws.pojos.MensajeChat mensajeChat = (com.ws.pojos.MensajeChat) object;
		ar.fiuba.redsocedu.datalayer.ws.MensajeChat mensajeChatDb = new ar.fiuba.redsocedu.datalayer.ws.MensajeChat();
		mensajeChatDb.setContenido(mensajeChat.getContenido());
		mensajeChatDb.setId(mensajeChat.getId());
		mensajeChatDb.setIdChat(mensajeChat.getIdChat());
		mensajeChatDb.setFecha(mensajeChat.getFecha());
		return mensajeChatDb;*/
		
		return null;
	}

}
