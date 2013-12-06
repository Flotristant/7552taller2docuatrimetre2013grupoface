package com.ws.handler;

import com.db.querys.SeccionQueryBuilder;
import com.ws.parsers.SeccionParser;
import com.ws.serializers.SeccionSerializer;


public class SeccionHandler extends Handler {

	public SeccionHandler() {
		super("ar.fiuba.redsocedu.datalayer.ws.Seccion", new SeccionParser(), new SeccionSerializer());
		this.queryBuilder = new SeccionQueryBuilder();
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Seccion seccion = (com.ws.pojos.Seccion) object;
		ar.fiuba.redsocedu.datalayer.ws.Seccion seccionDb = new ar.fiuba.redsocedu.datalayer.ws.Seccion();
		seccionDb.setNombre(seccion.getNombre());
		seccionDb.setForoId(seccion.getIdForo());
		seccionDb.setId(seccion.getId());
		
		return seccionDb;
		 
	}

}
