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
	public Object getDBObject(String xml) {
		
		Noticia miNoticiaNegocio = (Noticia) getEntidadNegocio(xml);
		
		ar.fiuba.redsocedu.datalayer.ws.Noticia miNoticiaDB = new ar.fiuba.redsocedu.datalayer.ws.Noticia();
		
//		miNoticiaDB.setNoticiaId(miNoticiaNegocio.getId());
		miNoticiaDB.setContenido(miNoticiaNegocio.getContenido());
		miNoticiaDB.setCarteleraId(miNoticiaNegocio.getCarteleraId());
		miNoticiaDB.setTitulo(miNoticiaNegocio.getTitulo());
		
		//TODO FALTA CARGAR EL CAMPO AUTOR, A LA FECHA EL POJO DE DB NO LO TIENE.
		
		return miNoticiaDB;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
