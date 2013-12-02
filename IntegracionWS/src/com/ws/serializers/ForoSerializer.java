package com.ws.serializers;

import com.thoughtworks.xstream.XStream;
import com.ws.pojos.Foro;
import com.ws.tags.ForoTags;

public class ForoSerializer extends Serializer{

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.alias(ForoTags.CLASS_TAG, Foro.class);
		xstream.aliasField(ForoTags.ID_TAG, Foro.class, "idForo");
		xstream.aliasField(ForoTags.NOMBRE_TAG, Foro.class, "nombre");
		xstream.aliasField(ForoTags.ID_AMBITO_TAG, Foro.class, "idAmbito");
		
	}

}
