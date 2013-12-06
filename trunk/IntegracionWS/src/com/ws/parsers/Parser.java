package com.ws.parsers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;



import com.db.querys.QueryBuilder;
import com.thoughtworks.xstream.XStream;


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

	/**
	 * Obtiene la entidad de negocio representada por el xml utilizando XStream
	 */
	public Object getEntidadNegocio(String xml) {
		xml = removeSuperTags(xml);
		xml = replaceClassTag(xml);
		XStream xmlReader = new XStream();
		Object obj = xmlReader.fromXML(xml);
		return obj;
	}
	
	protected String replaceClassTag(String xml) {
		xml = xml.replace("<"+this.classTag+">", "<com.ws.pojos."+this.classTag+">");
		xml = xml.replace("</"+this.classTag+">", "</com.ws.pojos."+this.classTag+">");
		return xml;
	}
	
	private String removeSuperTags(String xml) {
		xml = xml.replace("<WS>", "");
		xml = xml.replace("</WS>", "");
		return xml;
	}

	public abstract Long getId();

	public abstract Object getDBObject(String xml);

	/**
	 * Este metodo inicializa el map "campos" para poder armar la query a la base de datos.
	 * @param xml : tiene que ser el xml recibido desde la capa de negocio.
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	//public abstract Map<String, String> inicializarCampos(String xml) ;

	public Map<String, String> inicializarCampos(String xml) {
		Object obj =  this.getEntidadNegocio(xml);
		Field[] fields = obj.getClass().getDeclaredFields();

		Object ret;
		String value, attribute;
		try {
			for(Field field: fields) {
				attribute = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
				Method method = obj.getClass().getMethod("get" + attribute);
				ret = method.invoke(obj, null);
				if(ret != null) {
					value = ret.toString();
					attribute = field.getName();
					this.campos.put(attribute, value.toString());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return this.campos;
	}
	

	public Map<String, String> getCampos() {
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

	public String getClassTag() {
		return classTag;
	}

	public void setClassTag(String classTag) {
		this.classTag = classTag;
	}

	public Document getDoc() {
		return doc;
	}

	@Deprecated
	public void inicializarDocumento(Document doc) {
		this.doc = doc;
		this.inicializarCampos("");	
	}
}
