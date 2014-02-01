package com.ws.handler;

import com.db.querys.UsuarioQueryBuilder;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.UsuarioSerializer;


public class UsuarioHandler extends Handler {

	public UsuarioHandler(){
		super("ar.fiuba.redsocedu.datalayer.dtos.Usuario", new UsuarioParser(), new UsuarioSerializer(), new UsuarioQueryBuilder());
	}
	

}
