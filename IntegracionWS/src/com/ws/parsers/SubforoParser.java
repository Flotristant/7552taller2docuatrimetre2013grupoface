package com.ws.parsers;

import com.ws.pojos.Subforo;
import com.ws.tags.SubforoTags;

public class SubforoParser extends Parser{

	
	public SubforoParser() {
		super(SubforoTags.CLASS_TAG);
	}
	
	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(SubforoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Subforo subforo = (Subforo) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Subforo subforoDB = new ar.fiuba.redsocedu.datalayer.ws.Subforo();
		
		subforoDB.setNombre(subforo.getNombre());
		
		if(subforo.getId() != null)
			subforoDB.setId(subforo.getId());
		if(subforo.getIdSeccion() != null)
			subforoDB.setSeccionId(subforo.getIdSeccion());
		if(subforo.getIdSubforoPadre() != null)
			subforoDB.setSubforoPadreId(subforo.getIdSubforoPadre());
		return subforoDB;
	}
}
