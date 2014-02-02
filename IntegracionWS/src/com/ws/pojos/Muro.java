package com.ws.pojos;

import java.util.List;

public class Muro extends Pojo {
	 
	protected String nombre;
	protected List<Evento> eventos;
	protected Long ambitoId;
	
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public Long getAmbitoId() {
		return ambitoId;
	}
	public void setAmbitoId(Long ambitoId) {
		this.ambitoId = ambitoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Muro muroDB = new ar.fiuba.redsocedu.datalayer.ws.Muro();
		muroDB.setId(this.getId());
		muroDB.setNombre(this.getNombre());
		muroDB.setAmbitoId(this.getAmbitoId());
		List<ar.fiuba.redsocedu.datalayer.ws.Evento> eventosDB = muroDB.getEventos();
		if(this.eventos != null ) {
			for(Evento evento: this.eventos) {
				ar.fiuba.redsocedu.datalayer.ws.Evento eventoDB = new ar.fiuba.redsocedu.datalayer.ws.Evento();
				eventoDB.setId(evento.getId());
				eventoDB.setMuroId(evento.getMuroId());
				eventoDB.setNombre(evento.getNombre());
				eventosDB.add(eventoDB);
			}
		}
		
		return muroDB;
	}
	
}
