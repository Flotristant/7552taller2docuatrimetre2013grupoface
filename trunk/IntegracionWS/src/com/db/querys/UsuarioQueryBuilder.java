package com.db.querys;

import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.utils.XmlGregorianConverter;
import com.ws.tags.UsuarioTags;

public class UsuarioQueryBuilder extends QueryBuilder{

	public UsuarioQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Usuario", UsuarioTags.ID_TAG);
	}

//	private Map<String, Object> obtenerAtributosConClase(Map<String, Object> attributes){
//		
//		HashMap<String, Object> mimapa = new HashMap<String, Object>();
////		
////		if (attributes.containsKey(UsuarioTags.ACTIVADO_TAG)){
////			Boolean activado = ((String)attributes.get(UsuarioTags.ACTIVADO_TAG)).equalsIgnoreCase("TRUE");
////			mimapa.put("activado", activado);
////			attributes.remove(UsuarioTags.ACTIVADO_TAG);
////		}
////		
////		if (attributes.containsKey(UsuarioTags.HABILITADO_TAG)){
////			Boolean habilitado = ((String)attributes.get(UsuarioTags.HABILITADO_TAG)).equalsIgnoreCase("TRUE");
////			mimapa.put("activado", habilitado);
////			attributes.remove(UsuarioTags.HABILITADO_TAG);
////		}
//		
//		if (attributes.containsKey(UsuarioTags.FECHANAC_TAG)){
//			
//			String fechaenmapa = (String)attributes.get(UsuarioTags.FECHANAC_TAG);
//			XMLGregorianCalendar fech = XmlGregorianConverter.string2XMLGregorian(fechaenmapa);
//			
//			if (fech != null){
//				mimapa.put("fechaNac", fech);
//			}
//			attributes.remove(UsuarioTags.FECHANAC_TAG);
//		}
//		
//		mimapa.putAll(attributes);
//		
//		return mimapa;
//	}

//	@Override
//	public String getAllByAttributes(Map<String, Object> attributes) {		
//		DetachedCriteria criteria = DetachedCriteria.forEntityName(this.className);
//		if(attributes.containsKey(UsuarioTags.ID_TAG)) {
//			Long id = (Long)(attributes.get(UsuarioTags.ID_TAG));
//			criteria.add(Restrictions.idEq(id));
//			attributes.remove(UsuarioTags.ID_TAG);
//		}
//		
//		criteria.add(Restrictions.allEq(obtenerAtributosConClase(attributes)));   //todos los atributos pasados por parámtero deben matchear
//		return QueryBuilder.getSerializedCriteria(criteria);
//	}
}
