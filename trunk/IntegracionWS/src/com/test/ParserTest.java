package com.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ar.fiuba.redsocedu.datalayer.ws.Usuario;
import org.w3c.dom.Document;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.UsuarioPojoSerializer;
import com.ws.serializers.UsuarioSerializer;

public class ParserTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testParserVsXstream(){
		
		
		Usuario miusuario = new Usuario();
		
		miusuario.setActivado(true);
		miusuario.setApellido("Perez");
		miusuario.setNombre("Alfonso");
		miusuario.setEmail("ap@fiuba.edu.ar");
		miusuario.setPadron("999999");
		miusuario.setPassword("123456");
		miusuario.setHabilitado(true);
		
		XMLGregorianCalendar fecha = new XMLGregorianCalendarImpl();
		fecha.setYear(1986);
		fecha.setMonth(5);
		fecha.setDay(5);
		
		miusuario.setFechaNac(fecha);
		miusuario.setUsername("Pepe");
		miusuario.setUsuarioId(12L);
		
		Document doc = null;
		
		String xmlbruto = UsuarioSerializer.getXMLfromPojo(miusuario);
		
		//String xmlbruto = "<WS><Usuario><username>usuario prueba1</username><password>1234</password><activado>true</activado><habilitado>true</habilitado></Usuario></WS>";
		
		System.out.println(xmlbruto);
		
		try {
			doc = getXMLDocument(xmlbruto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
		UsuarioParser up = new UsuarioParser(doc);
		
		System.out.println(up.obtenerCampos());
		
		String salida = UsuarioPojoSerializer.getXMLfromPojo(up.getEntidadUsuario());
		
		System.out.println(salida);
		
		
		
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Document getXMLDocument(String xml) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
		return docBuilder.parse(new InputSource(new StringReader(xml)));
	}

}