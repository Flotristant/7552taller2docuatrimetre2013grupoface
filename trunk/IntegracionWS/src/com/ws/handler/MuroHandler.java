package com.ws.handler;

import java.util.List;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.Muro;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.UsuarioQueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.MuroParser;
import com.ws.serializers.MuroSerializer;
import com.ws.serializers.NotificacionSerializer;

public class MuroHandler extends Handler {
	
	public MuroHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Muro", new MuroParser(), new MuroSerializer());
		//TODO Instanciar el query Builder
	}
	
	@Override
	public String actualizarDatos(Document doc) {
		this.parser.inicializarDocumento(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Muro muro = (Muro) parser.getEntidad();
			String query = this.queryBuilder.getAllById(muro.getMuroId());
			List<ReturnedObject> muros = null; 
			
			muros = port.query(transactionId, query);
			if(muros == null || muros.isEmpty() || muros.size() > 1) {			
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Muro muroDB = (Muro) this.toDatabaseEntity(parser.getEntidad());
			muroDB.setMuroId(muro.getMuroId());
			
			port.saveOrUpdate(transactionId, this.databaseEntityPath , muro);
	
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
		this.parser.inicializarDocumento(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Muro muro = (Muro) parser.getEntidad();
			String query = this.queryBuilder.getAllById(muro.getMuroId());
			List<ReturnedObject> muros = null; 
			muros = port.query(transactionId, query);
			if(muros == null || muros.isEmpty() || muros.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Muro removingMuro = (Muro)muros.get(0);
			port.delete(transactionId, this.databaseEntityPath, removingMuro);
			port.commit(transactionId);//if ok
		} catch(ClientTransportException e) {
			port.rollback(transactionId);//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}

	@Override
	protected Object toDatabaseEntity(Object object) {
		com.ws.pojos.Muro entidadMuro = (com.ws.pojos.Muro) object;
		Muro muro = new Muro();
		muro.setMuroId(entidadMuro.getId());
		muro.setNombre(muro.getNombre());
		return muro;	
	}
}
