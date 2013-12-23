package com.ws.pojos;

import java.util.List;

import com.ws.parsers.GrupoParser;
import com.ws.parsers.NotaParser;



public class Actividad extends Pojo {

    protected Long actividadId;
    protected Long actividadSuperiorId;
    protected Long ambitoSuperiorId;
    protected String descripcion;
    protected Long fechaFin;
	protected Long fechaInicio;
    protected List<Grupo> grupos;
    protected Boolean gruposExclusivos;
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
 	public Boolean getGruposExclusivos() {
 		return gruposExclusivos;
 	}
 	public void setGruposExclusivos(Boolean gruposExclusivos) {
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
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Actividad miObjDB = new ar.fiuba.redsocedu.datalayer.ws.Actividad();

        miObjDB.setId(this.getId());
        miObjDB.setActividadId(this.getActividadId());
        miObjDB.setActividadSuperiorId(this.getActividadSuperiorId());
        miObjDB.setAmbitoSuperiorId(this.getAmbitoSuperiorId());
        miObjDB.setDescripcion(this.getDescripcion());
        miObjDB.setFechaFin(this.getFechaFin());
        miObjDB.setFechaInicio(this.getFechaInicio());
        if (this.getGruposExclusivos()!=null){
        	miObjDB.setGruposExclusivo(this.getGruposExclusivos());
        }
        miObjDB.setNombre(this.getNombre());
        miObjDB.setTipo(this.getTipo());
        miObjDB.setTipoEscala(this.getTipoEscala());
        NotaParser notaParser = new NotaParser();
        if (this.getNotas() != null){
        	for (Nota nota : this.getNotas()) {
        		miObjDB.getNotas().add(notaParser.getDBObjectFromBussinessObject(nota));
        	}
        }
        GrupoParser grupoParser = new GrupoParser();
        
        if (this.getGrupos() != null){
        	for (Grupo grupo : this.getGrupos()) {
        		miObjDB.getGrupos().add((ar.fiuba.redsocedu.datalayer.ws.Grupo)grupoParser.getDBObjectFromBussinessObject(grupo));
        	}
        }

        return miObjDB;
	}

}
