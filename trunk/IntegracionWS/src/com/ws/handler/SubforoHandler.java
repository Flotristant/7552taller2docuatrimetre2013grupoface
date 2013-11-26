package com.ws.handler;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.NotificacionFactory;
import com.ws.parsers.ForoParser;
import com.ws.parsers.SubforoParser;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.NotificacionSerializer;

public class SubforoHandler extends Handler {

	@Override
	public String guardarDatos(Document doc) {
		SubforoParser parser = new SubforoParser(doc);
		try{
			port.beginTransaction();
			//TODO convertir al subforo de negocio en el subforo de base de datos
			//Subforo subforo = this.toDatabaseUser(parser.getEntidadSubForo());
			//port.saveOrUpdate("ar.fiuba.redsocedu.datalayer.dtos.Subforo",subforo);
			port.commit();
		}
		catch(ClientTransportException e) {
			port.rollback();
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
	
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());	
	}

	@Override
	public String actualizarDatos(Document doc) {
		SubforoParser parser = new SubforoParser(doc);
		try {
			port.beginTransaction();
			
			//TODO
			//String query = this.queryBuilder.getAllById(parser.getIdSubforo());
			List<ReturnedObject> foros = null; 
			
			//foros = port.query(query);
			if(foros == null || foros.isEmpty() || foros.size() > 1) {			
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			//TODO convertir al foro de negocio en el foro de base de datos
			//Foro foro = this.toDatabaseUser(parser.getEntidadForo());
			//foro.setForoId(parser.getIdForo());
			//port.saveOrUpdate("ar.fiuba.redsocedu.datalayer.dtos.Foro",foro);
				
			port.commit();
			
		}
		catch(ClientTransportException e) {
			port.rollback();
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}

	@Override
	public String borrarDatos(Document doc) {
		//TODO esperar implementacion datos
		SubforoParser parser = new SubforoParser(doc);
		try {
			/*port.beginTransaction();
			String query = this.queryBuilder.getAllById(parser.getIdSubforo());
			List<ReturnedObject> subforos = null; 
			subforos = port.query(query);
			if(subforos == null || subforos.isEmpty() || subforos.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Subforo removingUsuario = (Subforo)subforos.get(0);
			port.delete("ar.fiuba.redsocedu.datalayer.dtos.Usuario",removingUsuario);
			port.commit();//if ok*/
		} catch(ClientTransportException e) {
			port.rollback();//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
		
	}

	@Override
	public String seleccionarDatos(Document doc) {
		Map<String, String > campos = this.getCampos(doc);
		String query = this.queryBuilder.getAllByAttributes(campos);	
		try {
			port.beginTransaction();
			List<ReturnedObject> subforos = null; 
			subforos = port.query(query);
			if(subforos == null || subforos.isEmpty()) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.sinResultados());
			}
			port.commit();
			//TODO
			//return SubforoSerializer.getXMLfromPojo(subforos);
			return null;
		}catch (ClientTransportException e) {
			port.rollback();//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
	}
	
	protected Map<String, String> getCampos(Document doc) {
		SubforoParser parser = new SubforoParser(doc);
		return parser.obtenerCampos();
	}

}
