package com.ws.pojos;

public class Noticia extends Pojo {

	String titulo;
	String autor;
	String contenido;
	Long CarteleraId;
	
	public Long getCarteleraId() {
		return CarteleraId;
	}
	public void setCarteleraId(Long carteleraId) {
		CarteleraId = carteleraId;
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
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String Contenido) {
		contenido = Contenido;
	}
	@Override
	public Object getDatabaseEntity() {
ar.fiuba.redsocedu.datalayer.ws.Noticia miNoticiaDB = new ar.fiuba.redsocedu.datalayer.ws.Noticia();
		
		miNoticiaDB.setNoticiaId(this.getId());
		miNoticiaDB.setId(this.getId());
		miNoticiaDB.setContenido(this.getContenido());
		miNoticiaDB.setCarteleraId(this.getCarteleraId());
		miNoticiaDB.setTitulo(this.getTitulo());
		miNoticiaDB.setUsername(this.getAutor());	
		
		return miNoticiaDB;
	}
	
	
	
	
}
