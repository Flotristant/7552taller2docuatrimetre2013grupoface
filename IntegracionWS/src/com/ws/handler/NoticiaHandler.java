package com.ws.handler;

import com.db.querys.NoticiaQueryBuilder;
import com.ws.parsers.NoticiaParser;
import com.ws.serializers.NoticiaSerializer;

public class NoticiaHandler extends Handler {

	public NoticiaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Noticia", new NoticiaParser(), new NoticiaSerializer(), new NoticiaQueryBuilder());
	}


}
