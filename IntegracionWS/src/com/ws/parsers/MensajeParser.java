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
	public Object getEntidad(String xml) {
		Mensaje mensaje = new Mensaje();
		mensaje.setId(Long.parseLong(this.campos.get(MensajeTags.ID_TAG)));
		mensaje.setAutor(this.campos.get(MensajeTags.AUTOR_TAG));
		mensaje.setContenido(this.campos.get(MensajeTags.CONTENIDO_TAG));
		mensaje.setFecha(this.campos.get(MensajeTags.FECHA_TAG));
		return mensaje;
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MensajeTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}
}
