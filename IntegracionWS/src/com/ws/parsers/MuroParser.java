package com.ws.parsers;

import java.util.Map;

import com.ws.pojos.Muro;
import com.ws.tags.MuroTags;

public class MuroParser extends Parser {

	public MuroParser() {
		super(MuroTags.CLASS_TAG);
	}

	@Override
	public Map<String, String> obtenerCampos() {
		return null;
	}
	
	public Muro getEntidadMuro() {
		Muro muro = new Muro();
		muro.setId(Long.parseLong(this.campos.get(MuroTags.ID_TAG)));
		muro.setNombre(this.campos.get(MuroTags.NOMBRE_TAG));
		return muro;
	}

	@Override
	public Object getEntidad() {
		// TODO Auto-generated method stub
		return null;
	}

}
