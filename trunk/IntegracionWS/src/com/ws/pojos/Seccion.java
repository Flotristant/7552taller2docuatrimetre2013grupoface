package com.ws.pojos;

public class Seccion extends Pojo {
	
	Long idForo;
	String nombre;
	
	public Long getIdForo() {
		return idForo;
	}
	public void setIdForo(Long idForo) {
		this.idForo = idForo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public Object getDatabaseEntity() {
        ar.fiuba.redsocedu.datalayer.ws.Seccion seccionDB = new ar.fiuba.redsocedu.datalayer.ws.Seccion();
        seccionDB.setId(this.getId());
        seccionDB.setNombre(this.getNombre());
        //		seccionDB.setForoId(this.getIdForo());

        return seccionDB;
	}
}
