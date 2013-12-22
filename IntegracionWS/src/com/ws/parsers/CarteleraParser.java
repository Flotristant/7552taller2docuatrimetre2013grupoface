package com.ws.parsers;

import com.ws.tags.CarteleraTags;
import com.ws.tags.NoticiaTags;

public class CarteleraParser extends Parser {

	public CarteleraParser() {
		super(CarteleraTags.CLASS_TAG);
		relaciones.put(CarteleraParser.class.toString(), "carteleras");
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(NoticiaTags.CLASS_TAG, "com.ws.pojos."
				+ NoticiaTags.CLASS_TAG);
		return xml;
	}

}
