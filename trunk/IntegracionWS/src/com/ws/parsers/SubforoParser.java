package com.ws.parsers;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.ws.pojos.Subforo;
import com.ws.tags.SubforoTags;

public class SubforoParser extends Parser{

	private Map<String, String> campos;
	
	public SubforoParser(Document doc) {
		super(doc);
		this.inicializarCampos();
	}
	
	private Map<String, String> inicializarCampos() {
		NodeList nodes = doc.getElementsByTagName(SubforoTags.CLASS_TAG);
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
	
	
	public Subforo getEntidadSubforo(){
		
		Subforo subforo = new Subforo();
		
		subforo.setIdForo(Long.parseLong(this.campos.get(SubforoTags.ID_FORO_TAG)));
		
		if(this.campos.get(SubforoTags.ID_SUBFOROPADRE_TAG) != null){
			subforo.setIdSubforoPadre(Long.parseLong(this.campos.get(SubforoTags.ID_SUBFOROPADRE_TAG)));
		}
		
		if(this.campos.get(SubforoTags.ID_SECCION_TAG) != null){
			subforo.setIdSeccion(Long.parseLong(this.campos.get(SubforoTags.ID_SECCION_TAG)));
			
		}
		
		if(this.campos.get(SubforoTags.ID_TAG) != null){
			subforo.setIdSubforo(Long.parseLong(this.campos.get(SubforoTags.ID_TAG)));
		}
				
		subforo.setNombre(this.campos.get(SubforoTags.NOMBRE_TAG));
		
		return subforo;
		
	}
	
	public Long getIdSubforo(){
		return Long.parseLong(this.campos.get(SubforoTags.ID_TAG));
	}

}
