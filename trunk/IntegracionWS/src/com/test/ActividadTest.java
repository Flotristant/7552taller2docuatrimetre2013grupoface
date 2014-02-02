package com.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Actividad;
import ar.fiuba.redsocedu.datalayer.ws.Ambito;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;

import com.utils.NotificacionFactory;
import com.ws.services.IntegracionWS;

public class ActividadTest {
	Ambito ambito;
	
	DataService service;
	IData port;
	IntegracionWS ws;
	Actividad actividad;
	
	@Before 
	public void setUp() {
		ws = new IntegracionWS();
		service = new DataService();
		port = service.getDataPort();

	}
	
	@Test
	public void guardarActividad() {
		String xml = "<?xml version=\"1.0\"?><WS><Actividad>" +
		"<nombre>El mago asesino</nombre>" +
		"<tipo>Individual</tipo>" +
		"<descripcion>nada q ver nada q oler</descripcion>" +
		"<fechaInicio>111111</fechaInicio>" +
		"<fechaFin>121212</fechaFin>" +
		"</Actividad></WS>";
		
		String mje = ws.guardarDatos(xml);
		System.out.println(mje);
		Assert.assertTrue(mje.contains(NotificacionFactory.Exito().getMensaje()));
	}
	
	@Test
	public void actualizarActividad() {
		String xml = "<WS><Actividad><id>49</id>" +
		"<nombre>Modifico</nombre>" +
		"<tipo>Individual</tipo>" +
		"<descripcion>Cabio descripción por segunda vez.</descripcion>" +
		"<fechaInicio>111111</fechaInicio>" +
		"<fechaFin>121212</fechaFin>" +
		"</Actividad></WS>";
		String mje = ws.actualizarDatos(xml);
		System.out.println(mje);
		Assert.assertTrue(mje.contains(NotificacionFactory.Exito().getMensaje()));

	}

	@Test
	public void guardarActividadConAmbito() {
		ambito = new Ambito();
		Long id_ambito = TestHelper.guardarDatos(ambito, "ar.fiuba.redsocedu.datalayer.dtos.Ambito", service, port);
		ambito.setAmbitoId(id_ambito);
		ambito.setId(id_ambito);
		
		String xml = "<?xml version=\"1.0\"?><WS><Actividad><nombre>Actividad con ambito</nombre>" +
					"<tipo>Individual</tipo><ambitoSuperiorId>" + id_ambito.toString() + "</ambitoSuperiorId>" +
					"<descripcion>SE prueba guarar una actividad con un ambito superior</descripcion>" +
					"<fechaInicio>111111</fechaInicio><fechaFin>121212</fechaFin></Actividad></WS>";
		String mje = ws.guardarDatos(xml);
		System.out.println(mje);
		Assert.assertTrue(mje.contains(NotificacionFactory.Exito().getMensaje()));
	} 
	
	
}
