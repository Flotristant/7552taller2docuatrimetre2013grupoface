package com.test;

import static org.junit.Assert.*;

import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

import com.utils.XmlGregorianConverter;
import com.ws.handler.Handler;

public class TestGenerico {

	@Test
	public void test() {
	
		try {
			//String handlerName = "com.ws.pojos.Usuario";
			String handlerName = "com.ws.handler.UsuarioHandlerMock";
			Class<?> hClass = Class.forName(handlerName);
			System.out.println(hClass.newInstance().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		
	}
	
	@Test
	public void test2() {
	
		XMLGregorianCalendar xml = XmlGregorianConverter.string2XMLGregorian("12-10-1983");
		System.out.println(xml.toXMLFormat());
		
	}

}
