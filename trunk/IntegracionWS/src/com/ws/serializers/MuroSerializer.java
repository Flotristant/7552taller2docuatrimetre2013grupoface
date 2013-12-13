package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Muro;
import com.thoughtworks.xstream.XStream;
import com.ws.tags.MuroTags;


//TODO  Cambiar la clase del POJO


public class MuroSerializer extends Serializer {
	
	protected void setAttributeMappings(XStream xstream) {
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(MuroTags.CLASS_TAG, Muro.class);
		//Mapeos de los nombres de atributo
		xstream.aliasField(MuroTags.ID_TAG, Muro.class, "id");
		xstream.aliasField(MuroTags.NOMBRE_TAG, Muro.class, "nombre");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
	}
	
}
