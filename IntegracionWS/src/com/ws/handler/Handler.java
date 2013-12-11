package com.ws.handler;


import java.util.List;
import java.util.Map;

import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.QueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.Parser;
import com.ws.pojos.Pojo;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.Serializer;

public abstract class Handler {

	QueryBuilder queryBuilder;
	DataService service;
	IData port;
	Parser parser;
	Serializer serializer;
	protected String databaseEntityPath;

	public Handler(String databaseEntityPath, Parser parser,
			Serializer serializer, QueryBuilder queryBuilder) {
		this.databaseEntityPath = databaseEntityPath;
		this.service = new DataService();
		this.port = service.getDataPort();
		this.parser = parser;
		this.serializer = serializer;
		this.queryBuilder = queryBuilder;
	}

	// for mock tests
	public Handler(Parser parser, Serializer serializer) {
		this.databaseEntityPath = "";
		this.service = null;
		this.port = null;
		this.parser = parser;
		this.serializer = serializer;
	}

	public String guardarDatos(String xml) {
		// this.parser.inicializarDocumento(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		Long idnuevo;
		try {
			port.beginTransaction(transactionId);
			Object obj = parser.getDBObject(xml);
			idnuevo = port.saveOrUpdate(transactionId, this.databaseEntityPath, obj);
			port.commit(transactionId);
		} catch (ClientTransportException e) {
			port.rollback(transactionId);
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory
					.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.ExitoGuardado(idnuevo.toString()));
	}

	public String seleccionarDatos(String xml) {
		Map<String, String> campos = this.parser.inicializarCampos(xml);
		String query;
		if(this.parser.esJoin()) {
			campos = this.parser.getJoinFields();
			query = this.queryBuilder.resolveJoin(campos);
		} else {
			query = this.queryBuilder.getAllByAttributes(campos);
		}
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			List<ReturnedObject> objects = null;
			objects = port.query(transactionId, query);
			if (objects == null || objects.isEmpty()) {
				return NotificacionSerializer
						.getXMLfromPojo(NotificacionFactory.sinResultados());
			}
			port.commit(transactionId);
 			return this.serializer.getXMLfromPojo(objects);
		} catch (ClientTransportException e) {
			port.rollback(transactionId);// if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory
					.Error());
		}
	}

	public String actualizarDatos(String xml) {
		this.parser.inicializarCampos(xml);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Pojo pojo = (Pojo) parser.getEntidadNegocio(xml);
			String query = this.queryBuilder.getAllById(pojo.getId());
			List<ReturnedObject> dbPojos = null;

			dbPojos = port.query(transactionId, query);
			if (dbPojos == null || dbPojos.isEmpty() || dbPojos.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			// Los pasos previos solo se hacen para verificar que existe el
			// objeto en la BBDD??
			Object pojoDB = this.toDatabaseEntity(pojo);
			port.saveOrUpdate(transactionId, this.databaseEntityPath, pojoDB);
			port.commit(transactionId);

		} catch (ClientTransportException e) {
			port.rollback(transactionId);
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory
					.Error());
		}

		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory
				.Exito());
	}

	public String borrarDatos(String xml) {
		this.parser.inicializarCampos(xml);
		Long transactionId = IdGenerator.generateTransactionId();
		String query = this.queryBuilder.getAllByAttributes(parser.getCampos());
		List<ReturnedObject> pojos = null;
		try {
			port.beginTransaction(transactionId);
			pojos = port.query(transactionId, query);
			if (pojos == null || pojos.isEmpty() || pojos.size() > 1) {
				return NotificacionSerializer
						.getXMLfromPojo(NotificacionFactory.Error());
			}
			port.commit(transactionId);
		} catch (ClientTransportException e) {
			port.rollback(transactionId);// if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory
					.Error());
		}
		Long transactionId2 = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId2);
			for (ReturnedObject ro : pojos) {
				port.delete(transactionId2, this.databaseEntityPath, ro);
			}
			port.commit(transactionId2);// if ok
		} catch(ClientTransportException e) {
			port.rollback(transactionId2);// if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory
					.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory
				.Exito());
	}

	public abstract Object toDatabaseEntity(Object object);
}
