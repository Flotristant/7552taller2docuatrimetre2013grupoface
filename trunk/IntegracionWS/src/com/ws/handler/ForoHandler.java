package com.ws.handler;

import com.db.querys.ForoQueryBuilder;
import com.ws.parsers.ForoParser;
import com.ws.serializers.ForoSerializer;

public class ForoHandler extends Handler{

	//TODO ver si la entidad se llama asi
	public ForoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Foro", new ForoParser(), new ForoSerializer());
		this.queryBuilder = new ForoQueryBuilder();
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		//TODO ver bien esto
		/*com.ws.pojos.Foro foro = (com.ws.pojos.Foro) object;
		ar.fiuba.redsocedu.datalayer.ws.Foro foroDb = new ar.fiuba.redsocedu.datalayer.ws.Foro();
		foroDb.setNombre(foro.getNombre());
		foroDb.setIdForo(foro.getId());
		foroDb.setIdAmbito(foro.getIdAmbito());
		
		return foroDb;
		 */
		return null;
	}
}
