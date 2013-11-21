package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XmlGregorianConverter {

	public static XMLGregorianCalendar string2XMLGregorian(String fecha){
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");			
	        Date date = sdf.parse(fecha);
	        GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
	        gc.setTime(date);
	        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	    } catch (ParseException e) {
	        // Optimize exception handling
	        System.out.print(e.getMessage());
	        return null;
	    } catch (DatatypeConfigurationException e) {
	    	System.out.print(e.getMessage());
			e.printStackTrace();
			return null;
		} 
		
	}
	
	
	
}
