package com.ws.handler;

import com.db.querys.GrupoQueryBuilder;
import com.ws.parsers.GrupoParser;
import com.ws.pojos.Grupo;
import com.ws.serializers.GrupoSerializer;

public class GrupoHandler extends Handler{



	public GrupoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Grupo", new GrupoParser(), new GrupoSerializer(), new GrupoQueryBuilder());
	}


}
