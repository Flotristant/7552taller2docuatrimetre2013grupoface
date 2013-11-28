package com.ws.handler;

import org.w3c.dom.Document;

import com.ws.parsers.Parser;
import com.ws.serializers.Serializer;

public class CursoHandler extends Handler {

	public CursoHandler(String databaseEntityPath, Parser parser,
			Serializer serializer) {
		super(databaseEntityPath, parser, serializer);
		// TODO Auto-generated constructor stub
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
	protected Object toDatabaseEntity(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
