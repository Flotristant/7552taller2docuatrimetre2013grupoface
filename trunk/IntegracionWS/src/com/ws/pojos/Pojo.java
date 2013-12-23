package com.ws.pojos;


public abstract class Pojo {
	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public abstract Object getDatabaseEntity();
}