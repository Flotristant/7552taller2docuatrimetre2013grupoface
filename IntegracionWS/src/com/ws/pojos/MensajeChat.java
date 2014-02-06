package com.ws.pojos;

import java.util.Date;

public class MensajeChat extends Pojo {
	
	Date fecha;
	String contenido;
	Long idChat;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Long getIdChat() {
		return idChat;
	}
	public void setIdChat(Long idChat) {
		this.idChat = idChat;
	}
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.MensajeChat mensajeChatDb = new ar.fiuba.redsocedu.datalayer.ws.MensajeChat();
		mensajeChatDb.setContenido(this.getContenido());
		mensajeChatDb.setId(this.getId());
		mensajeChatDb.setMensajeChatId(this.getIdChat());
		//mensajeChatDb.setFecha(this.getFecha());
		return mensajeChatDb;
	}
}