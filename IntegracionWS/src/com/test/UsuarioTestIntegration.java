package com.test;

import static org.junit.Assert.*;

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
		integracionWS.eliminarUsuario(xml);
	}
	
	private String createDeleteUserXML() {
		return "<?xml version=\"1.0\"?><WS><Usuario><id>1</id></Usuario></WS>";
	}

}
