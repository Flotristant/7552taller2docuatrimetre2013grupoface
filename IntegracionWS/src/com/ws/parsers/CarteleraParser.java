package com.ws.parsers;

import com.ws.pojos.Cartelera;
import com.ws.tags.CarteleraTags;
import com.ws.tags.NoticiaTags;

public class CarteleraParser extends Parser {

	public CarteleraParser() {
		super(CarteleraTags.CLASS_TAG);
//		relaciones_directas.put(CarteleraParser.class.toString(), "carteleras");
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Cartelera objetoNegocio = (Cartelera) getEntidadNegocio(xml);
        return objetoNegocio.getDatabaseEntity();
	}

	private ar.fiuba.redsocedu.datalayer.ws.Cartelera toDBObject(
			Cartelera objetoNegocio) {
		ar.fiuba.redsocedu.datalayer.ws.Cartelera miObjDB = new ar.fiuba.redsocedu.datalayer.ws.Cartelera();
        
        miObjDB.setAmbitoId(objetoNegocio.getAmbitoId());
        miObjDB.setCarteleraId(objetoNegocio.getId());
        miObjDB.setId(objetoNegocio.getId());
        miObjDB.setNombre(objetoNegocio.getNombre());
		return miObjDB;
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
