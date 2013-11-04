package com.ws.handler;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import com.db.querys.UsuarioQueryBuilder;
import com.ws.parsers.UsuarioParser;
import com.ws.pojos.Usuario;
import com.ws.tags.UsuarioTags;

public class UsuarioHandler extends Handler {
	
	
	public UsuarioHandler() {
		this.queryBuilder = new UsuarioQueryBuilder();
	}
	
	@Override
	public String guardarDatos(Document doc) {
		
		UsuarioParser parser = new UsuarioParser(doc);
		Usuario usuario = parser.getEntidadUsuario();
		
		//service = new DataService();
		//IData port = service.getDataPort();
		//port.beginTransaccion();
		//port.saveOrUpdate("Usuario",usuario);
		//port.commit //if ok
		//port.rollback()//if not
		
		
		return null;	
	}

	@Override
	public String actualizarDatos(Document doc) {
		
		UsuarioParser parser = new UsuarioParser(doc);
		//service = new DataService();
		//IData port = service.getDataPort();
		//port.beginTransaccion();
		String query = this.queryBuilder.getAllById(parser.getIdUsuario());
		Usuario usuario = null;
		//usuario =port.query(query);
		if(usuario == null) {
			//TODO: return an error message
			return "";
		}
		usuario = parser.getEntidadUsuario();
		usuario.setUsuarioId(Long.parseLong(parser.getIdUsuario()));
		
		
		//port.saveOrUpdate("Usuario",usuario);
		//port.commit //if ok
		//port.rollback()//if not
		
		
		return null;
	}

	@Override
	public String borrarDatos(Document doc) {
		Map<String, String> campos = getCampos(doc);
		//service = new DataService();
		//IData port = service.getDataPort();
		//port.beginTransaccion();
		String query = this.queryBuilder.getAllById(campos.get(UsuarioTags.ID_TAG));
		List usuarios = null; 
		//=port.query(query);
		if(usuarios == null || usuarios.isEmpty() || usuarios.size() > 1) {
			//TODO: return an error message
			return "";
		}
		Usuario removingUsuario = (Usuario)usuarios.get(0);
		//port.delete(Usuario.class, removingUsuario);
		//port.commit //if ok
		//port.rollback()//if not
		
		return "";
	}

	@Override
	public String seleccionarDatos(Document doc) {
		Map<String, String > campos = this.getCampos(doc);
		String query = this.queryBuilder.getAllByAttributes(campos);
		
		return query;
	}
	
	
	protected Map<String, String> getCampos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		return parser.obtenerCampos();
	}

}
