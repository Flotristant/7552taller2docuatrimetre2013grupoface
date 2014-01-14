package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Tema;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.TemaTags;

public class TemaSerializer extends Serializer {

	protected void setAttributeMappings(XStream xstream) {
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(TemaTags.CLASS_TAG, Tema.class);
		//Mapeos de los nombres de atributo
		xstream.aliasField(TemaTags.ID_TAG, Tema.class, "id");
		xstream.aliasField(TemaTags.AUTOR_TAG, Tema.class, "username");
		
		//TODO ver bien porque en bd no estan estos campos
		//xstream.aliasField(TemaTags.FECHA_TAG, Tema.class, "fecha");
		//xstream.aliasField(TemaTags.STICKY_TAG, Tema.class, "esSticky");
		
		xstream.aliasField(TemaTags.ID_SUBFORO_TAG, Tema.class, "subforoId");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
	}
}
