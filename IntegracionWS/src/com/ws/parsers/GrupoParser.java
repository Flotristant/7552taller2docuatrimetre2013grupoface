package com.ws.parsers;

import com.ws.pojos.Grupo;
import com.ws.pojos.Nota;
import com.ws.tags.ActividadTags;
import com.ws.tags.GrupoTags;
import com.ws.tags.NotaTags;

public class GrupoParser extends Parser  {

	public GrupoParser() {
		super(GrupoTags.CLASS_TAG);
		this.relaciones_directas.put(NotaParser.class.toString(), "notas");
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Grupo grupo = (Grupo) getEntidadNegocio(xml);
		return grupo.getDatabaseEntity();
	}
	
	public Object getDBObjectFromBussinessObject(
			Object object) {
		Grupo grupo = (Grupo) object;
		ar.fiuba.redsocedu.datalayer.ws.Grupo grupoDB = new ar.fiuba.redsocedu.datalayer.ws.Grupo();
	    
		grupoDB.setId(grupo.getId());
		grupoDB.setActividadId(grupo.getActividadId());
		return grupoDB;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);

		xml = xml.replace("<"+NotaTags.CLASS_TAG+">", "<com.ws.pojos."
				+ NotaTags.CLASS_TAG + ">");
		xml = xml.replace("</"+NotaTags.CLASS_TAG+">", "</com.ws.pojos."
				+ NotaTags.CLASS_TAG + ">");
		return xml;
	}

}
