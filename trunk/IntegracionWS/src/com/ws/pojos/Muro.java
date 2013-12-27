package com.ws.pojos;

public class Muro extends Pojo {
	 
	protected String nombre;
	 
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
		muroDB.setMuroId(this.getId());
		return muroDB;
	}
	
}
