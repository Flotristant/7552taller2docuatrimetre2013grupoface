package com.ws.handler;

import org.w3c.dom.NodeList;

public interface Handler {
	
	public String guardarDatos(String xml);
	public String actualizarDatos(String xml);
	public String borrarDatos(String xml);
	public String seleccionarDatos(String xml);
}
