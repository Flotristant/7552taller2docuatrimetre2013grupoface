package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Muro;

import com.db.querys.MuroQueryBuilder;
import com.ws.parsers.MuroParser;
import com.ws.serializers.MuroSerializer;

public class MuroHandler extends Handler {
	
	public MuroHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Muro", new MuroParser(), new MuroSerializer(), new MuroQueryBuilder());
	}
	
}
