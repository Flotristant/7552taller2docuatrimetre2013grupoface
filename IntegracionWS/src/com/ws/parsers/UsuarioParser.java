package com.ws.parsers;

import java.util.HashMap;

import org.w3c.dom.Document;

public abstract class UsuarioParser extends Parser {

	public UsuarioParser(Document doc) {
		super(doc);
	}

	@Override
	public Boolean esJoin() {
		
		return null;
	}

	@Override
	public Boolean esSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> obtenerCampos() {
		// TODO Auto-generated method stub
		return null;
	}

}
