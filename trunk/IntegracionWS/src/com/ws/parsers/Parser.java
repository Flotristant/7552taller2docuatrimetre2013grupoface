package com.ws.parsers;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.db.querys.QueryBuilder;
import com.thoughtworks.xstream.XStream;
import com.ws.pojos.Nota;

public abstract class Parser {

	private static final String PARSER_PACKAGE = "com.ws.parsers.";

	private static final String PARSER_SUFIX = "Parser";

	public static String JOIN_TAG = "join";
	
	public static String ID_TAG = "id";

	protected Map<String, Object> campos;

	protected String classTag;

	protected Map<String, String> relaciones_directas;
	

	QueryBuilder queryBuilder;

	public Parser(String classTag) {
		this.classTag = classTag;
		this.campos = new HashMap<String, Object>();
		//directas: contiene una lista del otro en BD.
		relaciones_directas = new HashMap<String, String>();
	}
	
	

	public ar.fiuba.redsocedu.datalayer.ws.Nota getDBObjectFromBussinessObject(
			Nota notaNegocio) {
		return null;
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
		xml = xml.replace("<" + this.classTag + ">", "<com.ws.pojos."
				+ this.classTag + ">");
		xml = xml.replace("</" + this.classTag + ">", "</com.ws.pojos."
				+ this.classTag + ">");
		return xml;
	}

	private String removeSuperTags(String xml) {
		xml = xml.replace("<WS>", "");
		xml = xml.replace("</WS>", "");
		return xml;
	}
	
	public String createXmlResponse(String data) {
		return "<?xml version=\"1.0\"?><WS>" + data + "</WS>";
	}

	
	public Long getId() {
		return (Long)this.campos.get(ID_TAG);
	}

	public abstract Object getDBObjectFromBusinessXML(String xml);

	/**
	 * Este metodo inicializa el map "campos" para poder armar la query a la
	 * base de datos.
	 * 
	 * @param xml
	 *            : tiene que ser el xml recibido desde la capa de negocio.
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */

	public Map<String, Object>  inicializarCampos(String xml) {
		String xmlSinJoin = cleanJoinPart(xml);
		Object obj = this.getDBObjectFromBusinessXML(xmlSinJoin); //this.getEntidadNegocio(xmlSinJoin);
		Field[] fields = obj.getClass().getDeclaredFields();
		ArrayList<Field> fieldsList = new ArrayList<Field>();
		for (Field field : fields) {
			fieldsList.add(field);
		}

		Field[] superFields = obj.getClass().getSuperclass()
				.getDeclaredFields();
		for (Field field : superFields) {
			fieldsList.add(field);
		}

		Object ret=null;
		String attribute;
		for (Field field : fieldsList) {
			attribute = field.getName().substring(0, 1).toUpperCase()
					+ field.getName().substring(1);
			try {
				Method method = obj.getClass().getMethod("get" + attribute);
				ret = method.invoke(obj, null);
			} catch (Exception e) {
				try {
					Method method = obj.getClass().getMethod("is" + attribute);
					ret = method.invoke(obj, null);
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(ret instanceof List) {
				List<?> list = (List<?>) ret;
				if(list.isEmpty()) {
					ret=null;
				}
			}
			if (ret != null) {
				attribute = field.getName();
				this.campos.put(attribute, ret);
			}
		}
		String joinXML = getJoinXML(xml);
		if (!joinXML.isEmpty()) {
			this.campos.put(Parser.JOIN_TAG, getJoinXML(xml));
		}
		return this.campos;
	}

	public static String cleanJoinPart(String xml) {
		String substring = getJoinXML(xml);
		if (substring.isEmpty()) {
			return xml;
		}
		return xml.replace(substring, "");
	}

	private static String getJoinXML(String xml) {
		int first_index = xml.indexOf("<" + Parser.JOIN_TAG + ">");
		String close_tag = "</" + Parser.JOIN_TAG + ">";
		int last_index = xml.indexOf(close_tag);
		String substring = "";
		if (first_index > 0 && last_index > 0) {
			substring = xml.substring(first_index,
					last_index + close_tag.length());
		}
		return substring;
	}

	/**
	 * Utiliza la parte del xml que indica el join para crear un nuevo parser y
	 * obtener los campos involucrados en el join.
	 * 
	 * @return
	 */
	public Map<String, Object> getJoinFields() {
		String joinXML = (String)this.campos.get(Parser.JOIN_TAG);
		Map<String, Object> joinFields = new HashMap<String, Object>();
		Parser parser = getJoinParser(joinXML);
		if (parser == null)
			return joinFields;
		joinXML = cleanJoinTags(joinXML);
		parser.inicializarCampos(joinXML);
		Map<String, Object> camposRelacion = parser.getCampos();
		return camposRelacion;
	}

	public static String cleanJoinTags(String joinXML) {
		joinXML = joinXML.replace("<join>", "");
		joinXML = joinXML.replace("</join>", "");
		return joinXML;
	}

	public String getNombreRelacionDirecta(String nombreParserRelacion) {
		return relaciones_directas.get(nombreParserRelacion);
		//return relaciones_directas.get(this.getClass().toString());
	}

	public Object getRelationList() {
		//String nombre_relacion = this.getNombreRelacionDirecta();
		// FIXME obtener la lista con el nombre de la relacion
		return null;
	}

	private Parser getJoinParser(String joinXML) {
		Parser parser = getParserFromJoinXML(joinXML);
//		if (validateJoinParser(parser)) {
			return parser;
//		}
//		return null;
	}

	protected abstract Boolean validateJoinParser(Parser parser);

	public Map<String, Object> getCampos() {
		return this.campos;
	}

	public Boolean esJoin() {
		return this.campos.containsKey(JOIN_TAG);
	}

	public String getClassTag() {
		return classTag;
	}

	public void setClassTag(String classTag) {
		this.classTag = classTag;
	}

	public Parser getParserFromJoinXML(String xml) {
		Document doc;
		Parser parser = null;
		try {
			doc = getXMLDocument(xml);
			NodeList root = doc.getElementsByTagName(Parser.JOIN_TAG);
			parser = getParser(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parser;
	}

	public Document getXMLDocument(String xml) throws SAXException,
			IOException, ParserConfigurationException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
		return docBuilder.parse(new InputSource(new StringReader(xml)));
	}

	private Parser getParser(NodeList root) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		String objectName = root.item(0).getFirstChild().getNodeName();
		String handlerName = PARSER_PACKAGE + objectName + PARSER_SUFIX;
		Class<?> hClass = Class.forName(handlerName);
		return (Parser) hClass.newInstance();
	}
	
	public Boolean isRelacionDirecta(String nombreClaseCompletaParser) {
		return this.relaciones_directas.containsKey(nombreClaseCompletaParser);
	}
	
}
