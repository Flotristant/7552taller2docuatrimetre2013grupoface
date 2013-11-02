package com.ws.handler;

import org.w3c.dom.NodeList;

public interface Handler {
	
	public String guardarDatos(NodeList root);
	public String actualizarDatos(NodeList root);
	public String borrarDatos(NodeList root);
	public String seleccionarDatos(NodeList root);
}
