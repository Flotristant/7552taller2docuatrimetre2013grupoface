package com.ws.handler;


import java.util.Map;
import org.w3c.dom.Document;

import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.db.querys.UsuarioQueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.MockCache;
import com.utils.NotificacionFactory;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.NotificacionSerializer;



public class UsuarioHandlerMock extends Handler {
	
	public UsuarioHandlerMock() {
		//super();
		//this.queryBuilder = new UsuarioQueryBuilder();
	}
	
	@Override
	public String guardarDatos(Document doc) {
		
		MockCache.guardarUsuario(doc);
		
//		UsuarioParser parser = new UsuarioParser(doc);
//		try{
//			port.beginTransaction();
//			Usuario usuario = this.toDatabaseUser(parser.getEntidadUsuario());
//			port.saveOrUpdate("ar.fiuba.redsocedu.datalayer.dtos.Usuario",usuario);
//			port.commit();
//		}
//		catch(ClientTransportException e) {
//			port.rollback();
//			return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
//		}
	
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());	
		
		
	}

	@Override
	public String actualizarDatos(Document doc) {
		MockCache.guardarUsuario(doc);
		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
	}

	@Override
	public String borrarDatos(Document doc) {
		
		if(MockCache.borrarUsuario(doc)) return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
		else return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.sinResultados());
	}

	@Override
	public String seleccionarDatos(Document doc) {
		
		String salida = MockCache.seleccionarUsuario(doc);
		
		if (salida == null) return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.sinResultados());
		else return salida;
		
//		
//		Usuario miusuario = new Usuario();
//		
//		miusuario.setActivado(true);
//		miusuario.setApellido("Perez");
//		miusuario.setNombre("Alfonso");
//		miusuario.setEmail("ap@fiuba.edu.ar");
//		miusuario.setPadron("1234");
//		miusuario.setPassword("123456");
//		miusuario.setHabilitado(true);
//		
//		XMLGregorianCalendar fecha = new XMLGregorianCalendarImpl();
//		fecha.setYear(1986);
//		fecha.setMonth(5);
//		fecha.setDay(5);
//		
//		miusuario.setFechaNac(fecha);
//		miusuario.setUsername("Pepe");
//		miusuario.setUsuarioId(12L);
//		
//		return UsuarioSerializer.getXMLfromPojo(miusuario);
	}
	
//	@Override
//	public String seleccionarDatos(Document doc) {
//		UsuarioParser parser = new UsuarioParser(doc);
//		Usuario miusuario  = parser.getEntidadUsuario();
//
//		miusuario.setEmail("ap@fiuba.edu.ar");
//		miusuario.setPadron("1234");
//		
//		XMLGregorianCalendar fecha = new XMLGregorianCalendarImpl();
//		fecha.setYear(1986);
//		fecha.setMonth(5);
//		fecha.setDay(5);
//		
//		miusuario.setFechaNac(fecha);
//		miusuario.setUsuarioId(12L);
//		
//		return UsuarioSerializer.getXMLfromPojo(miusuario);
//	}
	
	
	protected Map<String, String> getCampos(Document doc) {
		UsuarioParser parser = new UsuarioParser(doc);
		return parser.obtenerCampos();
	}
	
	public Usuario toDatabaseUser(com.ws.pojos.Usuario usuario) {
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