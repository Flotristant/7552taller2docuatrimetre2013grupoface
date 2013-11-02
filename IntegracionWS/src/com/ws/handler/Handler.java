package com.ws.handler;

import org.w3c.dom.Document;

import com.db.querys.QueryBuilder;

public abstract class Handler {
	
	QueryBuilder queryBuilder;
	
	public abstract String guardarDatos(Document doc);
	public abstract String actualizarDatos(Document doc);
	public abstract String borrarDatos(Document doc);
	public abstract String seleccionarDatos(Document doc);
}
