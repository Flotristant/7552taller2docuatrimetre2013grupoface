package com.ws.handler;

import java.util.List;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.MuroParser;
import com.ws.parsers.UsuarioParser;
import com.ws.pojos.Muro;
import com.ws.serializers.NotificacionSerializer;

public class MuroHandler extends Handler {

	@Override
	public String guardarDatos(Document doc) {
		MuroParser parser = new MuroParser(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try{
			port.beginTransaction(transactionId);
			Muro muro = this.toDatabaseMuro(parser.getEntidadMuro());
			port.saveOrUpdate(transactionId, "ar.fiuba.redsocedu.datalayer.dtos.Foro", muro);
			port.commit(transactionId);
		}
		catch(ClientTransportException e) {
			port.rollback(transactionId);
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());	
	}

	@Override
	public String actualizarDatos(Document doc) {
		MuroParser parser = new MuroParser(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
//			port.beginTransaction(transactionId);
//			String query = this.queryBuilder.getAllById(parser.getEntidadMuro());
//			List<ReturnedObject> usuarios = null; 
//			
//			usuarios = port.query(transactionId, query);
//			if(usuarios == null || usuarios.isEmpty() || usuarios.size() > 1) {			
//				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
//			}
//			Usuario usuario = this.toDatabaseUser(parser.getEntidadUsuario());
//			usuario.setUsuarioId(parser.getIdUsuario());
//			
//			port.saveOrUpdate("ar.fiuba.redsocedu.datalayer.dtos.Usuario",usuario);
//	
//			port.commit(transactionId);
			
		}
		catch(ClientTransportException e) {
			port.rollback(transactionId);
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());

	}

	@Override
	public String borrarDatos(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String seleccionarDatos(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Muro toDatabaseMuro(Muro entidadMuro) {
		// TODO Auto-generated method stub
		return null;
	}

}
