package com.ws.serializers;

import ar.fiuba.redsocedu.datalayer.ws.Actividad;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.ActividadTags;

/**
 * 
 * @author $Author$
 * @version $Revision$
 */
public class ActividadSerializer extends Serializer {

    @Override
    protected void setAttributeMappings(XStream xstream) {
        //El nombre de la clase (atributo raiz) sera
        xstream.alias(ActividadTags.CLASS_TAG, Actividad.class);
        //Mapeos de los nombres de atributo
        xstream.aliasField(ActividadTags.ID_TAG, Actividad.class, "id");
        xstream.aliasField(ActividadTags.ACTIVIDAD_ID_TAG, Actividad.class, "actividadId");
        xstream.aliasField(ActividadTags.ACTIVIDAD_SUPERIOR_ID_TAG, Actividad.class, "actividadSuperiorId");
        xstream.aliasField(ActividadTags.AMBITO_SUPERIOR_ID_TAG, Actividad.class, "ambitoSuperiorId");
        xstream.aliasField(ActividadTags.DESCRIPCION_TAG, Actividad.class, "descripcion");
        xstream.aliasField(ActividadTags.FECHA_FIN_TAG, Actividad.class, "fechaFin");
        xstream.aliasField(ActividadTags.FECHA_INICIO_TAG, Actividad.class, "fechaInicio");
        xstream.aliasField(ActividadTags.GRUPOS_TAG, Actividad.class, "grupos");
        xstream.aliasField(ActividadTags.GRUPOSEXCLUSIVO_TAG, Actividad.class, "gruposExclusivo");
        xstream.aliasField(ActividadTags.NOMBRE_TAG, Actividad.class, "nombre");
        xstream.aliasField(ActividadTags.NOTAS_TAG, Actividad.class, "notas");
        xstream.aliasField(ActividadTags.TIPO_TAG, Actividad.class, "tipo");
        xstream.aliasField(ActividadTags.TIPO_ESCALA_TAG, Actividad.class, "tipoEscala");

        xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");

    }

}
