package com.ws.handler;

import com.db.querys.TemaQueryBuilder;
import com.ws.parsers.TemaParser;
import com.ws.serializers.TemaSerializer;

public class TemaHandler extends Handler {
	
	public TemaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Tema", new TemaParser(), new TemaSerializer(), new TemaQueryBuilder());
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		
		ar.fiuba.redsocedu.datalayer.ws.Tema temaDB = new ar.fiuba.redsocedu.datalayer.ws.Tema();
		com.ws.pojos.Tema entidadTema = (com.ws.pojos.Tema) object;
		
		temaDB.setId(entidadTema.getId());
		temaDB.setUsername(entidadTema.getAutor());
		temaDB.setSubforoId(entidadTema.getIdSubforo());
		
		return temaDB;
		
	}
}
