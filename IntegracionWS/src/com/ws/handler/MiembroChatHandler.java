package com.ws.handler;

import com.db.querys.MiembroChatQueryBuilder;
import com.ws.parsers.MiembroChatParser;
import com.ws.serializers.MiembroChatSerializer;

public class MiembroChatHandler extends Handler {

	public MiembroChatHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.MiembroChat", new  MiembroChatParser(), new MiembroChatSerializer());
		this.queryBuilder = new MiembroChatQueryBuilder();
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		// TODO ver bien esto
		/*com.ws.pojos.MiembroChat miembroChat = (com.ws.pojos.MiembroChat) object;
		ar.fiuba.redsocedu.datalayer.ws.MiembroChat miembroChatDb = new ar.fiuba.redsocedu.datalayer.ws.MiembroChat();
		miembroChatDb.setNombre(miembroChat.getNombre());
		miembroChatDb.setId(miembroChat.getId());
		miembroChatDb.setEstado(miembroChatDb.gerEstado());		
		return miembroChatDb;*/
		return null;
	}

}
