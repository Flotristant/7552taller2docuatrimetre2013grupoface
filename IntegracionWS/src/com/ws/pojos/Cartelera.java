package com.ws.pojos;

import java.util.List;


public class Cartelera extends Pojo {

	protected String nombre;
	protected Long ambitoId;
	protected List<Noticia> noticias;
    
	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Long getAmbitoId() {
		return ambitoId;
	}

	public void setAmbitoId(Long ambitoId) {
		this.ambitoId = ambitoId;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Object getDatabaseEntity() {
		ar.fiuba.redsocedu.datalayer.ws.Cartelera miObjDB = new ar.fiuba.redsocedu.datalayer.ws.Cartelera();
        
        miObjDB.setAmbitoId(this.getAmbitoId());
        miObjDB.setId(this.getId());
        miObjDB.setNombre(this.getNombre());
        List<ar.fiuba.redsocedu.datalayer.ws.Noticia> noticiasDB = miObjDB.getNoticias();
        if (this.noticias != null) {
        	for(Noticia noticia: this.noticias) {
        		ar.fiuba.redsocedu.datalayer.ws.Noticia noticiaDB = new ar.fiuba.redsocedu.datalayer.ws.Noticia();
        		noticiaDB.setCarteleraId(noticia.getCarteleraId());
        		noticiaDB.setContenido(noticia.getContenido());
        		noticiaDB.setId(noticia.getId());
        		noticiaDB.setNoticiaId(noticia.getId());
        		noticiaDB.setTitulo(noticia.getTitulo());
        		noticiasDB.add(noticiaDB);
        	}
        }
        
		return miObjDB;
	}
}
