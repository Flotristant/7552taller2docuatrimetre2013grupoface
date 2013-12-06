package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Mensaje;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.MensajeTags;

public class MensajeSerializer extends Serializer {
	
	protected void setAttributeMappings(XStream xstream) {
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(MensajeTags.CLASS_TAG, Mensaje.class);
		//Mapeos de los nombres de atributo
		xstream.aliasField(MensajeTags.ID_TAG, Mensaje.class, "id");
		xstream.aliasField(MensajeTags.AUTOR_TAG, Mensaje.class, "nombre");
		xstream.aliasField(MensajeTags.CONTENIDO_TAG, Mensaje.class, "contenido");
		xstream.aliasField(MensajeTags.FECHA_TAG, Mensaje.class, "fecha");
	}

}
