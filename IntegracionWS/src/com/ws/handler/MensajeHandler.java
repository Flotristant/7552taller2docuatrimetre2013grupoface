package com.ws.handler;

import ar.fiuba.redsocedu.datalayer.ws.Mensaje;

import com.db.querys.MensajeQueryBuilder;
import com.ws.parsers.MensajeParser;
import com.ws.serializers.MensajeSerializer;

public class MensajeHandler extends Handler {
	
	public MensajeHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Mensaje", new MensajeParser(), new MensajeSerializer());
		this.queryBuilder = new MensajeQueryBuilder();
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Mensaje entidadMensaje = (com.ws.pojos.Mensaje) object;
		Mensaje mensaje = new Mensaje();
		mensaje.setMensajeId(entidadMensaje.getId());
		mensaje.setAutor(entidadMensaje.getAutor());
		mensaje.setContenido(entidadMensaje.getContenido());
		//TODO: SETEAR FECHA
		//mensaje.setFecha(entidadMensaje.getFecha());
		return mensaje;	
	}
}
