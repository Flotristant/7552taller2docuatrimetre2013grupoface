package com.ws.handler;

import com.db.querys.MensajeChatQueryBuilder;
import com.ws.parsers.MensajeChatParser;
import com.ws.serializers.MensajeChatSerializer;
import com.ws.serializers.XMLCalendarConverter;



public class MensajeChatHandler extends Handler{
	
	public MensajeChatHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.MensajeChat", new  MensajeChatParser(), new MensajeChatSerializer(), new MensajeChatQueryBuilder());
	}


}
