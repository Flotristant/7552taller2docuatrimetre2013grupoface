package com.ws.parsers;

import java.util.Map;

import org.w3c.dom.Document;

import com.ws.pojos.Muro;
import com.ws.tags.MuroTags;

public class MuroParser extends Parser {

	public MuroParser(Document doc) {
		super(doc, MuroTags.CLASS_TAG);
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

}
