package com.ws.pojos;

public class Foro extends Pojo {
	
	String nombre;
	Long idAmbito;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Long getIdAmbito(){
		return idAmbito;
	}
	
	public void setIdAmbito(Long idAmbito){
		this.idAmbito = idAmbito;
	}

}
