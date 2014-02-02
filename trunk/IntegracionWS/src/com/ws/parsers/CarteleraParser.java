package com.ws.parsers;

import com.ws.pojos.Cartelera;
import com.ws.tags.CarteleraTags;
import com.ws.tags.NoticiaTags;

public class CarteleraParser extends Parser {

	public CarteleraParser() {
		super(CarteleraTags.CLASS_TAG);
		relaciones_directas.put(NoticiaParser.class.toString(), "noticias");
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Cartelera objetoNegocio = (Cartelera) getEntidadNegocio(xml);
        return objetoNegocio.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		return true;
	}
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(NoticiaTags.CLASS_TAG, "com.ws.pojos."
				+ NoticiaTags.CLASS_TAG);
		return xml;
	}

}
