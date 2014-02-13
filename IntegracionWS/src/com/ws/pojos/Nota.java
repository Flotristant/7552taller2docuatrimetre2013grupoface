package com.ws.pojos;

public class Nota extends Pojo {

	protected Long idActividad; 
	protected Long idGrupo;
	protected Long idUsuario;
	protected String nota;
	protected String observaciones;
	

	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Nota notaDB = new ar.fiuba.redsocedu.datalayer.ws.Nota();
        
        notaDB.setId(this.getId());
        notaDB.setNotaId(this.getId());
        notaDB.setActividadId(this.getIdActividad());
        notaDB.setGrupoId(this.getIdGrupo());
        notaDB.setNota(this.getNota());
        notaDB.setObservaciones(this.getObservaciones());
        notaDB.setUsuarioId(this.getIdUsuario());
		return notaDB;
	}
	
}
