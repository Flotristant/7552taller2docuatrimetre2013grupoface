package com.ws.parsers;

import com.ws.pojos.Noticia;
import com.ws.tags.NoticiaTags;


public class NoticiaParser extends Parser {

	public NoticiaParser() {
		super(NoticiaTags.CLASS_TAG);
		this.relaciones.put(NoticiaParser.class.toString(), "noticias");
	}
	
	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(NoticiaTags.ID_TAG));
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Noticia miNoticiaNegocio = (Noticia) getEntidadNegocio(xml);
		return miNoticiaNegocio.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
