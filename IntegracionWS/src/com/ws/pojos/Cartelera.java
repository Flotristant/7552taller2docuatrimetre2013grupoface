package com.ws.pojos;


public class Cartelera extends Pojo {

	protected Long id;
	protected String nombre;
	protected Long ambitoId;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		ar.fiuba.redsocedu.datalayer.ws.Cartelera miObjDB = new ar.fiuba.redsocedu.datalayer.ws.Cartelera();
        
        miObjDB.setAmbitoId(this.getAmbitoId());
        miObjDB.setCarteleraId(this.getId());
        miObjDB.setId(this.getId());
        miObjDB.setNombre(this.getNombre());
		return miObjDB;
	}
}
