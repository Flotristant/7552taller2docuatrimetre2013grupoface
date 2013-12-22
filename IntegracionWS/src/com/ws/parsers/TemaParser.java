package com.ws.parsers;

import java.util.HashMap;

import com.ws.pojos.Tema;
import com.ws.tags.MensajeTags;
import com.ws.tags.TemaTags;

public class TemaParser extends Parser  {

	public TemaParser() {
		super(TemaTags.CLASS_TAG);
		this.relaciones = new HashMap<String, String>();
		this.relaciones.put(TemaParser.class.toString(), "temas");
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
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(MensajeTags.CLASS_TAG, "com.ws.pojos."
				+ MensajeTags.CLASS_TAG);
		return xml;
	}
}
