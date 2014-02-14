package com.ws.handler;

import com.db.querys.EncuestaQueryBuilder;
import com.ws.parsers.EncuestaParser;
import com.ws.serializers.EncuestaSerializer;

public class EncuestaHandler extends MaterialesHandler {

	public EncuestaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Encuesta", new EncuestaParser()
		, new EncuestaSerializer(), new EncuestaQueryBuilder());
	}
}
