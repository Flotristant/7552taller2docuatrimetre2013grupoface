package com.ws.services;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class IntegracionWS {
		
    public String guardarDatos() {
        String xml = "<WS><Actividad><IdAmbito>id</IdAmbito>    </Actividad>    </WS>";
        return xml;
    }
	
	public String seleccionarDatos(String xml) {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			
			return "ParserConfigurationException";
		}
		Element doc;
		try {
			doc = (Element) docBuilder.parse(new InputSource(new StringReader(xml)));
		} catch (SAXException e) {
			return "SAXException";
		} catch (IOException e) {
			return "IOException";
		} catch (Exception e) {
			return "Exception";
		}

        NodeList nodes = doc.getElementsByTagName("Usuario");
        return "<WS>Hola</WS>";
	}
}
