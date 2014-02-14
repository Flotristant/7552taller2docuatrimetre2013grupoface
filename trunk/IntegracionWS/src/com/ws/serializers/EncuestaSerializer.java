package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Encuesta;
import com.thoughtworks.xstream.XStream;
import com.ws.tags.EncuestaTags;

public class EncuestaSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(EncuestaTags.CLASS_TAG, Encuesta.class);
		xstream.aliasField(EncuestaTags.ID_TAG,Encuesta.class,"id");
		xstream.aliasField(EncuestaTags.EVALUADA_TAG,Encuesta.class,"evaluada");
		xstream.aliasField(EncuestaTags.PREGUNTAS_TAG,Encuesta.class,"preguntas");
		xstream.aliasField(EncuestaTags.RECURSO_ID_TAG,Encuesta.class,"recursoId");
		xstream.omitField(Encuesta.class, "recurso");
		
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		
		
	}

}
