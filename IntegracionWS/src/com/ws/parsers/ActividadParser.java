package com.ws.parsers;

import com.ws.pojos.Actividad;
import com.ws.tags.ActividadTags;

public class ActividadParser extends Parser {
	
	public ActividadParser() {
		super(ActividadTags.CLASS_TAG);
//		relaciones.put(NotaParser.getClass().toString(), "notas");
//		relaciones.put(GrupoParser.getClass().toString(), "grupos");
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(ActividadTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		Actividad miObjNegocio = (Actividad) getEntidadNegocio(xml);

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

	@Override
	protected Boolean validateJoinParser(Parser parser) {
//		if((parser instanceof NotaParser.class) || (parser instancof GrupoParser.class)) {
//			return true;
//		}
		return false;
	}
}
