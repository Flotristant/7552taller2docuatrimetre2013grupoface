package com.ws.parsers;

import com.ws.pojos.Nota;
import com.ws.tags.NotaTags;

public class NotaParser extends Parser {

	public NotaParser() {
		super(NotaTags.CLASS_TAG);
		this.relaciones_directas.put(NotaParser.class.toString(), "notas");
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Nota notaNegocio = (Nota) getEntidadNegocio(xml);
        return notaNegocio.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
