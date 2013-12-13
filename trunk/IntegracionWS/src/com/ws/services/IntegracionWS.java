package com.ws.services;

import java.io.FileOutputStream;
import java.io.OutputStream;

import com.ws.handler.ArchivoHandler;
import com.ws.handler.Handler;
import com.ws.handler.HandlerFactory;

public class IntegracionWS {
		
	private static String HANDLER_SUFIX = "Handler";
	private static String XML_ROOT_TAG = "WS"; 

    public String guardarDatos(String xml) {
		try {
			Handler handler = HandlerFactory.getHandler(XML_ROOT_TAG, xml);
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
		try {
			Handler handler = HandlerFactory.getHandler(XML_ROOT_TAG, xml);
			return handler.actualizarDatos(xml);
			
		} catch (Exception e) {
			return e.getMessage() + "XML: " + xml;
		}
    }
	
	public String seleccionarDatos(String xml) {
		try {
			Handler handler = HandlerFactory.getHandler(XML_ROOT_TAG, xml);
			return handler.seleccionarDatos(xml);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage() + "XML: " + xml;
		}
	}
	

	public String eliminarDatos(String xml) {
		try {
			Handler handler = HandlerFactory.getHandler(XML_ROOT_TAG, xml);
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
		
	
}
