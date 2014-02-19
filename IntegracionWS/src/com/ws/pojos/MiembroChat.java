package com.ws.pojos;

import java.util.List;

import ar.fiuba.redsocedu.datalayer.ws.Chat;

public class MiembroChat extends Pojo{
	
	String nombre;
	Boolean estado;
	List<MensajeChat> mensajesChat;
	
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
		if(this.mensajesChat != null) {
			for(MensajeChat mensaje : mensajesChat) {
				miembroChatDb.getMensajesChat().add((ar.fiuba.redsocedu.datalayer.ws.MensajeChat)mensaje.getDatabaseEntity());
			}
		}
		return miembroChatDb;
	}
	public List<MensajeChat> getMensajesChat() {
		return mensajesChat;
	}
	public void setMensajesChat(List<MensajeChat> mensajesChat) {
		this.mensajesChat = mensajesChat;
	}

}
