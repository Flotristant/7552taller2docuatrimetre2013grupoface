package com.ws.pojos;

import java.util.List;

public class Subforo extends Pojo {

	protected Long idForo;
	protected Long idSubforoPadre;
	protected Long idSeccion; 
	protected String nombre;
	List<Subforo> subforos;
	List<Tema> temas;
	
	public Long getIdForo() {
		return idForo;
	}
	public void setIdForo(Long idForo) {
		this.idForo = idForo;
	}
	public Long getIdSubforoPadre() {
		return idSubforoPadre;
	}
	public void setIdSubforoPadre(Long idSubforoPadre) {
		this.idSubforoPadre = idSubforoPadre;
	}
	public Long getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Subforo> getSubforos() {
		return subforos;
	}
	public void setSubforos(List<Subforo> subforos) {
		this.subforos = subforos;
	}
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Subforo subforoDB = new ar.fiuba.redsocedu.datalayer.ws.Subforo();		
		subforoDB.setNombre(this.getNombre());		
		if(this.getId() != null)
			subforoDB.setId(this.getId());
		if(this.getIdSeccion() != null)
			subforoDB.setSeccionId(this.getIdSeccion());
		if(this.getIdSubforoPadre() != null)
			subforoDB.setSubforopadreId(this.getIdSubforoPadre());
		if(subforos != null) {
			for(Subforo sub: subforos) {
				subforoDB.getSubforos().add((ar.fiuba.redsocedu.datalayer.ws.Subforo)sub.getDatabaseEntity()); 
			} 
		}
		if(temas != null) {
			for(Tema tema : temas) {
				subforoDB.getTemas().add((ar.fiuba.redsocedu.datalayer.ws.Tema)tema.getDatabaseEntity());
			}
		}
		return subforoDB;
	}
	
}
