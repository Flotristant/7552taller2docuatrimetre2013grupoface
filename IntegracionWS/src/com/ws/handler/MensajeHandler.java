package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Mensaje;

import com.db.querys.MensajeQueryBuilder;
import com.ws.parsers.MensajeParser;
import com.ws.serializers.MensajeSerializer;

public class MensajeHandler extends Handler {
	
	public MensajeHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Mensaje", new MensajeParser(), new MensajeSerializer(), new MensajeQueryBuilder());
	}
	
}
