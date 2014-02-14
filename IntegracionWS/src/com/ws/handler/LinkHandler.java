package com.ws.handler;

import com.db.querys.LinkQueryBuilder;
import com.ws.parsers.LinkParser;
import com.ws.serializers.LinkSerializer;

public class LinkHandler extends MaterialesHandler{

	public LinkHandler(){
		super("ar.fiuba.redsocedu.datalayer.dtos.Link",new LinkParser(),new LinkSerializer(), new LinkQueryBuilder());
	}
	

}
