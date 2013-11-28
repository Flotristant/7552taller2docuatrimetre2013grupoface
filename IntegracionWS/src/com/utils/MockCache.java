package com.utils;


import java.util.HashMap;
import org.w3c.dom.Document;
import com.ws.parsers.UsuarioParser;
import com.ws.pojos.Usuario;
import com.ws.serializers.UsuarioPojoSerializer;

public class MockCache {

	private static HashMap<String, Usuario> cache = new HashMap<String, Usuario>();
	
	
	public static void guardarUsuario(Document doc){
		Usuario us = getUsuarioFromString(doc);
		cache.put(us.getUsername(), us);
	}
	
	public static String seleccionarUsuario(Document doc){
		
		Usuario entrada = getUsuarioFromString(doc);
		Usuario salida = cache.get(entrada.getUsername());
		
		if (salida == null) return null;
		
		return UsuarioPojoSerializer.getXMLfromPojo(salida);
		
	}
	
	public static boolean borrarUsuario(Document doc){
		
		Usuario entrada = getUsuarioFromString(doc);
		
		Usuario salida = cache.remove(entrada.getUsername());
		
		if (salida == null) return false;
		else return true;
		
		
	}
	
	private static Usuario getUsuarioFromString(Document doc){
		
		
		try {
			UsuarioParser up = new UsuarioParser();
			up.inicializarDocumento(doc);
			Usuario us = (Usuario) up.getEntidad();
			return us;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
