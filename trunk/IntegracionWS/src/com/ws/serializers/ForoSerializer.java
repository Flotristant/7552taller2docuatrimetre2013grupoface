package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Foro;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.ForoTags;

public class ForoSerializer extends Serializer{

	@Override
	protected void setAttributeMappings(XStream xstream) {
		xstream.alias(ForoTags.CLASS_TAG, Foro.class);
		xstream.aliasField(ForoTags.ID_TAG, Foro.class, "id");
		xstream.omitField(Foro.class, "idForo");
		xstream.aliasField(ForoTags.NOMBRE_TAG, Foro.class, "nombre");
		xstream.aliasField(ForoTags.ID_AMBITO_TAG, Foro.class, "idAmbito");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		
	}

}
