package com.ws.parsers;


import com.ws.pojos.Ambito;
import com.ws.tags.AmbitoTags;
import com.ws.tags.CarteleraTags;
import com.ws.tags.ChatTags;
import com.ws.tags.ForoTags;
import com.ws.tags.GrupoTags;
import com.ws.tags.MuroTags;
import com.ws.tags.NotaTags;


public class AmbitoParser extends Parser {

	public AmbitoParser() {
		super(AmbitoTags.CLASS_TAG);
		relaciones.put(MuroParser.class.toString(), "muros");
		relaciones.put(AmbitoParser.class.toString(), "ambitos");
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(AmbitoTags.ID_TAG));
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Ambito ambito = (Ambito) getEntidadNegocio(xml);
		return ambito.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		return (parser instanceof MuroParser);
	}
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(MuroTags.CLASS_TAG, "com.ws.pojos."
				+ MuroTags.CLASS_TAG);
		xml = xml.replace(ForoTags.CLASS_TAG, "com.ws.pojos."
				+ ForoTags.CLASS_TAG);
		xml = xml.replace(ChatTags.CLASS_TAG, "com.ws.pojos."
				+ ChatTags.CLASS_TAG);
		xml = xml.replace(CarteleraTags.CLASS_TAG, "com.ws.pojos."
				+ CarteleraTags.CLASS_TAG);
		return xml;
	}

}
