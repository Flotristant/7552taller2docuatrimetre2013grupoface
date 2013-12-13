package com.test;

import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;

public class TestHelper {

	public static Long guardarDatos(Object o, String databaseEntityPath, DataService service, IData port) {
		Long transactionId = IdGenerator.generateTransactionId();
		Long idnuevo;
		try {
			port.beginTransaction(transactionId);
			Object obj = o;
			idnuevo = port.saveOrUpdate(transactionId, databaseEntityPath, obj);
			port.commit(transactionId);
			return idnuevo;
		} catch (ClientTransportException e) {
			port.rollback(transactionId);
			return 0L;
		}
	}
	
	
	public static void borrarDatos(Object o, String databaseEntityPath, DataService service, IData port) {
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Object obj = o;
			port.delete(transactionId, databaseEntityPath, obj);
			port.commit(transactionId);
		} catch (ClientTransportException e) {
			port.rollback(transactionId);
		}
	}
}
