package com.ws.handler;

import com.db.querys.AmbitoQueryBuilder;
import com.ws.parsers.AmbitoParser;
import com.ws.serializers.AmbitoSerializer;

public class AmbitoHandler extends Handler {
	
	public AmbitoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Ambito", new AmbitoParser(), new AmbitoSerializer(), new AmbitoQueryBuilder());
	}

}
