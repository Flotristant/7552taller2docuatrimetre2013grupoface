package com.ws.handler;

import java.util.List;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.Tema;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.TemaParser;
import com.ws.serializers.TemaSerializer;
import com.ws.serializers.NotificacionSerializer;

public class TemaHandler extends Handler {
	
	public TemaHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Tema", new TemaParser(), new TemaSerializer());
	}
	
	@Override
	public String actualizarDatos(Document doc) {
		this.parser.inicializarDocumento(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Tema mensaje = (Tema) parser.getEntidad();
			String query = this.queryBuilder.getAllById(mensaje.getTemaId());
			List<ReturnedObject> muros = null; 
			
			muros = port.query(transactionId, query);
			if(muros == null || muros.isEmpty() || muros.size() > 1) {			
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Tema mensajeDB = (Tema) this.toDatabaseEntity(parser.getEntidad());
			mensajeDB.setTemaId(mensaje.getTemaId());
			
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
			Tema muro = (Tema) parser.getEntidad();
			String query = this.queryBuilder.getAllById(muro.getTemaId());
			List<ReturnedObject> muros = null; 
			muros = port.query(transactionId, query);
			if(muros == null || muros.isEmpty() || muros.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Tema removingTema = (Tema)muros.get(0);
			port.delete(transactionId, this.databaseEntityPath, removingTema);
			port.commit(transactionId);//if ok
		} catch(ClientTransportException e) {
			port.rollback(transactionId);//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}

	@Override
	protected Object toDatabaseEntity(Object object) {
		com.ws.pojos.Tema entidadTema = (com.ws.pojos.Tema) object;
		Tema tema = new Tema();
		tema.setTemaId(entidadTema.getId());
		tema.setNombre(entidadTema.getAutor());
		return tema;	
	}
}
