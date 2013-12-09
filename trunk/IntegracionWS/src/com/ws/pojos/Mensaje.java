package com.ws.pojos;

public class Mensaje extends Pojo {
	
	String contenido;
	//String autor;
	//String fecha;
	Long temaId;
	Tema tema;

	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Long getTemaId() {
		return temaId;
	}
	public void setTemaId(Long temaId) {
		this.temaId = temaId;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
//	public String getAutor() {
//		return autor;
//	}
//	public void setAutor(String autor) {
//		this.autor = autor;
//	}
//	public String getFecha() {
//		return fecha;
//	}
//	public void setFecha(String fecha) {
//		this.fecha = fecha;
//	}
}
