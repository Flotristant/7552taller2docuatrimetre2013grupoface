package com.ws.parsers;

import java.util.HashMap;

import org.w3c.dom.NodeList;

public abstract class UsuarioParser extends Parser {

	public UsuarioParser(NodeList root) {
		super(root);
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
