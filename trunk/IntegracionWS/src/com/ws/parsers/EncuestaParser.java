package com.ws.parsers;

import com.ws.pojos.Encuesta;
import com.ws.pojos.Recurso;
import com.ws.tags.EncuestaTags;

public class EncuestaParser extends MaterialesParser {

	public EncuestaParser() {
		super(EncuestaTags.CLASS_TAG);
	}

	@Override
	public String getXmlRecursoId(String xml) {
		Encuesta encuesta = (Encuesta) getEntidadNegocio(xml);
		return MaterialesParser.getEncabezado().toString()+encuesta.getRecursoId().toString()+MaterialesParser.getPie().toString();
	
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Encuesta encuesta = (Encuesta) getEntidadNegocio(xml);
		return encuesta.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml, Recurso recurso) {
		Encuesta encuesta = (Encuesta) getEntidadNegocio(xml);
		encuesta.setRecurso(recurso);
		return encuesta.getDatabaseEntity();
	}

}
