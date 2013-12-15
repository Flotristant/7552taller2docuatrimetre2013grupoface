package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Ambito;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.AmbitoTags;

public class AmbitoSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		xstream.alias(AmbitoTags.CLASS_TAG, Ambito.class);
		xstream.aliasField(AmbitoTags.ID_TAG, Ambito.class, "ambitoId");
	}

}
