package com.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.Evento;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Muro;

import com.ws.services.IntegracionWS;

public class MuroJoinTest {

	DataService service;
	IData port;
	Muro muro;
	Evento evento;
	IntegracionWS ws;
	
	@Before
	public void setUp() throws Exception {
		ws = new IntegracionWS();
		service = new DataService();
		port = service.getDataPort();

		muro = new Muro();
		muro.setNombre("Muro Integración");
		
		Long id_muro = TestHelper.guardarDatos(muro, "ar.fiuba.redsocedu.datalayer.dtos.Muro", service, port);
		muro.setId(id_muro);
		
		evento = new Evento();
		evento.setNombre("Evento muro integración");
		evento.setMuroId(id_muro);
		Long id = TestHelper.guardarDatos(evento, "ar.fiuba.redsocedu.datalayer.dtos.Evento", service, port);
		evento.setId(id);			
	}
	
	@After 
	public void tearDown() throws Exception {
		TestHelper.borrarDatos(evento, "ar.fiuba.redsocedu.datalayer.dtos.Evento", service, port);
		TestHelper.borrarDatos(muro, "ar.fiuba.redsocedu.datalayer.dtos.Muro", service, port);
	}
	 
	@Test
	public void getAllEventsFromAMuro() {
		String xml = "<WS><Evento><join><Muro><nombre>Muro Integración</nombre></Muro></join></Evento></WS>";
		
		String rdo = ws.seleccionarDatos(xml);
		System.err.println(rdo);			
	}
}
