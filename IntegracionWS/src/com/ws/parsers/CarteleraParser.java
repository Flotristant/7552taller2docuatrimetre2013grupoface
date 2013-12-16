package com.ws.parsers;

import com.ws.tags.CarteleraTags;

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

}
