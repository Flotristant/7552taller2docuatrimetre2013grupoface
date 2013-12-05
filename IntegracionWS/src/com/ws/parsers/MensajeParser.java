package com.ws.parsers;

import java.util.Map;

import com.ws.pojos.Mensaje;
import com.ws.tags.MensajeTags;

public class MensajeParser extends Parser  {

	public MensajeParser() {
		super(MensajeTags.CLASS_TAG);
	}

	@Override
	public Map<String, String> getCampos() {
		return null;
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MensajeTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Mensaje mensaje = (Mensaje) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Mensaje mensajeDB = new ar.fiuba.redsocedu.datalayer.ws.Mensaje();
		mensajeDB.setContenido(mensaje.getContenido());
		mensajeDB.setId(mensaje.getId());
		return mensajeDB;
	}

}
