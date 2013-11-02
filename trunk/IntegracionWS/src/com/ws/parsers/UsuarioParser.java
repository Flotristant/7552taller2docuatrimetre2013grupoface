package com.ws.parsers;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.ws.tags.UsuarioTags;

public class UsuarioParser extends Parser {

	public UsuarioParser(Document doc) {
		super(doc);
	}

	@Override
	public Map<String, String> obtenerCampos() {
		NodeList nodes = doc.getElementsByTagName(UsuarioTags.CLASS_TAG);
		NodeList childNodes = nodes.item(0).getChildNodes(); 
		Map<String, String> campos = new HashMap<String, String>();
		
	    if (childNodes != null) {
	        for (int i = 0; i < childNodes.getLength(); i++) {
        	   Element el = (Element) childNodes.item(i);
        	   campos.put(el.getNodeName(), el.getNodeValue());
	        }
	    }
		return campos;
	}

}
