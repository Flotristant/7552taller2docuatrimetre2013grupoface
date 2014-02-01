package com.ws.handler;

import com.db.querys.AmbitoQueryBuilder;
import com.ws.parsers.AmbitoParser;
import com.ws.serializers.AmbitoSerializer;

public class AmbitoHandler extends Handler {
	
	public AmbitoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Ambito", new AmbitoParser(), new AmbitoSerializer(), new AmbitoQueryBuilder());
	}

//	@Override
//	public Object toDatabaseEntity(Object object) {
//		com.ws.pojos.Ambito ambito = (com.ws.pojos.Ambito) object;
//		return (ar.fiuba.redsocedu.datalayer.ws.Ambito) ambito.getDatabaseEntity();
//	}

}
