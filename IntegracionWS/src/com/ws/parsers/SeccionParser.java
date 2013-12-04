package com.ws.parsers;

import com.ws.pojos.Seccion;
import com.ws.tags.SeccionTags;

public class SeccionParser extends Parser {

	public SeccionParser() {
		super(SeccionTags.CLASS_TAG);
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
