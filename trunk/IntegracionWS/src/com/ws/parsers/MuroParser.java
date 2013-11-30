package com.ws.parsers;

import com.ws.pojos.Muro;
import com.ws.tags.MuroTags;

public class MuroParser extends Parser {

	public MuroParser() {
		super(MuroTags.CLASS_TAG);
	}
	
	@Override
	public Object getEntidad() {
		Muro muro = new Muro();
		muro.setId(Long.parseLong(this.campos.get(MuroTags.ID_TAG)));
		muro.setNombre(this.campos.get(MuroTags.NOMBRE_TAG));
		return muro;
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MuroTags.ID_TAG));
	}

}
