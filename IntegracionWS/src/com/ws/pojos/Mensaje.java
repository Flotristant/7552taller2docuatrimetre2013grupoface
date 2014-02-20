package com.ws.pojos;

public class Mensaje extends Pojo {
	
	String contenido;
	Long temaId;
	String username;
	
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

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Mensaje mensajeDB = new ar.fiuba.redsocedu.datalayer.ws.Mensaje();
		mensajeDB.setContenido(this.getContenido());
		mensajeDB.setId(this.getId());
		mensajeDB.setTemaId(this.getTemaId());
		mensajeDB.setUsername(this.getUsername());
//		mensajeDB.setMensajeId(this.getId());
		return mensajeDB;
	}
}
