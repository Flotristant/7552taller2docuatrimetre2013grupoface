package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Nota;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.NotaTags;


public class NotaSerializer extends Serializer {

	@Override
	protected void setAttributeMappings(XStream xstream) {
		
		 //El nombre de la clase (atributo raiz) sera
		 xstream.alias(NotaTags.CLASS_TAG, Nota.class);
		 xstream.aliasField(NotaTags.ID_TAG, Nota.class, "id");
		 xstream.aliasField(NotaTags.ID_ACTIVIDAD_TAG, Nota.class, "actividadId");
		 xstream.aliasField(NotaTags.ID_GRUPO_TAG, Nota.class, "grupoId");
		 xstream.aliasField(NotaTags.ID_USUARIO_TAG, Nota.class, "usuarioId");
		 xstream.aliasField(NotaTags.NOTA_TAG, Nota.class, "nota");
		 xstream.aliasField(NotaTags.OBSERVACIONES_TAG, Nota.class, "observaciones");
		 xstream.omitField(Nota.class, "notaId");
		 xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
  
	}

}
