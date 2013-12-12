package com.ws.pojos;

import java.util.ArrayList;
import java.util.List;


public class Chat extends Pojo {

	Long idChat;
	Long idAmbito;
	List<Long> mensajesChat = new ArrayList<Long>();
	List<Long> miembrosChat = new ArrayList<Long>();
	
	public List<Long> getMensajesChat() {
		return mensajesChat;
	}
	public void setMensajesChat(List<Long> mensajeChat) {
		mensajesChat = mensajeChat;
	}
	public List<Long> getMiembrosChat() {
		return miembrosChat;
	}
	public void setMiembrosChat(List<Long> miembroChat) {
		miembrosChat = miembroChat;
	}
	
	public Long getIdChat() {
		return idChat;
	}
	public void setIdChat(Long idChat) {
		this.idChat = idChat;
	}
	public Long getIdAmbito() {
		return idAmbito;
	}
	public void setIdAmbito(Long idAmbito) {
		this.idAmbito = idAmbito;
	}
	
	
	
}
