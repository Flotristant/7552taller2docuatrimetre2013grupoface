package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Ambito;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.Evento;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Muro;

import com.ws.services.IntegracionWS;

public class MuroJoinTest {

	DataService service;
	IData port;
	IntegracionWS ws;	
	Ambito ambito;
	Muro muro;
	Evento evento;

	
	@Before
	public void setUp() throws Exception {
		ws = new IntegracionWS();
		service = new DataService();
		port = service.getDataPort();

		ambito = new Ambito();
		Long id_ambito = TestHelper.guardarDatos(ambito, "ar.fiuba.redsocedu.datalayer.dtos.Ambito", service, port);
		ambito.setAmbitoId(id_ambito);
		ambito.setId(id_ambito);
		
		muro = new Muro();
		muro.setNombre("Muro Integración");
		muro.setAmbitoId(id_ambito);
		
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
		if (ambito != null) {
			TestHelper.borrarDatos(ambito, "ar.fiuba.redsocedu.datalayer.dtos.Ambito", service, port);	
		}
		if (evento != null) {
			TestHelper.borrarDatos(evento, "ar.fiuba.redsocedu.datalayer.dtos.Evento", service, port);	
		}
		if(muro != null) {
			TestHelper.borrarDatos(muro, "ar.fiuba.redsocedu.datalayer.dtos.Muro", service, port);	
		}
		
	}
	 
	@Test
	public void getAllEventsFromAMuro() {
		String xml = "<WS><Evento><join><Muro><id>"+ muro.getId().toString() + "</id></Muro></join></Evento></WS>";
		
		String rdo = ws.seleccionarDatos(xml);
		System.err.println(rdo);			
	}
	
	@Test
	public void getAmbitoDelMuro() {
		String xml = "<WS><Ambito><join><Muro><id>"+ muro.getId().toString() + "</id></Muro></join></Ambito></WS>";
		String rdo = ws.seleccionarDatos(xml);
		System.err.println(rdo);			
	}
}
