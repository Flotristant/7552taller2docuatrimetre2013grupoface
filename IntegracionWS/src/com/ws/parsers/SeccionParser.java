package com.ws.parsers;

import com.ws.pojos.Seccion;
import com.ws.tags.SeccionTags;

public class SeccionParser extends Parser {

    public SeccionParser() {
        super(SeccionTags.CLASS_TAG);
        relaciones.put(SubforoParser.class.toString(), "subforos");
    }

    @Override
    public Long getId() {
        return Long.parseLong(this.campos.get(SeccionTags.ID_TAG));
    }

    @Override
    public Object getDBObject(String xml) {
        Seccion seccion = (Seccion) getEntidadNegocio(xml);
        ar.fiuba.redsocedu.datalayer.ws.Seccion seccionDB = new ar.fiuba.redsocedu.datalayer.ws.Seccion();
        seccionDB.setId(seccion.getId());
        seccionDB.setNombre(seccion.getNombre());
        //		seccionDB.setForoId(seccion.getIdForo());

        return seccionDB;
    }

    @Override
    protected Boolean validateJoinParser(Parser parser) {
        return (parser instanceof SubforoParser);
    }
}
