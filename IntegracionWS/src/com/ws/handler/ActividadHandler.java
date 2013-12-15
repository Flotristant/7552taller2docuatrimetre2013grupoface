package com.ws.handler;

import com.db.querys.ActividadQueryBuilder;
import com.ws.parsers.ActividadParser;
import com.ws.pojos.Actividad;
import com.ws.serializers.ActividadSerializer;

public class ActividadHandler extends Handler {

	public ActividadHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Actividad", 
				new ActividadParser(), new ActividadSerializer(), new ActividadQueryBuilder());
	}
	
	@Override
	public Object toDatabaseEntity(Object object) {
		Actividad miObjNegocio = (Actividad)object;
		ar.fiuba.redsocedu.datalayer.ws.Actividad miObjDB = new ar.fiuba.redsocedu.datalayer.ws.Actividad();

        miObjDB.setId(miObjNegocio.getId());
        miObjDB.setActividadId(miObjNegocio.getActividadId());
        miObjDB.setActividadSuperiorId(miObjNegocio.getIdActividadSuperior());
        miObjDB.setAmbitoSuperiorId(miObjNegocio.getIdAmbitoSuperior());
        miObjDB.setDescripcion(miObjNegocio.getDescripcion());
        miObjDB.setFechaFin(miObjNegocio.getFechaFin());
        miObjDB.setFechaInicio(miObjNegocio.getFechaInicio());
        miObjDB.setGruposExclusivo(miObjNegocio.getGruposExclusivo());
        miObjDB.setNombre(miObjNegocio.getNombre());
        miObjDB.setTipo(miObjNegocio.getTipo());
        miObjDB.setTipoEscala(miObjNegocio.getTipoEscala());

        return miObjDB;
	}

}
