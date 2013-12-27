package com.ws.pojos;

import java.util.ArrayList;
import java.util.List;

import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.DBManager;


public class Chat extends Pojo {

	Long idChat;
	Long idAmbito;
	List<Long> mensajesChat;// = new ArrayList<Long>();
	List<MiembroChat> miembrosChat;// = new ArrayList<MiembroChat>();
	
	public Chat() {
		this.mensajesChat=null;
		this.miembrosChat=null;
	}
	
	public List<Long> getMensajesChat() {
//		if(mensajesChat == null) {
//			mensajesChat = new ArrayList<Long>();
//		}
		return mensajesChat;
	}
	public void setMensajesChat(List<Long> mensajeChat) {
		mensajesChat = mensajeChat;
	}
	public List<MiembroChat> getMiembrosChat() {
//		if(miembrosChat == null) {
//			miembrosChat = new ArrayList<MiembroChat>();
//		}		
		return miembrosChat;
	}
	public void setMiembrosChat(List<MiembroChat> miembroChat) {
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
	
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Chat chatDB = new ar.fiuba.redsocedu.datalayer.ws.Chat();
		chatDB.setId(this.getId());
		chatDB.setAmbitoId(this.getIdAmbito());

		// Administro las listas que puedo recibir del negocio
		// Agrego al Pojo de DB instancias de Mensajes con los id que recibo
		if(this.getMensajesChat() != null) {
			for (Long elem : this.getMensajesChat()) {
				ar.fiuba.redsocedu.datalayer.ws.MensajeChat unMensaje = new ar.fiuba.redsocedu.datalayer.ws.MensajeChat();
				unMensaje.setMensajeChatId(elem);
				chatDB.getMensajesChat().add(unMensaje);
			}
		}

		// Agrego al Pojo de DB instancias de Miembros con los id que recibo
		if(this.getMiembrosChat() != null) {
			for (com.ws.pojos.MiembroChat miembroNeg : this.getMiembrosChat()) {
				List<ReturnedObject> objects = null;
				List<ar.fiuba.redsocedu.datalayer.ws.MiembroChat> miembrosChatDB = new ArrayList<ar.fiuba.redsocedu.datalayer.ws.MiembroChat>();
	        	ar.fiuba.redsocedu.datalayer.ws.MiembroChat miembro = new ar.fiuba.redsocedu.datalayer.ws.MiembroChat();
	        	miembro.setNombre(miembroNeg.getNombre());
	        	miembro.setEstado(miembro.isEstado());
	        	try {
	            	if(miembroNeg.getId() == null) {
	            		Long id = DBManager.guardarObjetos(miembroNeg, "ar.fiuba.redsocedu.datalayer.ws.MiembroChat");
	            		miembroNeg.setId(id);
	            	}
	            	miembro.setId(miembroNeg.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
	        	miembrosChatDB.add(miembro);
			}
		}

		return chatDB;
	}
	
	
}
