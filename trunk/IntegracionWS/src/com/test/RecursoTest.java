package com.test;

import org.junit.Before;
import org.junit.Test;

import com.ws.services.IntegracionWS;

public class RecursoTest {
	
IntegracionWS ws;
	
	@Before
	public void setUp() {
		ws = new IntegracionWS();
	}
	
	@Test
	public void guardarRecurso(){
		
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><descripcion>pruebaRecursoArchivo2</descripcion><ambitoId>1</ambitoId><tipo>L</tipo></Recurso></WS>";
		
		System.out.println(ws.guardarDatos(xml));
	}
	
	@Test 
	public void actualizarRecurso(){
		
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><id>1007</id><descripcion>pruebaRecursoArchivo3</descripcion><ambitoId>1</ambitoId><tipo>Lala</tipo></Recurso></WS>";
		
		System.out.println(ws.actualizarDatos(xml));
	
	}
	
	@Test
	public void recuperarRecurso (){
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><descripcion>pruebaRecursoArchivo2</descripcion></Recurso></WS>";
		System.out.println(ws.seleccionarDatos(xml));
	
	}

}
