package com.ws.handler;

import java.util.Map;

import javax.xml.bind.ParseConversionEvent;

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
		
		//TODO invocación al WS de saveOrUpdate de bbdd
		//port.saveOrUpdate("Usuario",usuario);
		
		return null;	
	}

	@Override
	public String actualizarDatos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		Map<String, String > campos = parser.obtenerCampos();
		Usuario usuario = this.convertirEntidadUsuario(campos);
		usuario.setId(campos.get(UsuarioTags.ID_TAG));
		
		//TODO invocación al WS de saveOrUpdate de bbdd
		//port.saveOrUpdate("Usuario",usuario);
		
		
		return null;
	}

	@Override
	public String borrarDatos(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String seleccionarDatos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		Map<String, String > campos = parser.obtenerCampos();
		String query = this.queryBuilder.getAllById(campos.get(UsuarioTags.ID_TAG));
		
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

}
