package com.ws.pojos;

import java.util.List;

public class Ambito extends Pojo {
	protected List<Cartelera> carteleras;
	protected List<Chat> chats;
	protected List<Foro> foros;
	protected List<Muro> muros;

	public List<Cartelera> getCarteleras() {
		return carteleras;
	}

	public void setCarteleras(List<Cartelera> carteleras) {
		this.carteleras = carteleras;
	}

	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	public List<Foro> getForos() {
		return foros;
	}

	public void setForos(List<Foro> foros) {
		this.foros = foros;
	}

	public List<Muro> getMuros() {
		return muros;
	}

	public void setMuros(List<Muro> muros) {
		this.muros = muros;
	}

	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Ambito ambitoDB = new ar.fiuba.redsocedu.datalayer.ws.Ambito();
		ambitoDB.setId(this.getId());
		ambitoDB.setAmbitoId(this.getId());
		if (this.getCarteleras() != null) {
			for (Cartelera c : this.getCarteleras()) {
				ar.fiuba.redsocedu.datalayer.ws.Cartelera carteleraBD = (ar.fiuba.redsocedu.datalayer.ws.Cartelera) c
						.getDatabaseEntity();
				ambitoDB.getCarteleras().add(carteleraBD);
			}
		}
		if (this.getChats() != null) {
			for (Chat c : this.getChats()) {
				ar.fiuba.redsocedu.datalayer.ws.Chat chatBD = (ar.fiuba.redsocedu.datalayer.ws.Chat) c
						.getDatabaseEntity();
				ambitoDB.getChats().add(chatBD);
			}
		}
		if (this.getMuros() != null) {
			for (Muro m : this.getMuros()) {
				ar.fiuba.redsocedu.datalayer.ws.Muro muroBD = (ar.fiuba.redsocedu.datalayer.ws.Muro) m
						.getDatabaseEntity();
				ambitoDB.getMuros().add(muroBD);
			}
		}
		if (this.getForos() != null) {
			for (Foro f : this.getForos()) {
				ar.fiuba.redsocedu.datalayer.ws.Foro foroBD = (ar.fiuba.redsocedu.datalayer.ws.Foro) f
						.getDatabaseEntity();
				ambitoDB.getForos().add(foroBD);
			}
		}
		return ambitoDB;
	}
}
