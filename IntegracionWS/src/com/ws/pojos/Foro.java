package com.ws.pojos;

import java.util.List;

import com.ws.pojos.Seccion;

public class Foro extends Pojo {

	String nombre;
	Long idAmbito;
	List<Seccion> secciones;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdAmbito() {
		return idAmbito;
	}

	public void setIdAmbito(Long idAmbito) {
		this.idAmbito = idAmbito;
	}

	public List<Seccion> getSecciones() {
		return secciones;
	}

	public void setSecciones(List<Seccion> secciones) {
		this.secciones = secciones;
	}

	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Foro foroDB = new ar.fiuba.redsocedu.datalayer.ws.Foro();
		foroDB.setId(this.getId());
		foroDB.setAmbitoId(this.idAmbito);
		foroDB.setNombre(this.getNombre());
		if (secciones != null) {
			for (Seccion s : secciones) {
				foroDB.getSecciones().add(
						(ar.fiuba.redsocedu.datalayer.ws.Seccion) s
								.getDatabaseEntity());
			}
		}

		return foroDB;
	}
}
