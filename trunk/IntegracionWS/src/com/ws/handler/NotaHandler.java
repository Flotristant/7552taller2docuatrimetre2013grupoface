package com.ws.handler;

import com.db.querys.NotaQueryBuilder;
import com.ws.parsers.NotaParser;
import com.ws.pojos.Nota;
import com.ws.serializers.NotaSerializer;

public class NotaHandler extends Handler {

	public NotaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Nota", new NotaParser(), new NotaSerializer(), new NotaQueryBuilder());
	}


}
