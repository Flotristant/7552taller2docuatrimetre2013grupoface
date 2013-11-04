package com.test;

import org.junit.Before;
import org.junit.Test;

import com.ws.services.IntegracionWS;

public class UsuarioTestIntegration {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void removeTest() {
		IntegracionWS integracionWS = new IntegracionWS();
		String xml = createDeleteUserXML();
		integracionWS.eliminarDatos(xml);
	}
	
	private String createDeleteUserXML() {
		return "<?xml version=\"1.0\"?><WS><Usuario><id>1</id></Usuario></WS>";
	}
	
	@Test
	public void selectOneUserTest() {
		IntegracionWS integracionWS = new IntegracionWS();
		String xml = createDeleteUserXML();
		integracionWS.seleccionarDatos(xml);
	}
	
	
	private String createSelectUserXML() {
		return "<?xml version=\"1.0\"?><WS><Usuario><username>usuario_prueba</username></Usuario></WS>";
	}
	

}
