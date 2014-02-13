package com.ws.pojos;

public class ArchivoMetadata extends Pojo {

    private byte[] contenido;
	private String nombre;
    private  Long recursoId;
    private  Long tamanio;
    private String tipo;
    private ar.fiuba.redsocedu.datalayer.ws.Recurso recurso;
	
    public byte[] getContenido() {
		return contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
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

	public Long getTamanio() {
		return tamanio;
	}

	public void setTamanio(Long tamanio) {
		this.tamanio = tamanio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setRecurso(ar.fiuba.redsocedu.datalayer.ws.Recurso recurso){
		this.recurso = recurso;
	}
	
	public ar.fiuba.redsocedu.datalayer.ws.Recurso getRecurso(){
		return this.recurso;
	}

    
    
	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Archivo DBArchivo = new ar.fiuba.redsocedu.datalayer.ws.Archivo();
		DBArchivo.setId(this.getId());
		DBArchivo.setNombre(this.getNombre());
		DBArchivo.setTamanio(this.getTamanio());
		DBArchivo.setTipo(this.getTipo());
		DBArchivo.setContenido(this.getContenido());
		DBArchivo.setRecurso(this.getRecurso());
		return DBArchivo;
	}

}
