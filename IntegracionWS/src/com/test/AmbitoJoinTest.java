package com.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Actividad;
import ar.fiuba.redsocedu.datalayer.ws.Ambito;
import ar.fiuba.redsocedu.datalayer.ws.Cartelera;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.Foro;
import ar.fiuba.redsocedu.datalayer.ws.IData;

import com.utils.NotificacionFactory;
import com.ws.services.IntegracionWS;

public class AmbitoJoinTest {

	Ambito ambito;
	List<Foro> foros;
	List<Cartelera> carteleras;
	List<Actividad> actividades;
	
	DataService service;
	IData port;
	IntegracionWS ws;
	
	@Before 
	public void setUp() {
		ws = new IntegracionWS();
		service = new DataService();
		port = service.getDataPort();

		ambito = new Ambito();
		Long id_ambito = TestHelper.guardarDatos(ambito, "ar.fiuba.redsocedu.datalayer.dtos.Ambito", service, port);
		ambito.setAmbitoId(id_ambito);
		ambito.setId(id_ambito);

	}
	
	@After
	public void tearDown() {
		if (foros != null) {
			for (Foro foro: foros) {
				TestHelper.borrarDatos(foro, "ar.fiuba.redsocedu.datalayer.dtos.Foro", service, port);	
			}
			
		}
		
		if (carteleras != null) {
			for(Cartelera cartelera: carteleras ) {
				TestHelper.borrarDatos(cartelera, "ar.fiuba.redsocedu.datalayer.dtos.Cartelera", service, port);
			}
		}
		
		if (actividades != null) {
			for(Actividad actividad: actividades ) {
				TestHelper.borrarDatos(actividad, "ar.fiuba.redsocedu.datalayer.dtos.Actividad", service, port);
			}
		}
		
		if (ambito != null) {
			TestHelper.borrarDatos(ambito, "ar.fiuba.redsocedu.datalayer.dtos.Ambito", service, port);
		}
			
	}
	
	@Test
	public void todosLosForosDelAmbito() {
		
		foros = new ArrayList<Foro>();
		Foro foro = new Foro();
		foro.setAmbitoId(ambito.getId());
		foro.setNombre("Foro 1");
		foros.add(foro);
		Long foro_id = TestHelper.guardarDatos(foro, "ar.fiuba.redsocedu.datalayer.dtos.Foro", service, port);
		foro.setId(foro_id);
		foro = new Foro();
		foro.setAmbitoId(ambito.getId());
		foro.setNombre("Foro 2");
		foros.add(foro);
		foro_id = TestHelper.guardarDatos(foro, "ar.fiuba.redsocedu.datalayer.dtos.Foro", service, port);
		foro.setId(foro_id);
		
		String xml = "<WS><Foro><join><Ambito><ambitoId>"+ ambito.getId().toString() + "</ambitoId></Ambito></join></Foro></WS>";
		String rdo = ws.seleccionarDatos(xml);
		System.err.println(rdo);
		Assert.assertFalse(rdo.contains(NotificacionFactory.Error().getMensaje()));
	}
	
	@Test
	public void todasLasCartelerasDelAmbito() {
		
		carteleras = new ArrayList<Cartelera>();
		Cartelera cartelera = new Cartelera();
		cartelera.setAmbitoId(ambito.getId());
		cartelera.setNombre("Cartelera 1");
		carteleras.add(cartelera);
		Long cartelera_id = TestHelper.guardarDatos(cartelera, "ar.fiuba.redsocedu.datalayer.dtos.Cartelera", service, port);
		cartelera.setCarteleraId(cartelera_id);
		cartelera = new Cartelera();
		cartelera.setAmbitoId(ambito.getId());
		cartelera.setNombre("Cartelera 2");
		carteleras.add(cartelera);
		cartelera_id = TestHelper.guardarDatos(cartelera, "ar.fiuba.redsocedu.datalayer.dtos.Cartelera", service, port);
		cartelera.setCarteleraId(cartelera_id);
		
		String xml = "<WS><Cartelera><join><Ambito><ambitoId>"+ ambito.getId().toString() + "</ambitoId></Ambito></join></Cartelera></WS>";
		String rdo = ws.seleccionarDatos(xml);
		System.err.println(rdo);
		Assert.assertFalse(rdo.contains(NotificacionFactory.Error().getMensaje()));
	}
	
}
