package com.ws.parsers;

import com.ws.pojos.Foro;
import com.ws.tags.ForoTags;
import com.ws.tags.NoticiaTags;
import com.ws.tags.SeccionTags;

public class ForoParser extends Parser {

    public ForoParser() {
        super(ForoTags.CLASS_TAG);
        relaciones.put(SeccionParser.class.toString(), "secciones");
        relaciones.put(ForoParser.class.toString(), "foros");
    }

    @Override
    public Long getId() {
        return Long.parseLong(this.campos.get(ForoTags.ID_TAG));
    }

    @Override
    protected Boolean validateJoinParser(Parser parser) {
        return (parser instanceof SeccionParser);
    }

    @Override
    public Object getDBObject(String xml) {
        Foro foro = (Foro) getEntidadNegocio(xml);
        ar.fiuba.redsocedu.datalayer.ws.Foro foroDB = new ar.fiuba.redsocedu.datalayer.ws.Foro();
        foroDB.setForoId(foro.getId());
        foroDB.setNombre(foro.getNombre());
        //		foroDB.setAmbitoId(foro.getIdAmbito());
        return foroDB;
    }
    
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(SeccionTags.CLASS_TAG, "com.ws.pojos."
				+ SeccionTags.CLASS_TAG);
		return xml;
	}

}
