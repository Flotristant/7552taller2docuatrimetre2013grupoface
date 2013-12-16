package com.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Cartelera;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Noticia;

import com.ws.services.IntegracionWS;

public class CarteleraJoinTest {

	DataService service;
	IData port;
	IntegracionWS ws;
	
	List<Noticia> noticias;
	Cartelera cartelera;
	
	@Before 
	public void setUp() {
		ws = new IntegracionWS();
		service = new DataService();
		port = service.getDataPort();
		
		cartelera = new Cartelera();
		cartelera.setNombre("Cartelera 1");
		Long cartelera_id = TestHelper.guardarDatos(cartelera, "ar.fiuba.redsocedu.datalayer.dtos.Cartelera", service, port);
		cartelera.setCarteleraId(cartelera_id);
		cartelera.setId(cartelera_id);
	}
	
	@After
	public void tearDown() {
		if (noticias != null) {
			for (Noticia noticia: noticias) {
				TestHelper.borrarDatos(noticia, "ar.fiuba.redsocedu.datalayer.dtos.Noticia", service, port);	
			}
			
		}

	}
	
	@Test
	public void todasLasNoticiasDeCartelera() {
		Noticia noticia = new Noticia();
		noticia.setCarteleraId(cartelera.getId());
		noticia.setContenido("Texto de la noticia 1");
		noticia.setTitulo("Titulo de la noticia 1");
		Long noticia_id = TestHelper.guardarDatos(noticia, "ar.fiuba.redsocedu.datalayer.dtos.Noticia", service, port);
		noticia.setId(noticia_id);
		noticia = new Noticia();
		noticia.setCarteleraId(cartelera.getId());
		noticia.setContenido("Texto de la noticia 1");
		noticia.setTitulo("Titulo de la noticia 1");
		noticia_id = TestHelper.guardarDatos(noticia, "ar.fiuba.redsocedu.datalayer.dtos.Noticia", service, port);
		noticia.setId(noticia_id);
		
		String xml = "<WS><Noticia><join><Cartelera><carteleraId>"+ cartelera.getId().toString() + "</carteleraId></Cartelera></join></Noticia></WS>";
		String rdo = ws.seleccionarDatos(xml);
		System.err.println(rdo);
	}
}
