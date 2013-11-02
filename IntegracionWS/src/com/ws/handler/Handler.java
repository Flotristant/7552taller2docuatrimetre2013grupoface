package com.ws.handler;

import org.w3c.dom.Document;

public interface Handler {
	
	public String guardarDatos(Document doc);
	public String actualizarDatos(Document doc);
	public String borrarDatos(Document doc);
	public String seleccionarDatos(Document doc);
}
