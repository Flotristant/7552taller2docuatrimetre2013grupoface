package com.db.querys;

import com.ws.tags.UsuarioTags;

public class UsuarioQueryBuilder extends QueryBuilder{

	public UsuarioQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Usuario", UsuarioTags.ID_TAG);
	}
}
