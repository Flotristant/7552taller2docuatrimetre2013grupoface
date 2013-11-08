package com.ws.handler;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.db.querys.UsuarioQueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.NotificacionFactory;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.UsuarioSerializer;
import com.ws.tags.UsuarioTags;

public class UsuarioHandler extends Handler {
	
	
	public UsuarioHandler() {
		super();
		this.queryBuilder = new UsuarioQueryBuilder();
	}
	
	@Override
	public String guardarDatos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		try{
			port.beginTransaction();
			Usuario usuario = parser.toDatabaseUser(parser.getEntidadUsuario());
			port.saveOrUpdate("ar.fiuba.redsocedu.datalayer.dtos.Usuario",usuario);
			port.commit();
		}
		catch(ClientTransportException e) {
			port.rollback();
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
	
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());	
	}

	@Override
	public String actualizarDatos(Document doc) {	
		UsuarioParser parser = new UsuarioParser(doc);
		try {
			port.beginTransaction();
			String query = this.queryBuilder.getAllById(parser.getIdUsuario());
			List<ReturnedObject> usuarios = null; 
			usuarios =port.query(query);
			if(usuarios == null || usuarios.isEmpty() || usuarios.size() > 1) {			
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Usuario usuario = parser.toDatabaseUser(parser.getEntidadUsuario());
			usuario.setUsuarioId(Long.parseLong(parser.getIdUsuario()));
			
			port.saveOrUpdate("ar.fiuba.redsocedu.datalayer.dtos.Usuario",usuario);
			port.commit();			
		}
		catch(ClientTransportException e) {
			port.rollback();
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}

	@Override
	public String borrarDatos(Document doc) {
		Map<String, String> campos = getCampos(doc);
		try {
			port.beginTransaction();
			String query = this.queryBuilder.getAllById(campos.get(UsuarioTags.ID_TAG));
			List<ReturnedObject> usuarios = null; 
			usuarios = port.query(query);
			if(usuarios == null || usuarios.isEmpty() || usuarios.size() > 1) {
				return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
			}
			Usuario removingUsuario = (Usuario)usuarios.get(0);
			port.delete("ar.fiuba.redsocedu.datalayer.dtos.Usuario",removingUsuario);
			port.commit();//if ok
		} catch(ClientTransportException e) {
			port.rollback();//if not
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
		}
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}

	@Override
	public String seleccionarDatos(Document doc) {
		Map<String, String > campos = this.getCampos(doc);
		String query = this.queryBuilder.getAllByAttributes(campos);
		
		List<ReturnedObject> usuarios = null; 
		usuarios = port.query(query);
		if(usuarios == null || usuarios.isEmpty()) {
			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.sinResultados());
		}
		return UsuarioSerializer.getXMLfromPojo(usuarios);
	}
	
	
	protected Map<String, String> getCampos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		return parser.obtenerCampos();
	}

}
