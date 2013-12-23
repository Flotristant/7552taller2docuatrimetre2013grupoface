package com.ws.parsers;

import java.util.HashMap;

import com.ws.pojos.Muro;
import com.ws.tags.EventoTags;
import com.ws.tags.MuroTags;
import com.ws.tags.SeccionTags;

public class MuroParser extends Parser {

	public MuroParser() {
		super(MuroTags.CLASS_TAG);
		relaciones = new HashMap<String, String>();
		relaciones.put(MuroParser.class.toString(), "muros");
		relaciones.put(EventoParser.class.toString(), "eventos");
		relaciones.put(AmbitoParser.class.toString(), "ambito");
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MuroTags.ID_TAG));
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Muro muro = (Muro) getEntidadNegocio(xml);
		return muro.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		return (parser instanceof EventoParser)||(parser instanceof AmbitoParser);
	}
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(EventoTags.CLASS_TAG, "com.ws.pojos."
				+ EventoTags.CLASS_TAG);
		return xml;
	}
	

}
