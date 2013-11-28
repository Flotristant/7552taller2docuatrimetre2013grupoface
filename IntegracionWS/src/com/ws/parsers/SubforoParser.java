package com.ws.parsers;

import java.util.Map;

import com.ws.pojos.Subforo;
import com.ws.tags.SubforoTags;

public class SubforoParser extends Parser{

	private Map<String, String> campos;
	
	public SubforoParser() {
		super(SubforoTags.CLASS_TAG);
		this.inicializarCampos();
	}
	
	@Override
	public Map<String, String> obtenerCampos() {
		return this.campos;
	}
	
	public Long getIdSubforo(){
		return Long.parseLong(this.campos.get(SubforoTags.ID_TAG));
	}

	@Override
	public Object getEntidad() {
		Subforo subforo = new Subforo();
		subforo.setIdForo(Long.parseLong(this.campos.get(SubforoTags.ID_FORO_TAG)));
		if(this.campos.get(SubforoTags.ID_SUBFOROPADRE_TAG) != null){
			subforo.setIdSubforoPadre(Long.parseLong(this.campos.get(SubforoTags.ID_SUBFOROPADRE_TAG)));
		}
		if(this.campos.get(SubforoTags.ID_SECCION_TAG) != null){
			subforo.setIdSeccion(Long.parseLong(this.campos.get(SubforoTags.ID_SECCION_TAG)));
		}
		if(this.campos.get(SubforoTags.ID_TAG) != null){
			subforo.setIdSubforo(Long.parseLong(this.campos.get(SubforoTags.ID_TAG)));
		}
		subforo.setNombre(this.campos.get(SubforoTags.NOMBRE_TAG));
		return subforo;
	}

}
