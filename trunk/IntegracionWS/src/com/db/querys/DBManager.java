package com.db.querys;

import java.util.List;

import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.ws.pojos.Pojo;

public class DBManager {
	public static List<ReturnedObject> seleccionarObjetos(Object o, String databaseEntityPath) throws Exception {
		DataService service = new DataService();
		IData port = service.getDataPort();
		QueryBuilder queryBuilder = new MiembroChatQueryBuilder();
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Pojo obj = (Pojo)o;
            List<ReturnedObject> objects = null;
            String query = queryBuilder.getAllById(obj.getId());
            objects = port.query(transactionId, query);
			port.commit(transactionId);
			if( objects == null || objects.isEmpty()) {
				throw new Exception("No se encontraron datos");
			}
			return objects;
		} catch (ClientTransportException e) {
			port.rollback(transactionId);
		}
		return null;
	}

	public static Long guardarObjetos(Object o, String databaseEntityPath) throws Exception {
		DataService service = new DataService();
		IData port = service.getDataPort();
		Long transactionId = IdGenerator.generateTransactionId();
		try {
            port.beginTransaction(transactionId);
            Long idnuevo = port.saveOrUpdate(transactionId, databaseEntityPath, o);
            port.commit(transactionId);
			return idnuevo;
		} catch (ClientTransportException e) {
			port.rollback(transactionId);
		}
		return null;
		
	}
}
