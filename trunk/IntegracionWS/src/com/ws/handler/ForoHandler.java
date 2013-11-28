package com.ws.handler;

import java.util.List;

import org.w3c.dom.Document;


import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.ForoParser;
import com.ws.pojos.Foro;
import com.ws.serializers.ForoSerializer;
import com.ws.serializers.NotificacionSerializer;


public class ForoHandler extends Handler{

	//TODO ver si la entidad se llama asi
	public ForoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Foro", new ForoParser(), new ForoSerializer());
	}


	@Override
	public String actualizarDatos(Document doc) {
		this.parser.inicializarDocumento(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			
			String query = this.queryBuilder.getAllById(parser.getId());
			List<ReturnedObject> foros = null; 
			
			foros = port.query(transactionId, query);
			if(foros == null || foros.isEmpty() || foros.size() > 1) {			
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			//TODO convertir al foro de negocio en el foro de base de datos
			//Foro foro = this.toDatabaseEntity(parser.getEntidad());
			//port.saveOrUpdate("ar.fiuba.redsocedu.datalayer.dtos.Foro",foro);
				
			port.commit(transactionId);		
		}
		catch(ClientTransportException e) {
			port.rollback(transactionId);
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}

	@Override
	public String borrarDatos(Document doc) {
		//TODO esperar implementacion datos
		this.parser.inicializarDocumento(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			String query = this.queryBuilder.getAllById(parser.getId());
			List<ReturnedObject> foros = null; 
			foros = port.query(transactionId, query);
			if(foros == null || foros.isEmpty() || foros.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			//Foro removingForo = (Foro)foros.get(0);
			//port.delete("ar.fiuba.redsocedu.datalayer.dtos.Foro",removingForo);
			port.commit(transactionId);//if ok*/
		} catch(ClientTransportException e) {
			port.rollback(transactionId);//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}
	

	@Override
	protected Object toDatabaseEntity(Object object) {
		//TODO ver bien esto
		/*com.ws.pojos.Foro foro = (com.ws.pojos.Foro) object;
		ar.fiuba.redsocedu.datalayer.ws.Foro foroDb = new ar.fiuba.redsocedu.datalayer.ws.Foro();
		foroDb.setNombre(foro.getNombre());
		foroDb.setIdForo(foro.getId());
		foroDb.setIdAmbito(foro.getIdAmbito());
		
		return foroDb;
		 */
		return null;
	}
}
