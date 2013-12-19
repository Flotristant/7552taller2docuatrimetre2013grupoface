package com.ws.parsers;

import com.ws.pojos.Nota;
import com.ws.tags.NotaTags;

public class NotaParser extends Parser {

	public NotaParser() {
		super(NotaTags.CLASS_TAG);
		this.relaciones.put(NotaParser.class.toString(), "notas");
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(NotaTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Nota notaNegocio = (Nota) getEntidadNegocio(xml);
		ar.fiuba.redsocedu.datalayer.ws.Nota notaDB = getDBObjectFromBussinessObject(notaNegocio);        
        return notaDB;
	}

	public ar.fiuba.redsocedu.datalayer.ws.Nota getDBObjectFromBussinessObject(
			Nota notaNegocio) {
		ar.fiuba.redsocedu.datalayer.ws.Nota notaDB = new ar.fiuba.redsocedu.datalayer.ws.Nota();
        
        notaDB.setId(notaNegocio.getId());
        notaDB.setNotaId(notaNegocio.getIdNota());
        notaDB.setActividadId(notaNegocio.getIdActividad());
        notaDB.setGrupoId(notaNegocio.getIdGrupo());
        notaDB.setNota(notaNegocio.getNota());
        notaDB.setObservaciones(notaNegocio.getObservaciones());
        notaDB.setUsuarioId(notaNegocio.getIdUsuario());
		return notaDB;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
