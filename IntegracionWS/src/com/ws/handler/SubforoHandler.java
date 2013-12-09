package com.ws.handler;

import com.db.querys.SubforoQueryBuilder;
import com.ws.parsers.SubforoParser;
import com.ws.serializers.SubforoSerializer;

public class SubforoHandler extends Handler {


	public SubforoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Subforo", new  SubforoParser(), new SubforoSerializer());
		this.queryBuilder = new SubforoQueryBuilder();
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		
		com.ws.pojos.Subforo subforo = (com.ws.pojos.Subforo) object;
		ar.fiuba.redsocedu.datalayer.ws.Subforo subforoDb = new ar.fiuba.redsocedu.datalayer.ws.Subforo();
		subforoDb.setNombre(subforo.getNombre());
		
		if(subforo.getId() != null)
			subforoDb.setSubforoId(subforo.getId());
		
		if(subforo.getIdSeccion() != null)
			subforoDb.setSeccionId(subforo.getIdSeccion());
		if(subforo.getIdSubforoPadre() != null)
			subforoDb.setSubforoPadreId(subforo.getIdSubforoPadre());
		
		return subforoDb;
	}

}
