package com.ws.parsers;

import java.util.HashMap;

import com.ws.pojos.Tema;
import com.ws.tags.MensajeTags;
import com.ws.tags.TemaTags;

public class TemaParser extends Parser  {

	public TemaParser() {
		super(TemaTags.CLASS_TAG);
		this.relaciones_directas = new HashMap<String, String>();
		this.relaciones_directas.put(MensajeParser.class.toString(), "mensajes");
	}
	
	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Tema tema = (Tema) getEntidadNegocio(xml);
		return tema.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace("<"+MensajeTags.CLASS_TAG+">", "<com.ws.pojos."
				+ MensajeTags.CLASS_TAG + ">");
		xml = xml.replace("</"+MensajeTags.CLASS_TAG+">", "</com.ws.pojos."
				+ MensajeTags.CLASS_TAG + ">");
		
		
		xml = xml.replace(MensajeTags.CLASS_TAG, "com.ws.pojos."
				+ MensajeTags.CLASS_TAG);
		return xml;
	}
}
