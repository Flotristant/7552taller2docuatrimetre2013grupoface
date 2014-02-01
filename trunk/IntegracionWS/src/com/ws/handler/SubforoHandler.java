package com.ws.handler;

import com.db.querys.SubforoQueryBuilder;
import com.ws.parsers.SubforoParser;
import com.ws.serializers.SubforoSerializer;

public class SubforoHandler extends Handler {


	public SubforoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Subforo", new  SubforoParser(), new SubforoSerializer(), new SubforoQueryBuilder());
	}


}
