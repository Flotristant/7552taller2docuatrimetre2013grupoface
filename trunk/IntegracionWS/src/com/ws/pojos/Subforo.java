package com.ws.pojos;

public class Subforo {

	protected Long idForo;
	protected Long idSubforoPadre;
	protected Long idSeccion; 
	protected String nombre;
	protected Long idSubforo;
	
	public Long getIdForo() {
		return idForo;
	}
	public void setIdForo(Long idForo) {
		this.idForo = idForo;
	}
	public Long getIdSubforoPadre() {
		return idSubforoPadre;
	}
	public void setIdSubforoPadre(Long idSubforoPadre) {
		this.idSubforoPadre = idSubforoPadre;
	}
	public Long getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdSubforo() {
		return idSubforo;
	}
	public void setIdSubforo(Long idSubforo) {
		this.idSubforo = idSubforo;
	}
	
}
