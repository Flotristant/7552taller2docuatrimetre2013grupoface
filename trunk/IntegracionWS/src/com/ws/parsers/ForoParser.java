package com.ws.parsers;

import java.util.Map;

import org.w3c.dom.Document;

import com.ws.pojos.Foro;
import com.ws.tags.ForoTags;

public class ForoParser extends Parser {
	
	public ForoParser(Document doc) {
		super(ForoTags.CLASS_TAG);
	}

	public Foro getEntidadForo() {
		Foro foro = new Foro();
		foro.setId(Integer.parseInt(this.campos.get(ForoTags.ID_TAG)));
		foro.setNombre(this.campos.get(ForoTags.NOMBRE_TAG));
		return foro;
	}

	@Override
	public Map<String, String> obtenerCampos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEntidad() {
		// TODO Auto-generated method stub
		return null;
	}
}
