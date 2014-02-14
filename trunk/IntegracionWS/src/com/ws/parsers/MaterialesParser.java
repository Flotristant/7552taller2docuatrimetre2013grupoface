package com.ws.parsers;

import ar.fiuba.redsocedu.datalayer.ws.Recurso;

public abstract class MaterialesParser extends Parser {
	
	private static String encabezado = "<?xml version=\"1.0\"?><WS><Recurso><id>";

	private static String pie = "</id></Recurso></WS>";

	public MaterialesParser(String classTag) {
		super(classTag);
	}
	
	public static String getEncabezado() {
		return encabezado;
	}

	public static void setEncabezado(String encabezado) {
		MaterialesParser.encabezado = encabezado;
	}

	public static String getPie() {
		return pie;
	}

	public static void setPie(String pie) {
		MaterialesParser.pie = pie;
	}
	
	
	public com.ws.pojos.Recurso getRecursoNegocio(Recurso recursoDB){
		com.ws.pojos.Recurso recursoNegocio = new com.ws.pojos.Recurso();
		recursoNegocio.setAmbitoId(recursoDB.getAmbitoId());
		recursoNegocio.setDescripcion(recursoDB.getDescripcion());
		recursoNegocio.setId(recursoDB.getId());
		recursoNegocio.setTipo(recursoDB.getTipo());
		return recursoNegocio;
	}

	
	public abstract String getXmlRecursoId(String xml);
	
	public abstract Object getDBObjectFromBusinessXML(String xml, com.ws.pojos.Recurso recurso);

}
