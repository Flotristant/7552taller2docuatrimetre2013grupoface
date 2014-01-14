package com.ws.parsers;

import com.ws.pojos.ArchivoMetadata;
import com.ws.tags.ArchivoMetadataTags;

public class ArchivoMetadataParser extends Parser {
	
	public ArchivoMetadataParser() {
		super(ArchivoMetadataTags.CLASS_TAG);
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		ArchivoMetadata archivo = (ArchivoMetadata) getEntidadNegocio(xml);
		return archivo.getDatabaseEntity();
	}
	
	public Object getDBArchivoObjectFromBusinessXML(String xml, byte [] datos){
		ArchivoMetadata archivo = (ArchivoMetadata) getEntidadNegocio(xml);
		archivo.setContenido(datos);
		return archivo.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
