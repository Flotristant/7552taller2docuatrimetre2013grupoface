package com.ws.parsers;

import com.ws.pojos.Link;
import com.ws.pojos.Recurso;
import com.ws.tags.LinkTags;

public class LinkParser extends MaterialesParser{
	
	public LinkParser(){
		super(LinkTags.CLASS_TAG);
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Link link = (Link) getEntidadNegocio(xml);
		return link.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getXmlRecursoId(String xml) {
		Link link = (Link) getEntidadNegocio(xml);
		return MaterialesParser.getEncabezado().toString()+link.getRecursoId().toString()+MaterialesParser.getPie().toString();
	
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml, Recurso recurso) {
		Link link = (Link) getEntidadNegocio(xml);
		link.setRecurso(recurso);
		return link.getDatabaseEntity();
	}

}
