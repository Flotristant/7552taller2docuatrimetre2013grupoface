package com.ws.pojos;


public class Recurso extends Pojo{
	
	Long ambitoId;
	String descripcion;
	String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getAmbitoId() {
		return ambitoId;
	}

	public void setAmbitoId(Long ambitoId) {
		this.ambitoId = ambitoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Recurso recursoDB = new ar.fiuba.redsocedu.datalayer.ws.Recurso();
		recursoDB.setAmbitoId(this.getAmbitoId());
		recursoDB.setId(this.getId());
		recursoDB.setDescripcion(this.getDescripcion());
		recursoDB.setTipo(this.getTipo());
		return recursoDB;
	}
	

}
