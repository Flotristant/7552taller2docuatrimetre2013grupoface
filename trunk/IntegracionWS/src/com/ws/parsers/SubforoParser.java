package com.ws.parsers;

import java.util.HashMap;

import com.ws.pojos.Subforo;
import com.ws.tags.SubforoTags;
import com.ws.tags.TemaTags;

public class SubforoParser extends Parser{

	
	public SubforoParser() {
		super(SubforoTags.CLASS_TAG);
		this.relaciones_directas = new HashMap<String, String>();
		this.relaciones_directas.put(SubforoParser.class.toString(), "subforos");
		this.relaciones_directas.put(TemaParser.class.toString(), "temas");
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Subforo subforo = (Subforo) getEntidadNegocio(xml);
		return subforo.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace("<"+TemaTags.CLASS_TAG+">", "<com.ws.pojos."
				+ TemaTags.CLASS_TAG + ">");
		xml = xml.replace("</"+TemaTags.CLASS_TAG+">", "</com.ws.pojos."
				+ TemaTags.CLASS_TAG + ">");
		return xml;
	}
}
