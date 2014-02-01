package com.utils;

import com.ws.pojos.Notificacion;

public class NotificacionFactory {

	public static Notificacion sinResultados(){
		return new Notificacion(3, "La consulta no produjo resultados");
	}
	
	public static Notificacion errorParseoXML(){
		return new Notificacion(4, "La consulta no puede ser parseada, verifique el formato del xml");
	}
	
	public static Notificacion Error(){
		return new Notificacion(1, "Hubo un error al realizar la operacion solicitada");
	}
	
	public static Notificacion Exito(){
		return new Notificacion(2, "Su solicitud fue procesada con exito");
	}
	
	public static Notificacion ExitoGuardado(String nuevoId){
		Notificacion not =  new Notificacion(2, "La entidad ha sido almacenada con exito");
		not.setDatos(nuevoId);
		return not;
	}
	
	public static Notificacion OperacionInvalida(){
		return new Notificacion(0, "La operacion que trata de realizar es invalida");
	}
	
}
