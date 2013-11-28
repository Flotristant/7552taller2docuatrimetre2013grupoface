package com.ws.pojos;

public class Foro {
	
	Long id;
	String nombre;
	Long idAmbito;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
