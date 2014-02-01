package com.ws.handler;

import com.db.querys.ForoQueryBuilder;
import com.ws.parsers.ForoParser;
import com.ws.serializers.ForoSerializer;

public class ForoHandler extends Handler{

	public ForoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Foro", new ForoParser(), new ForoSerializer(), new ForoQueryBuilder());
	}

}
