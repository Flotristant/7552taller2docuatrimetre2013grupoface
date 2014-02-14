package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Link;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.LinkTags;

public class LinkSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		//El nombre de la clase (atributo raiz) sera
		
		xstream.alias(LinkTags.CLASS_TAG, Link.class);
		xstream.aliasField(LinkTags.ID_TAG,Link.class,"id");
		xstream.aliasField(LinkTags.ID_RECURSO_TAG,Link.class,"recursoId");
		xstream.aliasField(LinkTags.NOMBRE_TAG,Link.class,"nombre");
		xstream.omitField(Link.class, "recurso");
		
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		
	}

}
