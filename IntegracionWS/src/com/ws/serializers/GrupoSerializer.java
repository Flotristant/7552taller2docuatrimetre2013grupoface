package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Grupo;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.GrupoTags;


public class GrupoSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.alias(GrupoTags.CLASS_TAG, Grupo.class);
		xstream.omitField(Grupo.class, "notas");
		xstream.aliasField(GrupoTags.ID_ACTIVIDAD_TAG, Grupo.class, "actividadId");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
	}

}
