package com.ws.parsers;

import com.ws.pojos.Foro;
import com.ws.tags.ForoTags;
import com.ws.tags.NotaTags;
import com.ws.tags.NoticiaTags;
import com.ws.tags.SeccionTags;

public class ForoParser extends Parser {

    public ForoParser() {
        super(ForoTags.CLASS_TAG);
        relaciones_directas.put(SeccionParser.class.toString(), "secciones");
    }

    @Override
    protected Boolean validateJoinParser(Parser parser) {
        return (parser instanceof SeccionParser);
    }

    @Override
    public Object getDBObjectFromBusinessXML(String xml) {
        Foro foro = (Foro) getEntidadNegocio(xml);
        return foro.getDatabaseEntity();
    }
    
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace("<"+SeccionTags.CLASS_TAG+">", "<com.ws.pojos."
				+ SeccionTags.CLASS_TAG + ">");
		xml = xml.replace("</"+SeccionTags.CLASS_TAG+">", "</com.ws.pojos."
				+ SeccionTags.CLASS_TAG + ">");
		return xml;
	}

}
