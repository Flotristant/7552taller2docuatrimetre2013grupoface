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
		subforoDB.setId(subforo.getId());
		subforoDB.setNombre(subforo.getNombre());
		
		if(subforo.getIdSeccion() != null)
			subforoDB.setSeccionId(subforo.getIdSeccion());
		if(subforo.getIdSubforoPadre() != null)
			subforoDB.setSubforoPadreId(subforo.getIdSubforoPadre());
		return subforoDB;
	}

	@Override
	protected String replaceClassTag(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
