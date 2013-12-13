package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Noticia;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.NoticiaTags;

public class NoticiaSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		xstream.alias(NoticiaTags.CLASS_TAG, Noticia.class);
		xstream.aliasField(NoticiaTags.ID_TAG, Noticia.class, "id");
		xstream.omitField(Noticia.class, "noticiaId");
		
		xstream.aliasField(NoticiaTags.TITULO_TAG, Noticia.class, "titulo");
		//xstream.aliasField(NoticiaTags.AUTOR_TAG, Noticia.class, "username");   TODO el campo username o autor no existe todavia en el pojo de DB
		xstream.aliasField(NoticiaTags.CONTENIDO_TAG, Noticia.class, "contenido");
		xstream.aliasField(NoticiaTags.CARTELERAID_TAG, Noticia.class, "carteleraId");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		
		xstream.omitField(Noticia.class, "carteleraId");
		
		
	}
}
