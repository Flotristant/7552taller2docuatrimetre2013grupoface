package com.ws.pojos;

import java.util.List;

import ar.fiuba.redsocedu.datalayer.ws.Chat;

public class Ambito extends Pojo {
    protected Long ambitoId;
    protected List<Cartelera> carteleras;
    protected List<Chat> chats;
    protected List<Foro> foros;
    protected List<Muro> muros;
    
	public Long getAmbitoId() {
		return ambitoId;
	}
	public void setAmbitoId(Long ambitoId) {
		this.ambitoId = ambitoId;
	}
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
		ambitoDB.setId(this.getAmbitoId());
		return ambitoDB;
	}
}
