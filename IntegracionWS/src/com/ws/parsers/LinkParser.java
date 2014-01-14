package com.ws.parsers;

import com.ws.pojos.Link;
import com.ws.tags.LinkTags;

public class LinkParser extends Parser{
	
	public LinkParser(){
		super(LinkTags.CLASS_TAG);
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Link link = (Link) getEntidadNegocio(xml);
		return link.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
