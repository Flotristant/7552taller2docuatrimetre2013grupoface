package com.db.querys;

import com.ws.tags.NotaTags;

public class NotaQueryBuilder extends QueryBuilder{

	public NotaQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Nota", NotaTags.ID_TAG);
	}

}
