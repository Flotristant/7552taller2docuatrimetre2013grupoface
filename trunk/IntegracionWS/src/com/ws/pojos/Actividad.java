package com.ws.pojos;

import java.util.List;

import com.db.querys.DBManager;



public class Actividad extends Pojo {
	
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
    protected List<Usuario> usuarios;
    
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
 	
 	public List<Usuario> getUsuarios() {
 		return usuarios;
 	}
 	public void setUsuarios(List<Usuario> usuarios) {
 		this.usuarios = usuarios;
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
        if (this.getNotas() != null){
        	for (Nota nota : this.getNotas()) {
        		ar.fiuba.redsocedu.datalayer.ws.Nota notaDB = (ar.fiuba.redsocedu.datalayer.ws.Nota)nota.getDatabaseEntity();
    			try {
    				if(notaDB.getId() == null) {
    					notaDB.setActividadId(this.getId());
    					Long id = DBManager.guardarObjetos(notaDB, "ar.fiuba.redsocedu.datalayer.dtos.Nota");
    					notaDB.setId(id);
    				}        		
    				miObjDB.getNotas().add(notaDB);
				} catch (Exception e) {
					break;
				}
        	}
        }
        
        if (this.getGrupos() != null){
        	for (Grupo grupo : this.getGrupos()) {
        		ar.fiuba.redsocedu.datalayer.ws.Grupo grupoDB = (ar.fiuba.redsocedu.datalayer.ws.Grupo)grupo.getDatabaseEntity();
        		try {
        			grupoDB.setActividadId(this.getId());
	        		if(grupoDB.getId() == null) {
	        			DBManager.guardarObjetos(grupoDB, "ar.fiuba.redsocedu.datalayer.dtos.Grupo");
	        		}
	        		miObjDB.getGrupos().add(grupoDB);
        		} catch (Exception e) {
        			break;
        		}
        	}
        }
        
        //entiendo que no es necesario guardar el usuario si el mismo no existe, no tendria sentido crear un usuario nuevo
        // apartir de una actividad que hace referencia a él ya que la existencia deberia chequearse mas arriba.
    	if(this.usuarios != null) {
			for(Usuario unusuario : usuarios) {
				miObjDB.getUsuarios().add((ar.fiuba.redsocedu.datalayer.ws.Usuario)unusuario.getDatabaseEntity());
			}
		}

        return miObjDB;
	}

}
