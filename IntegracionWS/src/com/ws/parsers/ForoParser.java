package com.ws.parsers;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.ws.pojos.Foro;
import com.ws.tags.ForoTags;

public class ForoParser extends Parser {

	private Map<String, String> campos;
	
	public ForoParser(Document doc) {
		super(doc);
		this.inicializarCampos();
	}
	
	private Map<String, String> inicializarCampos() {
		NodeList nodes = doc.getElementsByTagName(ForoTags.CLASS_TAG);
		NodeList childNodes = nodes.item(0).getChildNodes(); 
		this.campos = new HashMap<String, String>();
		
	    if (childNodes != null) {
	        for (int i = 0; i < childNodes.getLength(); i++) {
        	   Element el = (Element) childNodes.item(i);
        	   this.campos.put(el.getNodeName(), el.getTextContent());
	        }
	    }
		return campos;
	}

	@Override
	public Map<String, String> obtenerCampos() {
		
		return this.campos;
	}
	
	
	public Foro getEntidadForo(){
		Foro foro = new Foro();
		
		foro.setNombre(this.campos.get(ForoTags.NOMBRE_TAG));
		foro.setIdAmbito(Long.parseLong(this.campos.get(ForoTags.ID_AMBITO_TAG)));
		
		if(this.campos.get(ForoTags.ID_TAG) != null){
			foro.setIdForo(Long.parseLong(this.campos.get(ForoTags.ID_TAG)));
		}
		return foro;
	}
	
	
	public Long getIdForo(){
		
		return Long.parseLong(this.campos.get(ForoTags.ID_TAG));
	}
	

}
