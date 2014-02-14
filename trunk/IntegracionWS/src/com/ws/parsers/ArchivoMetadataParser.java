package com.ws.parsers;


import com.ws.pojos.ArchivoMetadata;
import com.ws.pojos.Recurso;
import com.ws.tags.ArchivoMetadataTags;

public class ArchivoMetadataParser extends MaterialesParser {
	
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
	
	@Override
	public String getXmlRecursoId(String xml){
		ArchivoMetadata archivo = (ArchivoMetadata) getEntidadNegocio(xml);
		return MaterialesParser.getEncabezado().toString()+archivo.getRecursoId().toString()+MaterialesParser.getPie().toString();
	}
	
	
	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml, Recurso recursoDB) {
		// TODO Auto-generated method stub
		return null;
	}

}
