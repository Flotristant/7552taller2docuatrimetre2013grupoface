package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Muro;

import com.db.querys.MuroQueryBuilder;
import com.ws.parsers.MuroParser;
import com.ws.serializers.MuroSerializer;

public class MuroHandler extends Handler {
	
	public MuroHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Muro", new MuroParser(), new MuroSerializer(), new MuroQueryBuilder());
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Muro entidadMuro = (com.ws.pojos.Muro) object;
		Muro muro = new Muro();
		muro.setId(entidadMuro.getId());
		muro.setNombre(muro.getNombre());
		return muro;	
	}
}
