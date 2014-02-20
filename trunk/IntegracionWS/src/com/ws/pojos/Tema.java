package com.ws.pojos;

import java.util.List;

public class Tema extends Pojo {
	
	String titulo;
	String autor;
	Boolean esSticky;
	String fecha;
	Long idSubforo;
	List<Mensaje> mensajes;
	
	public Long getIdSubforo() {
		return idSubforo;
	}
	public void setIdSubforo(Long idSubforo) {
		this.idSubforo = idSubforo;
	}
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
	public List<Mensaje> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Tema temaDB = new ar.fiuba.redsocedu.datalayer.ws.Tema();
		temaDB.setId(this.getId());
		temaDB.setSubforoId(this.getIdSubforo());
		temaDB.setUsername(this.getAutor());
		if(mensajes != null) {
			for(Mensaje mens : mensajes) {
				temaDB.getMensajes().add((ar.fiuba.redsocedu.datalayer.ws.Mensaje) mens.getDatabaseEntity());
			}
		}
		return temaDB;
	}
}
