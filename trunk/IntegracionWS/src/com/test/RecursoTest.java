package com.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.utils.NotificacionFactory;
import com.ws.services.IntegracionWS;

public class RecursoTest extends TestCase {
	
IntegracionWS ws;
	
	@Before
	public void setUp() {
		ws = new IntegracionWS();
	}
	
	@Test
	public void testGuardarRecurso(){
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><descripcion>recursoParaArchivo</descripcion><ambitoId>1</ambitoId><tipo>L</tipo></Recurso></WS>";
		String rdo = ws.guardarDatos(xml);
		Assert.assertTrue(rdo, rdo.contains(NotificacionFactory.ExitoGuardado("1").getMensaje()));
	}
	
	@Test 
	public void testActualizarRecurso(){
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><id>1013</id><descripcion>pruebaRecursoArchivoLala</descripcion><ambitoId>1</ambitoId><tipo>Lala</tipo></Recurso></WS>";
		String rdo = ws.actualizarDatos(xml);
		Assert.assertFalse(rdo, rdo.contains(NotificacionFactory.Error().getMensaje()));
	}
	
	@Test
	public void testRecuperarRecurso (){
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><ambitoId>1</ambitoId></Recurso></WS>";
		String rdo = ws.seleccionarDatos(xml);
		Assert.assertFalse(rdo, rdo.contains(NotificacionFactory.Error().getMensaje()));		
	}

}
