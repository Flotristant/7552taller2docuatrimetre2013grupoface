package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Chat;
import ar.fiuba.redsocedu.datalayer.ws.MiembroChat;

import com.db.querys.ChatQueryBuilder;
import com.db.querys.DBManager;
import com.ws.parsers.ChatParser;
import com.ws.pojos.MensajeChat;
import com.ws.serializers.ChatSerializer;

public class ChatHandler extends Handler {

	public ChatHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Chat", new ChatParser(),
				new ChatSerializer(), new ChatQueryBuilder());
	}


}
