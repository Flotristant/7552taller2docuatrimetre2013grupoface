package com.ws.handler;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.ForoQueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.NotificacionFactory;
import com.ws.parsers.ForoParser;
import com.ws.serializers.NotificacionSerializer;

public class ForoHandler extends Handler {
	
	
	public ForoHandler() {
		super();
		this.queryBuilder = new ForoQueryBuilder();
	}
	

	@Override
	public String guardarDatos(Document doc) {
		ForoParser parser = new ForoParser(doc);
		try{
			port.beginTransaction();
			//TODO convertir al foro de negocio en el foro de base de datos
			//Foro foro = this.toDatabaseUser(parser.getEntidadForo());
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
	public String actualizarDatos(Document doc) {
		ForoParser parser = new ForoParser(doc);
		try {
			port.beginTransaction();
			
			//TODO
			//String query = this.queryBuilder.getAllById(parser.getIdForo());
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
		//TODO esperar implementacion de datos
		ForoParser parser = new ForoParser(doc);
		try {
			/*port.beginTransaction();
			String query = this.queryBuilder.getAllById(parser.getIdForo());
			List<ReturnedObject> foros = null; 
			foros = port.query(query);
			if(foros == null || foros.isEmpty() || foros.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Foro removingForo = (Foro)foros.get(0);
			port.delete("ar.fiuba.redsocedu.datalayer.dtos.Foro",removingForo);
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
			List<ReturnedObject> foros = null; 
			foros = port.query(query);
			if(foros == null || foros.isEmpty()) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.sinResultados());
			}
			port.commit();
			//TODO
			//return ForoSerializer.getXMLfromPojo(foros);
			return null;
		}catch (ClientTransportException e) {
			port.rollback();//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
	}
	
	protected Map<String, String> getCampos(Document doc) {
		ForoParser parser = new ForoParser(doc);
		return parser.obtenerCampos();
	}

}
