package com.ws.pojos;

public class Link extends Pojo{

	private String nombre;
	private Long recursoId;
	private Recurso recurso;
	
	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getRecursoId() {
		return recursoId;
	}

	public void setRecursoId(Long recursoId) {
		this.recursoId = recursoId;
	}

	
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Link linkDB = new ar.fiuba.redsocedu.datalayer.ws.Link();
		linkDB.setId(this.getId());
		linkDB.setNombre(this.getNombre());
		if(this.getRecurso() != null)
			linkDB.setRecurso((ar.fiuba.redsocedu.datalayer.ws.Recurso)this.getRecurso().getDatabaseEntity());
		return linkDB;
	}

}
