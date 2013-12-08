package com.db.querys;

import com.ws.tags.TemaTags;

public class TemaQueryBuilder extends QueryBuilder {

	public TemaQueryBuilder()	 {
		super("ar.fiuba.redsocedu.datalayer.dtos.Tema", TemaTags.ID_TAG);
	}
}
