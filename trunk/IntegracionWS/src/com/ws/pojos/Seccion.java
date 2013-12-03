package com.ws.pojos;

public class Seccion extends Pojo {
	
	Long idAmbito;
	Long idForo;
	String nombre;
	
	public Long getIdAmbito() {
		return idAmbito;
	}
	public void setIdAmbito(Long idAmbito) {
		this.idAmbito = idAmbito;
	}
	public Long getIdForo() {
		return idForo;
	}
	public void setIdForo(Long idForo) {
		this.idForo = idForo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
