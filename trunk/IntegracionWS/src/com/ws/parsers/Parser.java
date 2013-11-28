package com.ws.parsers;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.db.querys.QueryBuilder;
import com.ws.tags.UsuarioTags;

public abstract class Parser {
	
	private static String JOIN_TAG = "join";
	private static String SELECT_TAG = "select";
	protected Map<String, String> campos;
	protected String classTag;
	Document doc;
	QueryBuilder queryBuilder;
	
	
	public Parser(Document doc, String classTag) {
		this.doc = doc;
		this.campos = new HashMap<String, String>();
		this.classTag = classTag;
	}
	
	protected Map<String, String> inicializarCampos() {
		NodeList nodes = doc.getElementsByTagName(this.classTag);
		if (nodes != null) {
			NodeList childNodes = nodes.item(0).getChildNodes(); 
			this.campos = new HashMap<String, String>();
			
		    if (childNodes != null) {
		        for (int i = 0; i < childNodes.getLength(); i++) {
	        	   Element el = (Element) childNodes.item(i);
	        	   this.campos.put(el.getNodeName(), el.getTextContent());
		        }
		    }
		}
		return this.campos;
	}
	
	public Boolean esJoin() {
		NodeList joinNode = this.doc.getElementsByTagName(JOIN_TAG);
		return (joinNode != null && joinNode.getLength() > 0);
	}
	
	public Boolean esSelect() {
		NodeList joinNode = this.doc.getElementsByTagName(SELECT_TAG);
		return (joinNode != null && joinNode.getLength() > 0);		
	}
	
	public abstract Map<String, String> obtenerCampos(); 
}
