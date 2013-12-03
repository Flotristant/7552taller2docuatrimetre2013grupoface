package com.ws.handler;

import com.db.querys.SeccionQueryBuilder;
import com.ws.parsers.SeccionParser;
import com.ws.serializers.SeccionSerializer;


public class SeccionHandler extends Handler {

	//TODO ver bien la entidad de base de datos
	public SeccionHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Seccion", new SeccionParser(), new SeccionSerializer());
		this.queryBuilder = new SeccionQueryBuilder();
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		//TODO ver bien esto
		/*com.ws.pojos.Seccion seccion = (com.ws.pojos.Seccion) object;
		ar.fiuba.redsocedu.datalayer.ws.Seccion seccionDb = new ar.fiuba.redsocedu.datalayer.ws.Seccion();
		seccionDb.setNombre(seccion.getNombre());
		secionDb.setIdForo(seccion.getIdForo());
		seccionDb.setIdAmbito(seccion.getIdAmbito());
		seccionDb.setId(seccion.getId());
		
		return foroDb;
		 */
		return null;
	}

}
