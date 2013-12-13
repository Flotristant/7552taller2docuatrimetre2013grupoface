package com.ws.handler;

import com.db.querys.GrupoQueryBuilder;
import com.ws.parsers.GrupoParser;
import com.ws.pojos.Grupo;
import com.ws.serializers.GrupoSerializer;

public class GrupoHandler extends Handler{



	public GrupoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Grupo", new GrupoParser(), new GrupoSerializer(), new GrupoQueryBuilder());
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		Grupo grupo = (Grupo) object;
		ar.fiuba.redsocedu.datalayer.ws.Grupo grupoDB = new ar.fiuba.redsocedu.datalayer.ws.Grupo();
	    
		grupoDB.setGrupoId(grupo.getGrupoId());
		grupoDB.setActividadId(grupo.getActividadId());
		//TODO ver si hay que setearle el username
		
		return grupoDB;
	}

}
