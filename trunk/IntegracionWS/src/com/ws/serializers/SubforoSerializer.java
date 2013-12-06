package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Subforo;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.SubforoTags;

public class SubforoSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.alias(SubforoTags.CLASS_TAG, Subforo.class);
		xstream.aliasField(SubforoTags.ID_TAG, Subforo.class, "id");
		xstream.aliasField(SubforoTags.NOMBRE_TAG, Subforo.class, "nombre");
		xstream.aliasField(SubforoTags.ID_FORO_TAG, Subforo.class, "idForo");
		xstream.aliasField(SubforoTags.ID_SUBFOROPADRE_TAG, Subforo.class, "idSubforoPadre");
		xstream.aliasField(SubforoTags.ID_SECCION_TAG, Subforo.class, "idSeccion");
		
		
		
		
		
	}

}
