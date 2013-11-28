package com.ws.handler;

import java.util.List;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.UsuarioSerializer;


public class UsuarioHandler extends Handler {
	
	//private static final Logger log = Logger.getLogger(UsuarioHandler.class);

	public UsuarioHandler(){
		super("ar.fiuba.redsocedu.datalayer.dtos.Usuario", new UsuarioParser(), new UsuarioSerializer());
	}

	@Override
	public String actualizarDatos(Document doc) {	
		this.parser.setDoc(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Usuario usuario = (Usuario) parser.getEntidad();
			String query = this.queryBuilder.getAllById(usuario.getUsuarioId());
			List<ReturnedObject> usuarios = null; 
			
			usuarios = port.query(transactionId, query);
			if(usuarios == null || usuarios.isEmpty() || usuarios.size() > 1) {			
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			ar.fiuba.redsocedu.datalayer.ws.Usuario usuarioDB = (ar.fiuba.redsocedu.datalayer.ws.Usuario) this.toDatabaseEntity(usuario.getUsuarioId());
			usuario.setUsuarioId(usuario.getUsuarioId());
			
			port.saveOrUpdate(transactionId, this.databaseEntityPath, usuarioDB);
	
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
		this.parser.setDoc(doc);
		Long transactionId = IdGenerator.generateTransactionId();
		try {
			port.beginTransaction(transactionId);
			Usuario usuario = (Usuario) parser.getEntidad();
			String query = this.queryBuilder.getAllById(usuario.getUsuarioId());
			List<ReturnedObject> usuarios = null; 
			usuarios = port.query(transactionId, query);
			if(usuarios == null || usuarios.isEmpty() || usuarios.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Usuario removingUsuario = (Usuario)usuarios.get(0);
			port.delete(transactionId, this.databaseEntityPath, removingUsuario);
			port.commit(transactionId);//if ok
		} catch(ClientTransportException e) {
			port.rollback(transactionId);//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}
		
	/**
	 * Este método transforma el usuario de la capa de Negocio en un usuario de la capa de BD.
	 * @param usuario
	 * @return
	 */
	@Override
	public Object toDatabaseEntity(Object object) {
		com.ws.pojos.Usuario usuario = (com.ws.pojos.Usuario) object;
		ar.fiuba.redsocedu.datalayer.ws.Usuario user = new ar.fiuba.redsocedu.datalayer.ws.Usuario();
		user.setNombre(usuario.getNombre());
		user.setApellido(usuario.getApellido());
		user.setPadron(usuario.getPadron());
		user.setFechaNac(usuario.getFechaNac());
		user.setActivado(usuario.isActivado());
		user.setHabilitado(usuario.isHabilitado());
		user.setEmail(usuario.getEmail());
		user.setPassword(usuario.getPassword());
		user.setUsername(usuario.getUsername());
		user.setUsuarioId(usuario.getUsuarioId());
		return user;
	}

}
