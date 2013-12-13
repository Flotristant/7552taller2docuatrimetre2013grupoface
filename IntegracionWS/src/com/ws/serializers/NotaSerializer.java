package com.ws.serializers;

import com.thoughtworks.xstream.XStream;
import com.ws.pojos.Nota;
import com.ws.pojos.NotaGrupal;
import com.ws.pojos.NotaIndividual;
import com.ws.tags.NotaTags;


public class NotaSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		Nota nota = this.convertirAEntidadNegocio((ar.fiuba.redsocedu.datalayer.ws.Nota)this.objetoDTO);
		this.objetoDTO = nota;
		
		//Convierto la información en una nota individual o grupal 
		if(nota.getIdGrupo() != null){
			xstream.alias(NotaTags.CLASS_TAG_GRUPAL, NotaGrupal.class);
			xstream.omitField(NotaGrupal.class, "idUsuario");
			xstream.omitField(NotaGrupal.class, "idNota");
			xstream.aliasField(NotaTags.ID_TAG, NotaGrupal.class, "id");
			xstream.aliasField(NotaTags.ID_ACTIVIDAD_TAG, NotaGrupal.class, "idActividad");
			xstream.aliasField(NotaTags.ID_GRUPO_TAG, NotaGrupal.class, "idGrupo");
			xstream.aliasField(NotaTags.NOTA_TAG, NotaGrupal.class, "nota");
			xstream.aliasField(NotaTags.OBSERVACIONES_TAG, NotaGrupal.class, "observaciones");
		}
		else{
			xstream.alias(NotaTags.CLASS_TAG_INDIVIDUAL, NotaIndividual.class);
			xstream.omitField(NotaIndividual.class, "idGrupo");
			xstream.omitField(NotaIndividual.class, "idNota");
			xstream.aliasField(NotaTags.ID_TAG, NotaIndividual.class, "id");
			xstream.aliasField(NotaTags.ID_ACTIVIDAD_TAG, NotaIndividual.class, "idActividad");
			xstream.aliasField(NotaTags.ID_USUARIO_TAG, NotaIndividual.class, "idUsuario");
			xstream.aliasField(NotaTags.NOTA_TAG, NotaIndividual.class, "nota");
			xstream.aliasField(NotaTags.OBSERVACIONES_TAG, NotaIndividual.class, "observaciones");
		}
	
        xstream.aliasPackage("", "com.ws.pojos");
  
	}
	
	
	private Nota convertirAEntidadNegocio(ar.fiuba.redsocedu.datalayer.ws.Nota notaDB){
		
		Nota notaNegocio;
		if(notaDB.getGrupoId() != null){
			 notaNegocio= new NotaGrupal();
			 notaNegocio.setIdGrupo(notaDB.getGrupoId());
		}
		else
		{
			notaNegocio = new NotaIndividual();
			notaNegocio.setIdUsuario(notaDB.getUsuarioId());
		}
		notaNegocio.setId(notaDB.getId());
		notaNegocio.setIdActividad(notaDB.getActividadId());
		notaNegocio.setNota(notaDB.getNota());
		notaNegocio.setObservaciones((notaDB.getObservaciones()));
		notaNegocio.setIdNota(notaDB.getNotaId());
		
		return notaNegocio;
	}

}
