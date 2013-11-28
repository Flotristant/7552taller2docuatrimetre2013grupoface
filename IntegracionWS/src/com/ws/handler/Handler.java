package com.ws.handler;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.QueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.Parser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.Serializer;

public abstract class Handler {
	
	QueryBuilder queryBuilder;	
	DataService service;
	IData port;
	Parser parser;
	Serializer serializer;
	protected String databaseEntityPath;
	
	public Handler(String databaseEntityPath, Parser parser, Serializer serializer){
		this.databaseEntityPath = databaseEntityPath;
		this.service = new DataService();
		this.port = service.getDataPort();
		this.parser = parser;
		this.serializer = serializer;
	}
	
	public String guardarDatos(Document doc) {
		this.parser.inicializarDocumento(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try{
			port.beginTransaction(transactionId);
			Object obj = this.toDatabaseEntity(parser.getEntidad());
			port.saveOrUpdate(transactionId, this.databaseEntityPath, obj);
			port.commit(transactionId);
		}
		catch(ClientTransportException e) {
			port.rollback(transactionId);
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}
	
	public String seleccionarDatos(Document doc) {
		Map<String, String > campos = this.getCampos(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		String query = this.queryBuilder.getAllByAttributes(campos);	
		try {
		port.beginTransaction(transactionId);
		List<ReturnedObject> objects = null; 
		objects = port.query(transactionId, query);
		if(objects == null || objects.isEmpty()) {
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.sinResultados());
		}
		port.commit(transactionId);
		
		return this.serializer.getXMLfromPojo(objects);
		}catch (ClientTransportException e) {
			port.rollback(transactionId);//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
	}
	
	protected Map<String, String> getCampos(Document doc) {
		this.parser.inicializarDocumento(doc);
		return parser.obtenerCampos();
	}
	
	public abstract String actualizarDatos(Document doc);
	public abstract String borrarDatos(Document doc);

	
	protected abstract Object toDatabaseEntity(Object object);
}
