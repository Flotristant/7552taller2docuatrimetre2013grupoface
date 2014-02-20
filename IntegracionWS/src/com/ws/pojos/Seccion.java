package com.ws.pojos;

import java.util.List;

public class Seccion extends Pojo {

	Long idForo;
	String nombre;
	List<Subforo> subforos;

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

	public List<Subforo> getSubforos() {
		return subforos;
	}

	public void setSubforos(List<Subforo> subforos) {
		this.subforos = subforos;
	}

	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Seccion seccionDB = new ar.fiuba.redsocedu.datalayer.ws.Seccion();
		seccionDB.setId(this.getId());
		seccionDB.setNombre(this.getNombre());
		seccionDB.setForoId(this.getIdForo());
		if (subforos != null) {
			for (Subforo s : subforos) {
				seccionDB.getSubforos().add(
						(ar.fiuba.redsocedu.datalayer.ws.Subforo) s
								.getDatabaseEntity());
			}
		}
		return seccionDB;
	}
}
