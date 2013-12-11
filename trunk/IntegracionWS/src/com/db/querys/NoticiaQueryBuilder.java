package com.db.querys;

import java.util.Map;

import com.ws.tags.NoticiaTags;

public class NoticiaQueryBuilder extends QueryBuilder {

	public NoticiaQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Noticia", NoticiaTags.ID_TAG);
	}

	private Boolean esJoin(Map<String, String> attributes){
		
		if (attributes.containsKey("join")) return true;
		else return false;
	}
}
