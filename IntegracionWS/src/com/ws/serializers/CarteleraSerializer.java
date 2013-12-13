package com.ws.serializers;



import ar.fiuba.redsocedu.datalayer.ws.Cartelera;

import com.thoughtworks.xstream.XStream;
import com.ws.tags.CarteleraTags;

public class CarteleraSerializer extends Serializer {

	//TODO  Cambiar la clase del POJO
	
	protected  void setAttributeMappings(XStream xstream) {
		
		//El nombre de la clase (atributo raiz) sera
		xstream.alias(CarteleraTags.CLASS_TAG, Cartelera.class);
		
		//Mapeos de los nombres de atributo
		xstream.aliasField(CarteleraTags.ID_TAG, Cartelera.class, "id");
		xstream.aliasField(CarteleraTags.NOMBRE_TAG, Cartelera.class, "nombre");
		xstream.aliasPackage("", "ar.fiuba.redsocedu.datalayer.ws");
	}
	
}
