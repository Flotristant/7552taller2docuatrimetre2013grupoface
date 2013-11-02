package com.ws.handler;

import java.util.Map;

import org.w3c.dom.Document;

import com.db.querys.UsuarioQueryBuilder;
import com.ws.parsers.UsuarioParser;
import com.ws.tags.UsuarioTags;

public class UsuarioHandler extends Handler {
	
	public UsuarioHandler() {
		this.queryBuilder = new UsuarioQueryBuilder();
	}
	
	@Override
	public String guardarDatos(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizarDatos(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String borrarDatos(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String seleccionarDatos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		Map<String, String > campos = parser.obtenerCampos();
		String query = this.queryBuilder.getAllById(campos.get(UsuarioTags.ID_TAG));
		
		return query;
	}

}
