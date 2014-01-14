package com.ws.pojos;

public class Recurso extends Pojo{
	
	Long idAmbiente;
	Long idRecurso;
	String descripcion;

	public Long getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(Long idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public Long getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(Long idRecurso) {
		this.idRecurso = idRecurso;
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
		recursoDB.setAmbitoId(this.getIdAmbiente());
		recursoDB.setRecursoId(this.getIdRecurso());
		recursoDB.setId(this.getId());
		recursoDB.setDescripcion(this.getDescripcion());
		
		return recursoDB;
	}

}
