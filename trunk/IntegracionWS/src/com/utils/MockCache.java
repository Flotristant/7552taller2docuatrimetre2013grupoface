package com.utils;


import java.util.HashMap;
import org.w3c.dom.Document;
import com.ws.parsers.UsuarioParser;
import com.ws.pojos.Usuario;
import com.ws.serializers.UsuarioPojoSerializer;

public class MockCache {

	private static HashMap<String, Usuario> cache = new HashMap<String, Usuario>();
	private static Long objects_count = 0L;
	
	public static Long guardarUsuario(String xml){
		Usuario us = getUsuarioFromString(xml);
		us.setId(++objects_count);
		cache.put(us.getUsername(), us);
		return objects_count;
	}
	
	public static String seleccionarUsuario(String xml){
		Usuario entrada = getUsuarioFromString(xml);
		Usuario salida = cache.get(entrada.getUsername());
		if (salida == null) return null;
		return UsuarioPojoSerializer.getXMLfromPojo(salida);
	}
	
	public static boolean borrarUsuario(String xml){
		Usuario entrada = getUsuarioFromString(xml);
		Usuario salida = cache.remove(entrada.getUsername());
		if (salida == null) return false;
		else return true;
	}
	
	private static Usuario getUsuarioFromString(String xml){
		try {
			UsuarioParser up = new UsuarioParser();
			Usuario us = (Usuario) up.getEntidadNegocio(xml);
			return us;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}