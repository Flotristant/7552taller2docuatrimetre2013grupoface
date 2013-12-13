package com.ws.parsers;

import com.ws.pojos.Grupo;
import com.ws.tags.GrupoTags;

public class GrupoParser extends Parser  {

	public GrupoParser() {
		super(GrupoTags.CLASS_TAG);
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(GrupoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Grupo grupo = (Grupo) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Grupo grupoDB = new ar.fiuba.redsocedu.datalayer.ws.Grupo();
	    
		grupoDB.setGrupoId(grupo.getGrupoId());
		grupoDB.setActividadId(grupo.getActividadId());
		//TODO ver si hay que setearle el username
		
		return grupoDB;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
