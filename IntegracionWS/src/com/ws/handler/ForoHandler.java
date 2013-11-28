package com.ws.handler;

import org.w3c.dom.Document;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.ForoParser;
import com.ws.pojos.Foro;
import com.ws.serializers.NotificacionSerializer;

public class ForoHandler extends Handler{

	@Override
	public String guardarDatos(Document doc) {
		ForoParser parser = new ForoParser(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try{
			port.beginTransaction(transactionId);
			Foro foro = this.toDatabaseForo(parser.getEntidadForo());
			port.saveOrUpdate(transactionId, "ar.fiuba.redsocedu.datalayer.dtos.Foro", foro);
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
		// TODO Auto-generated method stub
		return null;
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
	
	public Foro toDatabaseForo(com.ws.pojos.Foro foro) {
//		ar.fiuba.redsocedu.datalayer.ws.Foro dbForo = new ar.fiuba.redsocedu.datalayer.ws.Foro();
//		dbForo.setId(foro.getId());
//		dbForo.setNombre(foro.getNombre);
		return foro;
	}
}
