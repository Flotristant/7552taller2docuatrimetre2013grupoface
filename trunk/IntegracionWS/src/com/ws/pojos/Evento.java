package com.ws.pojos;

public class Evento extends Pojo {

	Long eventoId;
	Long muroId;
    String nombre;
    
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
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Evento eventoDB = new ar.fiuba.redsocedu.datalayer.ws.Evento();

		eventoDB.setEventoId(this.getEventoId());
		eventoDB.setId(this.getId());
		eventoDB.setMuroId(this.getMuroId());
		eventoDB.setNombre(this.getNombre());
		
		return eventoDB;
	}

    
}
