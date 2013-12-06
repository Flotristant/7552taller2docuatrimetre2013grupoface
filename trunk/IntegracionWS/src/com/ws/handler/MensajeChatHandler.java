package com.ws.handler;

import com.db.querys.MensajeChatQueryBuilder;
import com.ws.parsers.MensajeChatParser;
import com.ws.serializers.MensajeChatSerializer;
import com.ws.serializers.XMLCalendarConverter;



public class MensajeChatHandler extends Handler{
	
	public MensajeChatHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.MensajeChat", new  MensajeChatParser(), new MensajeChatSerializer());
		this.queryBuilder = new MensajeChatQueryBuilder();
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.MensajeChat mensajeChat = (com.ws.pojos.MensajeChat) object;
		ar.fiuba.redsocedu.datalayer.ws.MensajeChat mensajeChatDb = new ar.fiuba.redsocedu.datalayer.ws.MensajeChat();
		mensajeChatDb.setContenido(mensajeChat.getContenido());
		mensajeChatDb.setId(mensajeChat.getId());
		mensajeChatDb.setMensajeChatId(mensajeChat.getIdChat());
		//mensajeChatDb.setFecha(XMLCalendarConverter(mensajeChat.getFecha());
		return mensajeChatDb;
		
	}

}
