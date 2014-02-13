package com.ws.pojos;

public class Grupo extends Pojo{
	
	Long actividadId;
	String username;
	
	public Long getActividadId() {
		return actividadId;
	}
	public void setActividadId(Long actividadId) {
		this.actividadId = actividadId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Grupo grupoDB = new ar.fiuba.redsocedu.datalayer.ws.Grupo();
	    
		grupoDB.setActividadId(this.getActividadId());
		return grupoDB;
	}

}
