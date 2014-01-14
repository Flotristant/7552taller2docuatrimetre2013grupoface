package com.ws.parsers;

import com.ws.pojos.Recurso;
import com.ws.tags.RecursoTags;

public class RecursoParser extends Parser {

	public RecursoParser(){
		super(RecursoTags.CLASS_TAG);
	}
	
	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Recurso recurso = (Recurso) getEntidadNegocio(xml);
		return recurso.getDatabaseEntity();
		
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
