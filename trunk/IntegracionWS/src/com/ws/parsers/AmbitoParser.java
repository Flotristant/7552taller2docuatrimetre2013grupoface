package com.ws.parsers;


import java.util.HashMap;

import com.ws.pojos.Ambito;
import com.ws.tags.AmbitoTags;


public class AmbitoParser extends Parser {

	public AmbitoParser() {
		super(AmbitoTags.CLASS_TAG);
		relaciones = new HashMap<String, String>();
		relaciones.put(MuroParser.class.toString(), "muros");
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(AmbitoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Ambito ambito = (Ambito) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Ambito ambitoDB = new ar.fiuba.redsocedu.datalayer.ws.Ambito();
		ambitoDB.setId(ambito.getAmbitoId());
		return ambito;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		return (parser instanceof MuroParser);
	}

}
