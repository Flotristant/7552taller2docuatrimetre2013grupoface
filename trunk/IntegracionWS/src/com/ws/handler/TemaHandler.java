package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Tema;

import com.db.querys.TemaQueryBuilder;
import com.ws.parsers.TemaParser;
import com.ws.serializers.TemaSerializer;

public class TemaHandler extends Handler {
	
	public TemaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Tema", new TemaParser(), new TemaSerializer());
		this.queryBuilder = new TemaQueryBuilder();
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Tema entidadTema = (com.ws.pojos.Tema) object;
		Tema tema = new Tema();
		tema.setTemaId(entidadTema.getId());
		tema.setNombre(entidadTema.getAutor());
		return tema;	
	}
}
