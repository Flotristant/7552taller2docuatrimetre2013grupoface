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
		String xml = createSelectUserXML();
		integracionWS.seleccionarDatos(xml);
	}
	
	private String createSelectUserXML() {
		return "<?xml version=\"1.0\"?><WS><Usuario><username>usuario_prueba</username><password>123</password><activado>True</activado><habilitado>True</habilitado></Usuario></WS>";
	}
	
	@Test
	public void saveOneUserTest() {
		IntegracionWS integracionWS = new IntegracionWS();
		String xml = createCreateUserXML();
		integracionWS.guardarDatos(xml);
	}
	
	private String createCreateUserXML() {
		return "<?xml version=\"1.0\"?><WS><Usuario><username>usuario_prueba</username><password>123</password><activado>true</activado><habilitado>true</habilitado></Usuario></WS>";
	}
	
	@Test
	public void updateOneUserTest() {
		IntegracionWS integracionWS = new IntegracionWS();
		String xml = createUpdateUserXML();
		integracionWS.actualizarDatos(xml);
	}
	
	private String createUpdateUserXML() {
		return "<?xml version=\"1.0\"?><WS><Usuario><id>1</id><username>usuario_prueba3</username><password>1234</password><activado>true</activado><habilitado>true</habilitado></Usuario></WS>";
		
	}
	


}
