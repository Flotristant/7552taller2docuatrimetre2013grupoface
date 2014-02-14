package com.test;

import org.junit.Before;
import org.junit.Test;

import com.ws.services.IntegracionWS;

public class EncuestaTest {
	
	IntegracionWS ws;
	
	@Before
	public void setUp() {
		ws = new IntegracionWS();
	}
	
	@Test
	public void guardarEncuesta(){
		
		String xml = "<?xml version=\"1.0\"?><WS><Encuesta><preguntas>preguntas lala otro ejemplo</preguntas><evaluada>1</evaluada><recursoId>1026</recursoId></Encuesta></WS>";
		
		System.out.println(ws.guardarDatos(xml));
		
	}
	
	
	@Test
	public void seleccionarEncuesta(){
		String xml = "<?xml version=\"1.0\"?><WS><Encuesta><preguntas>preguntas lala otro ejemplo</preguntas></Encuesta></WS>";
		System.out.println(ws.seleccionarDatos(xml));
		
	}

}
