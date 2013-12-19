package com.ws.parsers;

import com.ws.pojos.Grupo;
import com.ws.pojos.Nota;
import com.ws.tags.GrupoTags;

public class GrupoParser extends Parser  {

	public GrupoParser() {
		super(GrupoTags.CLASS_TAG);
		this.relaciones.put(GrupoParser.class.toString(), "grupos");
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(GrupoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Grupo grupo = (Grupo) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Grupo grupoDB = (ar.fiuba.redsocedu.datalayer.ws.Grupo)getDBObjectFromBussinessObject(grupo);
		//TODO ver si hay que setearle el username
		
		return grupoDB;
	}
	
	public Object getDBObjectFromBussinessObject(
			Object object) {
		Grupo grupo = (Grupo) object;
		ar.fiuba.redsocedu.datalayer.ws.Grupo grupoDB = new ar.fiuba.redsocedu.datalayer.ws.Grupo();
	    
		grupoDB.setGrupoId(grupo.getGrupoId());
		grupoDB.setActividadId(grupo.getActividadId());
		return grupoDB;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
