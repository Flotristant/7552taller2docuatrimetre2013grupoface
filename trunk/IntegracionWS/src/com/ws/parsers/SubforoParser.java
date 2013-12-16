package com.ws.parsers;

import java.util.HashMap;

import com.ws.pojos.Subforo;
import com.ws.tags.SubforoTags;

public class SubforoParser extends Parser{

	
	public SubforoParser() {
		super(SubforoTags.CLASS_TAG);
		this.relaciones = new HashMap<String, String>();
		this.relaciones.put(SubforoParser.class.toString(), "subforos");
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
			subforoDB.setSubforopadreId(subforo.getIdSubforoPadre());
		return subforoDB;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}
}
