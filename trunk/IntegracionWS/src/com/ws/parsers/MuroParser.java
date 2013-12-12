package com.ws.parsers;

import com.ws.pojos.Muro;
import com.ws.tags.MuroTags;

public class MuroParser extends Parser {

	public MuroParser() {
		super(MuroTags.CLASS_TAG);
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MuroTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Muro muro = (Muro) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Muro muroDB = new ar.fiuba.redsocedu.datalayer.ws.Muro();
		muroDB.setId(muro.getId());
		muroDB.setNombre(muro.getNombre());
		return muro;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
