//////////////////////////////////////////////////////////////////////////////// 
// This file is the confidential property of Greenline Financial Technologies. 
// Possession, use, transmission, or disclosure of this file is prohibited 
// without express written authorization from Greenline Financial Technologies. 
// Copyright 2008 Greenline Financial Technologies. All rights reserved. 
//////////////////////////////////////////////////////////////////////////////// 
// $Id$ 

package com.ws.handler;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class HandlerFactory {
    private static String HANDLER_PACKAGE = "com.ws.handler.";

    private static String HANDLER_SUFIX = "Handler";

    public static Handler getHandler(String xml_root_tag, String xml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SAXException, IOException, ParserConfigurationException {
        Document doc = getXMLDocument(xml);
        NodeList root = doc.getElementsByTagName(xml_root_tag);
        return getHandler(root);
    }

    private static Document getXMLDocument(String xml) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        docBuilder = docFactory.newDocumentBuilder();
        return docBuilder.parse(new InputSource(new StringReader(xml)));
    }

    private static Handler getHandler(NodeList root) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String objectName = root.item(0).getFirstChild().getNodeName();
        String nameWithoutPackage = objectName.substring(objectName.lastIndexOf(".") + 1);
        String handlerName = HANDLER_PACKAGE + nameWithoutPackage + HANDLER_SUFIX;
        Class<?> hClass = Class.forName(handlerName);
        return (Handler) hClass.newInstance();
    }
}
