package com.ws.parsers;

import java.util.Map;

import com.ws.pojos.Tema;
import com.ws.tags.TemaTags;

public class TemaParser extends Parser  {

	public TemaParser() {
		super(TemaTags.CLASS_TAG);
	}

	@Override
	public Map<String, String> obtenerCampos() {
		return null;
	}
	
	public Tema getEntidadTema() {
		Tema tema = new Tema();
		tema.setId(Long.parseLong(this.campos.get(TemaTags.ID_TAG)));
		tema.setAutor(this.campos.get(TemaTags.AUTOR_TAG));
		tema.setFecha(this.campos.get(TemaTags.FECHA_TAG));
		tema.setEsSticky(Boolean.parseBoolean(this.campos.get(TemaTags.STICKY_TAG)));
		return tema;
	}

	@Override
	public Object getEntidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(TemaTags.ID_TAG));
	}
}
