package com.test;

import org.junit.Before;
import org.junit.Test;

import com.ws.services.IntegracionWS;

public class ActividadTest {

	IntegracionWS ws;
	
	@Before
	public void setUp() {
		ws = new IntegracionWS();
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
	}
}
