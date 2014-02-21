package com.ws.pojos;

import java.util.Date;

public class MensajeChat extends Pojo {
	
	Date fecha;
	String contenido;
	Long miembroChatId;
	Long chatId;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getMiembroChatId() {
		return miembroChatId;
	}
	public void setMiembroChatId(Long miembroChatId) {
		this.miembroChatId = miembroChatId;
	}
	public Long getIdChat() {
		return chatId;
	}
	public void setIdChat(Long idChat) {
		this.chatId = idChat;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.MensajeChat mensajeChatDb = new ar.fiuba.redsocedu.datalayer.ws.MensajeChat();
		mensajeChatDb.setContenido(this.getContenido());
		mensajeChatDb.setId(this.getId());
		mensajeChatDb.setMensajeChatId(this.getId());
		mensajeChatDb.setMiembroChatId(this.getMiembroChatId());
		mensajeChatDb.setChatId(this.getIdChat());
		//mensajeChatDb.setFecha(this.getFecha());
		return mensajeChatDb;
	}
}
