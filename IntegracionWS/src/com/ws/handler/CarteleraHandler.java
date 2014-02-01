package com.ws.handler;

import com.db.querys.CarteleraQueryBuilder;
import com.ws.parsers.CarteleraParser;
import com.ws.serializers.CarteleraSerializer;

public class CarteleraHandler extends Handler {

	public CarteleraHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Cartelera", new CarteleraParser(), new CarteleraSerializer(), new CarteleraQueryBuilder());
	}

	

}
