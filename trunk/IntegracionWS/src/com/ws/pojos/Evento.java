package com.ws.pojos;

public class Evento {

	Long id;
	Long eventoId;
	Long muroId;
    String nombre;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    public Long getEventoId() {
		return eventoId;
	}
	public void setEventoId(Long eventoId) {
		this.eventoId = eventoId;
	}
	public Long getMuroId() {
		return muroId;
	}
	public void setMuroId(Long muroId) {
		this.muroId = muroId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    
}
