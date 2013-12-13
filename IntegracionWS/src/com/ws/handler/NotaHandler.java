package com.ws.handler;

import com.db.querys.NotaQueryBuilder;
import com.ws.parsers.NotaParser;
import com.ws.pojos.Nota;
import com.ws.serializers.NotaSerializer;

public class NotaHandler extends Handler {

	public NotaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Nota", new NotaParser(), new NotaSerializer(), new NotaQueryBuilder());
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		Nota notaNegocio = (Nota) object;
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

}
