package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Seccion;

import com.db.querys.SubforoQueryBuilder;
import com.ws.parsers.SubforoParser;
import com.ws.serializers.SubforoSerializer;

public class SubforoHandler extends Handler {


	public SubforoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Subforo", new  SubforoParser(), new SubforoSerializer(), new SubforoQueryBuilder());
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		
		com.ws.pojos.Subforo subforo = (com.ws.pojos.Subforo) object;
		ar.fiuba.redsocedu.datalayer.ws.Subforo subforoDb = new ar.fiuba.redsocedu.datalayer.ws.Subforo();
		subforoDb.setNombre(subforo.getNombre());
		
		if(subforo.getId() != null)
			subforoDb.setSubforoId(subforo.getId());
		
		if(subforo.getIdSeccion() != null) {
			Seccion seccion = new Seccion();
			seccion.setId(subforo.getIdSeccion());
			subforoDb.setSeccionId(seccion.getId());
		} 
			
		if(subforo.getIdSubforoPadre() != null) {
			ar.fiuba.redsocedu.datalayer.ws.Subforo subforoPadre = new ar.fiuba.redsocedu.datalayer.ws.Subforo();
			subforoPadre.setId(subforo.getIdSubforoPadre());
			subforoDb.setSubforopadreId(subforoPadre.getId());			
		}

		
		return subforoDb;
	}

}