package com.ws.serializers;

import com.thoughtworks.xstream.XStream;
import com.ws.pojos.Seccion;
import com.ws.tags.SeccionTags;

public class SeccionSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.alias(SeccionTags.CLASS_TAG, Seccion.class);
		xstream.aliasField(SeccionTags.ID_TAG, Seccion.class, "id");
		xstream.aliasField(SeccionTags.ID_FORO_TAG, Seccion.class, "idForo");
		xstream.aliasField(SeccionTags.NOMBRE_TAG, Seccion.class, "nombre");
	}

}
