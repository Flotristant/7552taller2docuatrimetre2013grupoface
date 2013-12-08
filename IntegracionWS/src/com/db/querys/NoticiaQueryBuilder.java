package com.db.querys;

import com.ws.tags.NoticiaTags;

public class NoticiaQueryBuilder extends QueryBuilder {

	public NoticiaQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Noticia", NoticiaTags.ID_TAG);
	}

}
