package com.ws.handler;

import com.db.querys.TemaQueryBuilder;
import com.ws.parsers.TemaParser;
import com.ws.serializers.TemaSerializer;

public class TemaHandler extends Handler {
	
	public TemaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Tema", new TemaParser(), new TemaSerializer(), new TemaQueryBuilder());
	}
	
}
