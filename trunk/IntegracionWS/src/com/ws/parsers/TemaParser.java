package com.ws.parsers;

import com.ws.pojos.Tema;
import com.ws.tags.TemaTags;

public class TemaParser extends Parser  {

	public TemaParser() {
		super(TemaTags.CLASS_TAG);
	}
	
	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(TemaTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Tema tema = (Tema) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Tema temaDB = new ar.fiuba.redsocedu.datalayer.ws.Tema();
		temaDB.setId(tema.getId());
//		temaDB.setSubforoId(tema.getIdSubforo());
//		temaDB.setUsername(tema.getAutor());
		return temaDB;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}
}
