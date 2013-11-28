package com.ws.handler;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.Parser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.Serializer;

public class SubforoHandler extends Handler {

	public SubforoHandler(String databaseEntityPath, Parser parser,
			Serializer serializer) {
		super(databaseEntityPath, parser, serializer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String actualizarDatos(Document doc) {
		this.parser.setDoc(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			
			//TODO
			//String query = this.queryBuilder.getAllById(parser.getIdSubforo());
			List<ReturnedObject> foros = null; 
			
			//foros = port.query(transactionId, query);
			if(foros == null || foros.isEmpty() || foros.size() > 1) {			
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			//TODO convertir al foro de negocio en el foro de base de datos
			//Foro foro = this.toDatabaseUser(parser.getEntidadForo());
			//foro.setForoId(parser.getIdForo());
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
		this.parser.setDoc(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			/*port.beginTransaction(transactionId);
			String query = this.queryBuilder.getAllById(parser.getIdSubforo());
			List<ReturnedObject> subforos = null; 
			subforos = port.query(transactionId, query);
			if(subforos == null || subforos.isEmpty() || subforos.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Subforo removingUsuario = (Subforo)subforos.get(0);
			port.delete("ar.fiuba.redsocedu.datalayer.dtos.Usuario",removingUsuario);
			port.commit(transactionId);//if ok*/
		} catch(ClientTransportException e) {
			port.rollback(transactionId);//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
		
	}

	protected Map<String, String> getCampos(Document doc) {
		this.parser.setDoc(doc);
		return parser.obtenerCampos();
	}

	@Override
	protected Object toDatabaseEntity(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
