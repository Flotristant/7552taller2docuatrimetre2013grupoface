package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Mensaje;

import com.db.querys.MensajeQueryBuilder;
import com.ws.parsers.MensajeParser;
import com.ws.serializers.MensajeSerializer;

public class MensajeHandler extends Handler {
	
	public MensajeHandler() {
		super("ar.fiuba.redsocedu.datalayer.ws.Mensaje", new MensajeParser(), new MensajeSerializer());
		this.queryBuilder = new MensajeQueryBuilder();
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Mensaje entidadMensaje = (com.ws.pojos.Mensaje) object;
		Mensaje mensaje = new Mensaje();
		mensaje.setId(entidadMensaje.getId());
		// El mensajes tiene como autor un objeto Autor
//		mensaje.setAutor(entidadMensaje.getAutor()); 
		mensaje.setContenido(entidadMensaje.getContenido());
		//TODO: SETEAR FECHA
		//mensaje.setFecha(entidadMensaje.getFecha());
		return mensaje;	
	}
}
