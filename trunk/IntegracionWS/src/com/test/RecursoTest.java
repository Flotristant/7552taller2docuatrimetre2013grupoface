package com.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.utils.NotificacionFactory;
import com.ws.services.IntegracionWS;

public class RecursoTest {
	
IntegracionWS ws;
	
	@Before
	public void setUp() {
		ws = new IntegracionWS();
	}
	
	@Test
	public void guardarRecurso(){
		
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><descripcion>pruebaRecursoArchivoPrueba</descripcion><ambitoId>1</ambitoId><tipo>L</tipo></Recurso></WS>";
		
		System.out.println(ws.guardarDatos(xml));
	}
	
	@Test 
	public void actualizarRecurso(){
		
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><id>1013</id><descripcion>pruebaRecursoArchivoLala</descripcion><ambitoId>1</ambitoId><tipo>Lala</tipo></Recurso></WS>";
		
		String rdo = ws.actualizarDatos(xml);
		Assert.assertFalse(rdo.contains(NotificacionFactory.Error().getMensaje()));
		System.out.println(rdo);
	
	}
	
	@Test
	public void recuperarRecurso (){
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><id>1013</id></Recurso></WS>";
		String rdo = ws.seleccionarDatos(xml);
		Assert.assertFalse(rdo.contains(NotificacionFactory.Error().getMensaje()));		
		System.out.println(rdo);
	
	}

}
