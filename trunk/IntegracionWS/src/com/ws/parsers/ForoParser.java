package com.ws.parsers;

import com.ws.pojos.Foro;
import com.ws.tags.ForoTags;

public class ForoParser extends Parser {
	
	public ForoParser() {
		super(ForoTags.CLASS_TAG);
	}

	//TODO: fix me
	@Override
	public Object getEntidad(String xml) {
		Foro foro = new Foro();
		if(this.campos.get(ForoTags.ID_TAG) != null){
			foro.setId(Long.parseLong(this.campos.get(ForoTags.ID_TAG)));
		}
		foro.setNombre(this.campos.get(ForoTags.NOMBRE_TAG));
		if(this.campos.get(ForoTags.ID_AMBITO_TAG) != null){
			foro.setIdAmbito(Long.parseLong(this.campos.get(ForoTags.ID_AMBITO_TAG)));
		}
		return foro;
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(ForoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}
}
