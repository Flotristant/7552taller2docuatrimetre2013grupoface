package com.ws.parsers;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.db.querys.QueryBuilder;

public abstract class Parser {
	
	private static String JOIN_TAG = "join";
	private static String SELECT_TAG = "select";
	protected Map<String, String> campos;
	protected String classTag;
	Document doc;
	
	QueryBuilder queryBuilder;
	
	public Parser(String classTag) {
		this.classTag = classTag;
		this.campos = new HashMap<String, String>();
	}
	
	public abstract Object getEntidad();
	
	protected Map<String, String> inicializarCampos() {
		if (doc != null) {
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
	
	public String getClassTag() {
		return classTag;
	}

	public void setClassTag(String classTag) {
		this.classTag = classTag;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

}
