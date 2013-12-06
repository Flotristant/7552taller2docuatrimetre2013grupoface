package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Chat;
import ar.fiuba.redsocedu.datalayer.ws.MensajeChat;
import ar.fiuba.redsocedu.datalayer.ws.MiembroChat;

import com.db.querys.ChatQueryBuilder;
import com.ws.parsers.ChatParser;
import com.ws.serializers.ChatSerializer;

public class ChatHandler extends Handler {

	public ChatHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Chat", new ChatParser(),
				new ChatSerializer());
		this.queryBuilder = new ChatQueryBuilder();
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Chat ChatNegocio = (com.ws.pojos.Chat) object;
		Chat chatDB = new Chat();
		chatDB.setId(ChatNegocio.getId());
		chatDB.setAmbitoId(ChatNegocio.getIdAmbito());

		// Administro las listas que puedo recibir del negocio
		// Agrego al Pojo de DB instancias de Mensajes con los id que recibo
		for (Long elem : ChatNegocio.getMensajeChat()) {

			MensajeChat unMensaje = new MensajeChat();
			unMensaje.setMensajeChatId(elem);
			chatDB.getMensajesChat().add(unMensaje);
		}

		// Agrego al Pojo de DB instancias de Miembros con los id que recibo
		for (Long elem : ChatNegocio.getMiembroChat()) {

			MiembroChat unMiembro = new MiembroChat();
			unMiembro.setMiembroChatId(elem);
			chatDB.getMiembrosChat().add(unMiembro);
		}

		return chatDB;
	}

}
