package com.ws.parsers;

import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class Parser {
	
	Node root;
	
	public Parser(NodeList root) {
		this.root = root.item(0);
	}
	
	public Boolean esJoin() {
		return false;
	}
	public abstract Boolean esSelect();
	public abstract Map<String, String> obtenerCampos(); 
}
