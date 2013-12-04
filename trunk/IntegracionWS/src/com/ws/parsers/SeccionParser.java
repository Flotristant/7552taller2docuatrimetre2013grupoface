package com.ws.parsers;

import com.ws.pojos.Seccion;
import com.ws.tags.SeccionTags;

public class SeccionParser extends Parser {

	public SeccionParser() {
		super(SeccionTags.CLASS_TAG);
	}

	@Override
	public Object getEntidad(String xml) {
		Seccion seccion = new Seccion();
		if(this.campos.get(SeccionTags.ID_TAG) != null){
			seccion.setId(Long.parseLong(this.campos.get(SeccionTags.ID_TAG)));
		}
		if(this.campos.get(SeccionTags.ID_AMBITO_TAG) != null){
			seccion.setIdAmbito(Long.parseLong(this.campos.get(SeccionTags.ID_AMBITO_TAG)));
		}
		if(this.campos.get(SeccionTags.ID_FORO_TAG) != null){
			seccion.setIdForo(Long.parseLong(this.campos.get(SeccionTags.ID_FORO_TAG)));
		}
		seccion.setNombre(this.campos.get(SeccionTags.NOMBRE_TAG));
		return seccion;
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(SeccionTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
