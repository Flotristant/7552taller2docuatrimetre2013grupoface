package com.ws.handler;

import java.util.List;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.Mensaje;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.MensajeQueryBuilder;
import com.db.querys.UsuarioQueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.MensajeParser;
import com.ws.serializers.MensajeSerializer;
import com.ws.serializers.NotificacionSerializer;

public class MensajeHandler extends Handler {
	
	public MensajeHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Mensaje", new MensajeParser(), new MensajeSerializer());
		this.queryBuilder = new MensajeQueryBuilder();
	}
	
	@Override
	public String actualizarDatos(Document doc) {
		this.parser.inicializarDocumento(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Mensaje mensaje = (Mensaje) parser.getEntidad();
			String query = this.queryBuilder.getAllById(mensaje.getMensajeId());
			List<ReturnedObject> muros = null; 
			
			muros = port.query(transactionId, query);
			if(muros == null || muros.isEmpty() || muros.size() > 1) {			
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Mensaje mensajeDB = (Mensaje) this.toDatabaseEntity(parser.getEntidad());
			mensajeDB.setMensajeId(mensaje.getMensajeId());
			
			port.saveOrUpdate(transactionId, this.databaseEntityPath , mensaje);
	
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
			Mensaje muro = (Mensaje) parser.getEntidad();
			String query = this.queryBuilder.getAllById(muro.getMensajeId());
			List<ReturnedObject> muros = null; 
			muros = port.query(transactionId, query);
			if(muros == null || muros.isEmpty() || muros.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Mensaje removingMensaje = (Mensaje)muros.get(0);
			port.delete(transactionId, this.databaseEntityPath, removingMensaje);
			port.commit(transactionId);//if ok
		} catch(ClientTransportException e) {
			port.rollback(transactionId);//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}

	@Override
	protected Object toDatabaseEntity(Object object) {
		com.ws.pojos.Mensaje entidadMensaje = (com.ws.pojos.Mensaje) object;
		Mensaje mensaje = new Mensaje();
		mensaje.setMensajeId(entidadMensaje.getId());
		mensaje.setAutor(entidadMensaje.getAutor());
		mensaje.setContenido(entidadMensaje.getContenido());
		//TODO: SETEAR FECHA
		//mensaje.setFecha(entidadMensaje.getFecha());
		return mensaje;	
	}
}
