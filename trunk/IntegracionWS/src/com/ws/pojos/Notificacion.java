package com.ws.pojos;

/**
 * 
 * numero: 
 * 	0 Operacion no permitida 
 * 	1 Error al realizar la operacion
 *  2 Operacion correcta
 *  3 Sin resultados
 * @author zeke
 *
 */
public class Notificacion extends Pojo {

	int numero;
	String mensaje;
	String datos;
	
	public String getDatos() {
		return datos;
	}
	public void setDatos(String datos) {
		this.datos = datos;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Notificacion(int numero, String mensaje) {
		super();
		this.numero = numero;
		this.mensaje = mensaje;
	}
	@Override
	public Object getDatabaseEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
