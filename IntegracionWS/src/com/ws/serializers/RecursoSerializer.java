package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Recurso;
import com.thoughtworks.xstream.XStream;
import com.ws.tags.RecursoTags;

public class RecursoSerializer extends Serializer{

	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(RecursoTags.CLASS_TAG, Recurso.class);
		xstream.omitField(Recurso.class, "recursoId");
		xstream.aliasField(RecursoTags.ID_TAG,Recurso.class,"id");
		xstream.aliasField(RecursoTags.DESCRIPCION_TAG,Recurso.class,"descripcion");
		xstream.aliasField(RecursoTags.ID_AMBITO_TAG,Recurso.class,"ambitoId");
		xstream.aliasField(RecursoTags.TIPO_TAG,Recurso.class,"tipo");
		
		xstream.omitField(Recurso.class, "recursoId");
		
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		
	}

}
