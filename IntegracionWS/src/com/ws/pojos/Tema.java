package com.ws.pojos;

public class Tema extends Pojo {
	String titulo;
	String autor;
	Boolean esSticky;
	String fecha;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Boolean getEsSticky() {
		return esSticky;
	}
	public void setEsSticky(Boolean esSticky) {
		this.esSticky = esSticky;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
