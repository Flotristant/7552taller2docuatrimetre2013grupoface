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
		Map<String, String > campos = parser.obtenerCampos();
		Usuario usuario = this.convertirEntidadUsuario(campos);
		
		//TODO invocaci�n al WS de saveOrUpdate de bbdd
		//port.saveOrUpdate("Usuario",usuario);
		
		return null;	
	}

	@Override
	public String actualizarDatos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		Map<String, String > campos = parser.obtenerCampos();
		Usuario usuario = this.convertirEntidadUsuario(campos);
		usuario.setId(campos.get(UsuarioTags.ID_TAG));
		
		//TODO invocaci�n al WS de saveOrUpdate de bbdd
		//port.saveOrUpdate("Usuario",usuario);
		
		
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
	
	
	private Usuario convertirEntidadUsuario(Map<String, String > campos){
		Usuario usuario = new Usuario();
		usuario.setUsername(campos.get(UsuarioTags.USERNANME_TAG));
		usuario.setPassword (campos.get(UsuarioTags.PASSWORD_TAG));
		usuario.setNombre(campos.get(UsuarioTags.NOMBRE_TAG));
		usuario.setApellido(campos.get(UsuarioTags.APELLIDO_TAG));
		usuario.setPadron(campos.get(UsuarioTags.PADRON_TAG));
		usuario.setEmail(campos.get(UsuarioTags.EMAIL_TAG));
		usuario.setFechaNacimiento(campos.get(UsuarioTags.FECHANAC_TAG));
		usuario.setHabilitado(campos.get(UsuarioTags.HABILITADO_TAG));
		usuario.setActivado(campos.get(UsuarioTags.ACTIVADO_TAG));
		
		return usuario;
		
	}

	
	protected Map<String, String> getCampos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		return parser.obtenerCampos();
	}

}
