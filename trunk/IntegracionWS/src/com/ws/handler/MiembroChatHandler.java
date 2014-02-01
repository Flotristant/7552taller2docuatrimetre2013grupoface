package com.ws.handler;

import com.db.querys.MiembroChatQueryBuilder;
import com.ws.parsers.MiembroChatParser;
import com.ws.serializers.MiembroChatSerializer;

public class MiembroChatHandler extends Handler {

	public MiembroChatHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.MiembroChat", new  MiembroChatParser(), new MiembroChatSerializer(), new MiembroChatQueryBuilder());
	}
	

}
