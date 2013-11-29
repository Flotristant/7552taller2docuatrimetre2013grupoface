package com.ws.handler;

import java.util.List;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.SubforoQueryBuilder;
import com.db.querys.UsuarioQueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.SubforoParser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.SubforoSerializer;

public class SubforoHandler extends Handler {


	//TODO ver si la entidad se llama asi
	public SubforoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Subforo", new  SubforoParser(), new SubforoSerializer());
		this.queryBuilder = new SubforoQueryBuilder();
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
			//Subforo subforo = this.toDatabaseEntity(parser.getEntidad());
			//port.saveOrUpdate("ar.fiuba.redsocedu.datalayer.dtos.Subforo",subforo);
				
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
			List<ReturnedObject> subforos = null; 
			subforos = port.query(transactionId, query);
			if(subforos == null || subforos.isEmpty() || subforos.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			//Subforo removingSubforo = (Subforo)subforos.get(0);
			//port.delete("ar.fiuba.redsocedu.datalayer.dtos.Subforo",removingSubforo);
			port.commit(transactionId);//if ok*/
		} catch(ClientTransportException e) {
			port.rollback(transactionId);//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
		
	}

	@Override
	protected Object toDatabaseEntity(Object object) {
		// TODO ver bien esto
		/*com.ws.pojos.Subforo subforo = (com.ws.pojos.Subforo) object;
		ar.fiuba.redsocedu.datalayer.ws.Subforo subforoDb = new ar.fiuba.redsocedu.datalayer.ws.Subforo();
		subforoDb.setNombre(subforo.getNombre());
		subforoDb.setIdForo(subforo.getIdForo());
		subforoDb.setIdSubforo(subforo.getIdSubforo());
		subforoDb.setIdSeccion(subforo.getIdSeccion());
		subforoDb.setIdSubforoPadre(subforo.getIdSubforoPadre());
		
		return subforoDb;*/
		
		return null;
	}

}
