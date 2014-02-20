package com.ws.pojos;

public class Encuesta extends Pojo {
	

	Boolean evaluada;
	String preguntas;
	Recurso recurso;
	Long recursoId;

	public Long getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(Long recursoId) {
		this.recursoId = recursoId;
	}

	public Boolean getEvaluada() {
		return evaluada;
	}

	public void setEvaluada(Boolean evaluada) {
		this.evaluada = evaluada;
	}

	public String getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(String preguntas) {
		this.preguntas = preguntas;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Encuesta encuestaDB = new ar.fiuba.redsocedu.datalayer.ws.Encuesta();
		encuestaDB.setEvaluada(this.getEvaluada());
		encuestaDB.setId(this.getId());
		encuestaDB.setPreguntas(this.getPreguntas());
		if(this.getRecurso() != null)
			encuestaDB.setRecurso((ar.fiuba.redsocedu.datalayer.ws.Recurso)this.getRecurso().getDatabaseEntity());
		
		return encuestaDB;
	}

}
