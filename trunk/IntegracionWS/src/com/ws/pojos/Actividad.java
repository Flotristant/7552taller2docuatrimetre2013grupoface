package com.ws.pojos;

import java.util.List;



public class Actividad extends Pojo {

    protected Long actividadId;
    protected Long actividadSuperiorId;
    protected Long ambitoSuperiorId;
    protected String descripcion;
    protected Long fechaFin;
	protected Long fechaInicio;
    protected List<Grupo> grupos;
    protected boolean gruposExclusivos;
    protected String nombre;
    protected List<Nota> notas;
    protected String tipo;
    protected String tipoEscala;
    
    public Long getActividadId() {
 		return actividadId;
 	}
 	public void setActividadId(Long actividadId) {
 		this.actividadId = actividadId;
 	}
 	public Long getActividadSuperiorId() {
 		return actividadSuperiorId;
 	}
 	public void setActividadSuperiorId(Long actividadSuperiorId) {
 		this.actividadSuperiorId = actividadSuperiorId;
 	}
 	public Long getAmbitoSuperiorId() {
 		return ambitoSuperiorId;
 	}
 	public void setAmbitoSuperiorId(Long ambitoSuperiorId) {
 		this.ambitoSuperiorId = ambitoSuperiorId;
 	}
 	public String getDescripcion() {
 		return descripcion;
 	}
 	public void setDescripcion(String descripcion) {
 		this.descripcion = descripcion;
 	}
 	public Long getFechaFin() {
 		return fechaFin;
 	}
 	public void setFechaFin(Long fechaFin) {
 		this.fechaFin = fechaFin;
 	}
 	public Long getFechaInicio() {
 		return fechaInicio;
 	}
 	public void setFechaInicio(Long fechaInicio) {
 		this.fechaInicio = fechaInicio;
 	}
 	public List<Grupo> getGrupos() {
 		return grupos;
 	}
 	public void setGrupos(List<Grupo> grupos) {
 		this.grupos = grupos;
 	}
 	public boolean getGruposExclusivos() {
 		return gruposExclusivos;
 	}
 	public void setGruposExclusivos(boolean gruposExclusivos) {
 		this.gruposExclusivos = gruposExclusivos;
 	}
 	public String getNombre() {
 		return nombre;
 	}
 	public void setNombre(String nombre) {
 		this.nombre = nombre;
 	}
 	public List<Nota> getNotas() {
 		return notas;
 	}
 	public void setNotas(List<Nota> notas) {
 		this.notas = notas;
 	}
 	public String getTipo() {
 		return tipo;
 	}
 	public void setTipo(String tipo) {
 		this.tipo = tipo;
 	}
 	public String getTipoEscala() {
 		return tipoEscala;
 	}
 	public void setTipoEscala(String tipoEscala) {
 		this.tipoEscala = tipoEscala;
 	}

}
