package com.ws.pojos;

public class Recurso extends Pojo{
	
	Long ambitoId;
	Long recursoId;
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

	public Long getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(Long idRecurso) {
		this.recursoId = idRecurso;
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
		recursoDB.setRecursoId(this.getRecursoId());
		recursoDB.setId(this.getId());
		recursoDB.setDescripcion(this.getDescripcion());
		recursoDB.setTipo(this.getTipo());
		
		return recursoDB;
	}
	

}
