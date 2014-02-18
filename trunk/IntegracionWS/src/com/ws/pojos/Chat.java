package com.ws.pojos;

import java.util.List;
import com.db.querys.DBManager;


public class Chat extends Pojo {

	Long idAmbito;
	List<MensajeChat> mensajesChat;// = new ArrayList<Long>();
	List<MiembroChat> miembrosChat;// = new ArrayList<MiembroChat>();
	
	public Chat() {
		this.mensajesChat=null;
		this.miembrosChat=null;
	}
	
	public List<MensajeChat> getMensajesChat() {
		return mensajesChat;
	}
	public void setMensajesChat(List<MensajeChat> mensajeChat) {
		mensajesChat = mensajeChat;
	}
	public List<MiembroChat> getMiembrosChat() {
		return miembrosChat;
	}
	public void setMiembrosChat(List<MiembroChat> miembroChat) {
		miembrosChat = miembroChat;
	}

	public Long getIdAmbito() {
		return idAmbito;
	}
	public void setIdAmbito(Long idAmbito) {
		this.idAmbito = idAmbito;
	}
	
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Chat chatDB = new ar.fiuba.redsocedu.datalayer.ws.Chat();
		chatDB.setId(this.getId());
		chatDB.setAmbitoId(this.getIdAmbito());

		// Administro las listas que puedo recibir del negocio
		// Agrego al Pojo de DB instancias de Mensajes con los id que recibo
		if(this.getMensajesChat() != null) {
			for (MensajeChat elem : this.getMensajesChat()) {
				ar.fiuba.redsocedu.datalayer.ws.MensajeChat unMensaje = (ar.fiuba.redsocedu.datalayer.ws.MensajeChat) elem.getDatabaseEntity();
				try {
	            	if(elem.getId() == null) {
	            		Long id = DBManager.guardarObjetos(unMensaje, "ar.fiuba.redsocedu.datalayer.dtos.MensajeChat");
	            		elem.setId(id);
	            	}
	            	unMensaje.setId(elem.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				chatDB.getMensajesChat().add(unMensaje);
			}
		} 

		// Agrego al Pojo de DB instancias de Miembros con los id que recibo
		if(this.getMiembrosChat() != null) {
			for (com.ws.pojos.MiembroChat miembroNeg : this.getMiembrosChat()) {
	        	ar.fiuba.redsocedu.datalayer.ws.MiembroChat miembro = (ar.fiuba.redsocedu.datalayer.ws.MiembroChat) miembroNeg.getDatabaseEntity();
	        	try {
	            	if(miembroNeg.getId() == null) {
	            		Long id = DBManager.guardarObjetos(miembro, "ar.fiuba.redsocedu.datalayer.dtos.MiembroChat");
	            		miembroNeg.setId(id);
	            	}
	            	miembro.setId(miembroNeg.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
	        	chatDB.getMiembrosChat().add(miembro);
			}
		}

		return chatDB;
	}
	
	
}
