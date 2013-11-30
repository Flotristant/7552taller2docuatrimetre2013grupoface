package com.ws.handler;

import com.db.querys.SubforoQueryBuilder;
import com.ws.parsers.SubforoParser;
import com.ws.serializers.SubforoSerializer;

public class SubforoHandler extends Handler {


	//TODO ver si la entidad se llama asi
	public SubforoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Subforo", new  SubforoParser(), new SubforoSerializer());
		this.queryBuilder = new SubforoQueryBuilder();
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		// TODO ver bien esto
		/*com.ws.pojos.Subforo subforo = (com.ws.pojos.Subforo) object;
		ar.fiuba.redsocedu.datalayer.ws.Subforo subforoDb = new ar.fiuba.redsocedu.datalayer.ws.Subforo();
		subforoDb.setNombre(subforo.getNombre());
		subforoDb.setIdForo(subforo.getIdForo());
		subforoDb.setIdSubforo(subforo.getIdSubforo());
		subforoDb.setIdSeccion(subforo.getIdSeccion());
		subforoDb.setIdSubforoPadre(subforo.getIdSubforoPadre());
		
		return subforoDb;*/
		
		return null;
	}

}
