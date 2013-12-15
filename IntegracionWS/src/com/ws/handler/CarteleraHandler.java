package com.ws.handler;

import com.db.querys.CarteleraQueryBuilder;
import com.ws.parsers.CarteleraParser;
import com.ws.serializers.CarteleraSerializer;

public class CarteleraHandler extends Handler {

	public CarteleraHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Cartelera", new CarteleraParser(), new CarteleraSerializer(), new CarteleraQueryBuilder());
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Cartelera carteleraNeg = (com.ws.pojos.Cartelera ) object;
		ar.fiuba.redsocedu.datalayer.ws.Cartelera carteleraDB = new ar.fiuba.redsocedu.datalayer.ws.Cartelera();
		carteleraDB.setNombre(carteleraNeg.getNombre());
		return carteleraDB;
	}
	

}
