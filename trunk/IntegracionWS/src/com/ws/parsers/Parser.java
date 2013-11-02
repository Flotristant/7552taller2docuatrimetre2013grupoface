package com.ws.parsers;

import java.util.Map;

public interface Parser {

	public Boolean esJoin();
	public Boolean esSelect();
	public Map<String, String> obtenerCampos(); 
}
