package com.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

import com.utils.NotificacionFactory;
import com.utils.XmlGregorianConverter;
import com.ws.handler.Handler;
import com.ws.serializers.NotificacionSerializer;

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
	
		String s="12-10-1988";
		XMLGregorianCalendar result = null;
		Date date;
		SimpleDateFormat simpleDateFormat;
		GregorianCalendar gregorianCalendar;

		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss");
        try {
			date = simpleDateFormat.parse(s);
			gregorianCalendar = 
		    (GregorianCalendar)GregorianCalendar.getInstance();
		    gregorianCalendar.setTime(date);
		    result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        
		
		
		
		XMLGregorianCalendar xml = XmlGregorianConverter.string2XMLGregorian("12-10-1983");
		System.out.println(xml.toXMLFormat());
		
	}
	
	
	@Test
	public void test3() {
		
        String regex= "^Actividad";
		Pattern patron = Pattern.compile(regex);
		Matcher mt = patron.matcher("Actvidadgrupal");
		System.out.println(mt.find());
		
	}

}
