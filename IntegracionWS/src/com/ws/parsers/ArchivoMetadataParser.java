package com.ws.parsers;

import ar.fiuba.redsocedu.datalayer.ws.Recurso;

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
	
	public Object getDBArchivoObjectFromBusinessXML(String xml, byte [] datos, Recurso recurso){
		ArchivoMetadata archivo = (ArchivoMetadata) getEntidadNegocio(xml);
		archivo.setContenido(datos);
		archivo.setRecurso(recurso);
		return archivo.getDatabaseEntity();
	}
	
	public String getXmlRecursoId(String xml){
		//ArchivoMetadata archivo = (ArchivoMetadata) getEntidadNegocio(xml);
		//return "<?xml version=\"1.0\"?><WS><Recurso><id>"+archivo.getRecursoId()+"</id></Recurso></WS>";
		String xmlLala = "<?xml version=\"1.0\"?><WS><Recurso><id>1013</id></Recurso></WS>"; 
		return xmlLala;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
