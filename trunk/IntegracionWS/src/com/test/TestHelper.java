package com.test;



import ar.fiuba.redsocedu.datalayer.ws.DataException;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
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
		} catch (DataException e) {
			try{
				port.rollback(transactionId);
				return 0L;
			}
			catch(DataException e1)
			{
				return 0L;
			}
		}
	}
	
	
	public static void borrarDatos(Object o, String databaseEntityPath, DataService service, IData port) {
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Object obj = o;
			port.delete(transactionId, databaseEntityPath, obj);
			port.commit(transactionId);
		} catch (DataException e) {
			try{
				port.rollback(transactionId);
			}
			catch(DataException e1){
				
			}
		}
	}
}
