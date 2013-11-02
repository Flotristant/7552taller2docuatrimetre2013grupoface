package com.ws.parsers;

import java.util.Map;

import org.w3c.dom.Document;

public abstract class Parser {
	
	Document doc;
	
	public Parser(Document doc) {
		this.doc = doc;
	}
	
	public Boolean esJoin() {
		return false;
	}
	public abstract Boolean esSelect();
	public abstract Map<String, String> obtenerCampos(); 
}
