package com.ws.services;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.ws.handler.Handler;

public class IntegracionWS {
		
	private static String HANDLER_PACKAGE = "com.ws.handler." ;
	private static String HANDLER_SUFIX = "Handler";
	private static String XML_ROOT_TAG = "WS"; 

    public String guardarDatos(String xml) {
    	Document doc;
		try {
			doc = getXMLDocument(xml);
			NodeList root = doc.getElementsByTagName(XML_ROOT_TAG);
			Handler handler = getHandler(root);
			return handler.guardarDatos(xml);
		} catch (Exception e) {
			return e.getMessage() + "XML: " + xml;
		}    
    }
    
    public static void setMockService(Boolean mock) {
    	if(mock) {
    		HANDLER_SUFIX="HandlerMock";
    	} else {
    		HANDLER_SUFIX="Handler";
    	}
    }
        
    public Boolean isMock() {
    	return (HANDLER_SUFIX=="HandlerMock");
    }
    
    public String actualizarDatos(String xml) {
    	Document doc;
		try {
			doc = getXMLDocument(xml);
			NodeList root = doc.getElementsByTagName(XML_ROOT_TAG);
			Handler handler = getHandler(root);
			return handler.actualizarDatos(xml);
			
		} catch (Exception e) {
			return e.getMessage() + "XML: " + xml;
		}
    }
	
	public String seleccionarDatos(String xml) {
		Document doc;
		try {
			System.out.println(xml);
			doc = getXMLDocument(xml);
			NodeList root = doc.getElementsByTagName(XML_ROOT_TAG);
			return getHandler(root).seleccionarDatos(xml);
		} catch (Exception e) {
			return e.getMessage() + "XML: " + xml;
		}
	}
	

	public String eliminarDatos(String xml) {
		Document doc;
		try {
			doc = getXMLDocument(xml);
			NodeList root = doc.getElementsByTagName(XML_ROOT_TAG);
			Handler handler = getHandler(root);
			//return the error or successfull message
			return handler.borrarDatos(xml);			
		} catch (Exception e) {
			return e.getMessage() + "XML: " + xml;
		}
	}
	
	//TODO: ver la forma de leer un xml con formato o de nunca obtener un xml con formato

	public Document getXMLDocument(String xml) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
		return docBuilder.parse(new InputSource(new StringReader(xml)));
	}
	
	
	private Handler getHandler(NodeList root) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String objectName = root.item(0).getFirstChild().getNodeName();
		String nameWithoutPackage = objectName.substring(objectName.lastIndexOf(".")+1);
		String handlerName = HANDLER_PACKAGE + nameWithoutPackage + HANDLER_SUFIX ;
		Class<?> hClass = Class.forName(handlerName);
		return (Handler) hClass.newInstance();
	}
		
	
}
