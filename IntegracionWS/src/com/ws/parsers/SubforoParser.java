package com.ws.parsers;

import com.ws.pojos.Subforo;
import com.ws.tags.SubforoTags;

public class SubforoParser extends Parser{

	
	public SubforoParser() {
		super(SubforoTags.CLASS_TAG);
	}
	
	@Override
	public Object getEntidad(String xml) {
		Subforo subforo = new Subforo();
		subforo.setIdForo(Long.parseLong(this.campos.get(SubforoTags.ID_FORO_TAG)));
		if(this.campos.get(SubforoTags.ID_SUBFOROPADRE_TAG) != null){
			subforo.setIdSubforoPadre(Long.parseLong(this.campos.get(SubforoTags.ID_SUBFOROPADRE_TAG)));
		}
		if(this.campos.get(SubforoTags.ID_SECCION_TAG) != null){
			subforo.setIdSeccion(Long.parseLong(this.campos.get(SubforoTags.ID_SECCION_TAG)));
		}
		if(this.campos.get(SubforoTags.ID_TAG) != null){
			subforo.setId(Long.parseLong(this.campos.get(SubforoTags.ID_TAG)));
		}
		subforo.setNombre(this.campos.get(SubforoTags.NOMBRE_TAG));
		return subforo;
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(SubforoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
