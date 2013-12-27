package com.ws.parsers;

import com.ws.pojos.Actividad;
import com.ws.pojos.Grupo;
import com.ws.pojos.Nota;
import com.ws.tags.ActividadTags;
import com.ws.tags.GrupoTags;
import com.ws.tags.NotaTags;

public class ActividadParser extends Parser {
	
	public ActividadParser() {
		super(ActividadTags.CLASS_TAG);
		relaciones_directas.put(NotaParser.class.toString(), "notas");
		relaciones_directas.put(GrupoParser.class.toString(), "grupos");
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Actividad miObjNegocio = (Actividad) getEntidadNegocio(xml);
        return miObjNegocio.getDatabaseEntity();
	}

	private ar.fiuba.redsocedu.datalayer.ws.Actividad toDBObject(
			Actividad miObjNegocio) {
		ar.fiuba.redsocedu.datalayer.ws.Actividad miObjDB = new ar.fiuba.redsocedu.datalayer.ws.Actividad();

        miObjDB.setId(miObjNegocio.getId());
        miObjDB.setActividadId(miObjNegocio.getActividadId());
        miObjDB.setActividadSuperiorId(miObjNegocio.getActividadSuperiorId());
        miObjDB.setAmbitoSuperiorId(miObjNegocio.getAmbitoSuperiorId());
        miObjDB.setDescripcion(miObjNegocio.getDescripcion());
        miObjDB.setFechaFin(miObjNegocio.getFechaFin());
        miObjDB.setFechaInicio(miObjNegocio.getFechaInicio());
        if (miObjNegocio.getGruposExclusivos()!=null){
        	miObjDB.setGruposExclusivo(miObjNegocio.getGruposExclusivos());
        }
        miObjDB.setNombre(miObjNegocio.getNombre());
        miObjDB.setTipo(miObjNegocio.getTipo());
        miObjDB.setTipoEscala(miObjNegocio.getTipoEscala());
        NotaParser notaParser = new NotaParser();
        if (miObjNegocio.getNotas() != null){
        for (Nota nota : miObjNegocio.getNotas()) {
			miObjDB.getNotas().add(notaParser.getDBObjectFromBussinessObject(nota));
		}}
        GrupoParser grupoParser = new GrupoParser();
        
        if (miObjNegocio.getGrupos() != null){
        for (Grupo grupo : miObjNegocio.getGrupos()) {
			miObjDB.getGrupos().add((ar.fiuba.redsocedu.datalayer.ws.Grupo)grupoParser.getDBObjectFromBussinessObject(grupo));
		}}
		return miObjDB;
	}
	
	@Override
	protected String replaceClassTag(String xml) {
		xml = super.replaceClassTag(xml);
		xml = xml.replace(NotaTags.CLASS_TAG, "com.ws.pojos."
				+ NotaTags.CLASS_TAG);
		xml = xml.replace(GrupoTags.CLASS_TAG, "com.ws.pojos."
				+ GrupoTags.CLASS_TAG);
		return xml;
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
//		if((parser instanceof NotaParser.class) || (parser instancof GrupoParser.class)) {
//			return true;
//		}
		return false;
	}
}
