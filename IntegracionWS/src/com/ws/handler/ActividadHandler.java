package com.ws.handler;

import com.db.querys.ActividadQueryBuilder;
import com.ws.parsers.ActividadParser;
import com.ws.pojos.Actividad;
import com.ws.serializers.ActividadSerializer;

public class ActividadHandler extends Handler {

	public ActividadHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Actividad", 
				new ActividadParser(), new ActividadSerializer(), new ActividadQueryBuilder());
	}
	

}
