package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Chat;
import ar.fiuba.redsocedu.datalayer.ws.MensajeChat;
import ar.fiuba.redsocedu.datalayer.ws.MiembroChat;

import com.db.querys.AmbitoQueryBuilder;
import com.ws.parsers.AmbitoParser;
import com.ws.serializers.AmbitoSerializer;

public class AmbitoHandler extends Handler {
	
	public AmbitoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Ambito", new AmbitoParser(), new AmbitoSerializer(), new AmbitoQueryBuilder());
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Chat ChatNegocio = (com.ws.pojos.Chat) object;
		Chat chatDB = new Chat();
		chatDB.setId(ChatNegocio.getId());
		chatDB.setAmbitoId(ChatNegocio.getIdAmbito());

		// Administro las listas que puedo recibir del negocio
		// Agrego al Pojo de DB instancias de Mensajes con los id que recibo
		for (Long elem : ChatNegocio.getMensajesChat()) {

			MensajeChat unMensaje = new MensajeChat();
			unMensaje.setMensajeChatId(elem);
			chatDB.getMensajesChat().add(unMensaje);
		}

		// Agrego al Pojo de DB instancias de Miembros con los id que recibo
		for (com.ws.pojos.MiembroChat elem : ChatNegocio.getMiembrosChat()) {

			MiembroChat unMiembro = new MiembroChat();
			unMiembro.setMiembroChatId(elem.getId());
			chatDB.getMiembrosChat().add(unMiembro);
		}

		return chatDB;
	}

}
