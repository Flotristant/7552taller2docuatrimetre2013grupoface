package com.ws.handler;

import com.db.querys.RecursoQueryBuilder;
import com.ws.parsers.RecursoParser;
import com.ws.serializers.RecursoSerializer;

public class RecursoHandler extends Handler {

	public RecursoHandler(){
		super("ar.fiuba.redsocedu.datalayer.dtos.Recurso", new RecursoParser(), new RecursoSerializer(), new RecursoQueryBuilder());

	}
	

}
