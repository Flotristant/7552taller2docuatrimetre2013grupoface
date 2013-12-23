package com.ws.parsers;

import com.ws.pojos.Seccion;
import com.ws.tags.SeccionTags;
import com.ws.tags.SubforoTags;
import com.ws.tags.TemaTags;

public class SeccionParser extends Parser {

    public SeccionParser() {
        super(SeccionTags.CLASS_TAG);
        relaciones.put(SubforoParser.class.toString(), "subforos");
        relaciones.put(SeccionParser.class.toString(), "secciones");
    }

    @Override
    public Long getId() {
        return Long.parseLong(this.campos.get(SeccionTags.ID_TAG));
    }

    @Override
    public Object getDBObjectFromBusinessXML(String xml) {
        Seccion seccion = (Seccion) getEntidadNegocio(xml);
        return seccion.getDatabaseEntity();
    }

    @Override
    protected Boolean validateJoinParser(Parser parser) {
        return (parser instanceof SubforoParser);
    }
    
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(SubforoTags.CLASS_TAG, "com.ws.pojos."
				+ SubforoTags.CLASS_TAG);
		return xml;
	}
}
