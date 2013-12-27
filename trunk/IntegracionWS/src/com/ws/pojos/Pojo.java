package com.ws.pojos;


public abstract class Pojo {
	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	//TODO: revisar las clases con listas de otras entidades adentro, hay que pasar las entidades de adentro a 
	// objetos de BD también.
	public abstract Object getDatabaseEntity();
}