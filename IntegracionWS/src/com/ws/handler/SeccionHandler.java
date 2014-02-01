package com.ws.handler;

import com.db.querys.SeccionQueryBuilder;
import com.ws.parsers.SeccionParser;
import com.ws.serializers.SeccionSerializer;


public class SeccionHandler extends Handler {

	public SeccionHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Seccion", new SeccionParser(), new SeccionSerializer(), new SeccionQueryBuilder());
	}	

}
