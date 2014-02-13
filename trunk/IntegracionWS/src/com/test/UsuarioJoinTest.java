package com.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Actividad;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Nota;
import ar.fiuba.redsocedu.datalayer.ws.Usuario;

import com.utils.NotificacionFactory;
import com.ws.services.IntegracionWS;

public class UsuarioJoinTest extends TestCase {
	DataService service;
	IData port;
	IntegracionWS ws;	
	Usuario usuario;
	Actividad actividad;
	List<Nota> notas;

	@Before
	public void setUp() throws Exception {
		ws = new IntegracionWS();
		service = new DataService();
		port = service.getDataPort();
		
		usuario = new Usuario();
		Long user_id = TestHelper.guardarDatos(usuario, "ar.fiuba.redsocedu.datalayer.dtos.Usuario", service, port);
		usuario.setId(user_id);
		
		actividad = new Actividad();
		Long actividad_id = TestHelper.guardarDatos(actividad, "ar.fiuba.redsocedu.datalayer.dtos.Actividad", service, port);
		actividad.setActividadId(actividad_id);
		actividad.setId(actividad_id);
		
		notas = new ArrayList<Nota>();
		Nota nota = new Nota();
		nota.setUsuarioId(usuario.getId());
		nota.setActividadId(actividad_id);
		Long nota_id = TestHelper.guardarDatos(nota, "ar.fiuba.redsocedu.datalayer.dtos.Nota", service, port);
		nota.setId(nota_id);
		notas.add(nota);
		
		nota = new Nota();
		nota.setUsuarioId(usuario.getId());
		nota.setId(nota_id);
		nota.setActividadId(actividad_id);
		notas.add(nota);
	}
	
	@After 
	public void tearDown() {
		if (usuario != null) {
			TestHelper.borrarDatos(usuario, "ar.fiuba.redsocedu.datalayer.dtos.Usuario", service, port);
		}
		if (notas != null) {
			for(Nota nota: notas) {
				TestHelper.borrarDatos(nota, "ar.fiuba.redsocedu.datalayer.dtos.Nota", service, port);	
			}
		}
	}
	
	@Test
	public void testObtenerTodasLasNotasDeUnUsuario() {
		Assert.assertTrue(usuario.getId() > 0);
		String xml = "<WS><Nota><join><Usuario><id>"+ usuario.getId().toString() + "</id></Usuario></join></Nota></WS>";

		String rdo = ws.seleccionarDatos(xml);
		System.err.println(rdo);
		Assert.assertFalse(rdo.contains(NotificacionFactory.Error().getMensaje()) || rdo.contains(xml));
	}
}
