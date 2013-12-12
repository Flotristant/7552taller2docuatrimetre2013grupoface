package com.ws.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.ws.handler.ArchivoHandler;
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
			e.printStackTrace();
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
	
	
	public String guardarArchivo(String xml , byte [] archivo){
		
		if (HANDLER_SUFIX.equalsIgnoreCase("HandlerMock")){
			//prueba se ivocacion al web service guardar archivo
			   String correcto ="Incorrecto";
				try { 
			     OutputStream out = new FileOutputStream(xml); 
			     out.write(archivo); 
			     out.close();         
			     correcto = "Correcto"; 
			   } catch (Exception e) { 
			     e.printStackTrace(); 
			   }         
			     return correcto;
		}else{
		
			try {
				ArchivoHandler hand = new ArchivoHandler();
				return hand.guardarDatos(xml, archivo);
			} catch (Exception e) {
				return e.getMessage() + "XML: " + xml;
			} 
		}
		
	}
	
	public String eliminarArchivo(String xml){
		if (HANDLER_SUFIX.equalsIgnoreCase("HandlerMock")){
			//prueba se ivocacion al web service eliminar archivo    
			     return "Eliminado";
		}else{
			try {
				ArchivoHandler hand = new ArchivoHandler();
				return hand.borrarDatos(xml);
			} catch (Exception e) {
				return e.getMessage() + "XML: " + xml;
			}    
		}
	}
	
	public String actualizarArchivo (String xml, byte [] archivo) {
		
		if (HANDLER_SUFIX.equalsIgnoreCase("HandlerMock")){
			//prueba se ivocacion al web service eliminar archivo    
			     return "Actualizado";
		}else{
			try {
				ArchivoHandler hand = new ArchivoHandler();
				return hand.actualizarDatos(xml, archivo);
			} catch (Exception e) {
				return e.getMessage() + "XML: " + xml;
			}    
		}
		
	}
	

	
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
