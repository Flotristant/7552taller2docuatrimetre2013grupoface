package com.ws.handler;

import com.db.querys.UsuarioQueryBuilder;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.UsuarioSerializer;


public class UsuarioHandler extends Handler {

	public UsuarioHandler(){
		super("ar.fiuba.redsocedu.datalayer.dtos.Usuario", new UsuarioParser(), new UsuarioSerializer());
		this.queryBuilder = new UsuarioQueryBuilder();
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
		//user.setFechaNac(usuario.getFechaNacimiento());
		user.setActivado(usuario.getActivado());
		user.setHabilitado(usuario.getHabilitado());
		user.setEmail(usuario.getEmail());
		user.setPassword(usuario.getPassword());
		user.setUsername(usuario.getUsername());
		user.setId(usuario.getId());
		return user;
	}

}
