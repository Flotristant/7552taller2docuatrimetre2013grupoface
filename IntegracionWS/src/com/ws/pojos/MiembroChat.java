package com.ws.pojos;

import java.util.List;

import ar.fiuba.redsocedu.datalayer.ws.Chat;

public class MiembroChat extends Pojo{
	
	String nombre;
	Boolean estado;
	List<Chat> chats;
	
	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.MiembroChat miembroChatDb = new ar.fiuba.redsocedu.datalayer.ws.MiembroChat();
		miembroChatDb.setNombre(this.getNombre());
		miembroChatDb.setId(this.getId());
		if(this.getEstado() != null ) {
			miembroChatDb.setEstado(this.getEstado());	
		}
		return miembroChatDb;
	}

}
