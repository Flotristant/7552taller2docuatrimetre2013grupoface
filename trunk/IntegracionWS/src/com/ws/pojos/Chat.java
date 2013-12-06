package com.ws.pojos;

import java.util.ArrayList;
import java.util.List;


public class Chat extends Pojo {

	Long idChat;
	Long idAmbito;
	List<Long> MensajeChat = new ArrayList<Long>();
	List<Long> MiembroChat = new ArrayList<Long>();
	
	public List<Long> getMensajeChat() {
		return MensajeChat;
	}
	public void setMensajeChat(List<Long> mensajeChat) {
		MensajeChat = mensajeChat;
	}
	public List<Long> getMiembroChat() {
		return MiembroChat;
	}
	public void setMiembroChat(List<Long> miembroChat) {
		MiembroChat = miembroChat;
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
