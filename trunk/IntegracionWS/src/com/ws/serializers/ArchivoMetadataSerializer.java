package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Archivo;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.ArchivoMetadataTags;
public class ArchivoMetadataSerializer extends Serializer{

	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(ArchivoMetadataTags.CLASS_TAG, Archivo.class);
		xstream.aliasField(ArchivoMetadataTags.ID_TAG,Archivo.class,"id");
		xstream.aliasField(ArchivoMetadataTags.NOMBRE_TAG,Archivo.class,"nombre");
		xstream.aliasField(ArchivoMetadataTags.TAMANIO_TAG,Archivo.class,"tamanio");
		xstream.aliasField(ArchivoMetadataTags.TIPO_TAG,Archivo.class,"tipo");
		xstream.aliasField(ArchivoMetadataTags.ID_RECURSO_TAG,Archivo.class,"recursoId");
		xstream.omitField(Archivo.class, "recurso");
		xstream.omitField(Archivo.class, "contenido");
		
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
		
		
	}

}
