package com.ws.handler;

import com.db.querys.NoticiaQueryBuilder;
import com.ws.parsers.NoticiaParser;
import com.ws.serializers.NoticiaSerializer;

public class NoticiaHandler extends Handler {

	public NoticiaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Noticia", new NoticiaParser(), new NoticiaSerializer(), new NoticiaQueryBuilder());
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Noticia noticiaNeg = (com.ws.pojos.Noticia) object;
		ar.fiuba.redsocedu.datalayer.ws.Noticia noticiaDB = new ar.fiuba.redsocedu.datalayer.ws.Noticia();
		noticiaDB.setCarteleraId(noticiaNeg.getCarteleraId());
		noticiaDB.setId(noticiaNeg.getId());
		noticiaDB.setContenido(noticiaNeg.getContenido());
		noticiaDB.setNoticiaId(noticiaNeg.getId());
		noticiaDB.setTitulo(noticiaNeg.getTitulo());
		return noticiaDB;
	}

}
