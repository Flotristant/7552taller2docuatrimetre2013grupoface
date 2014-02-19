package com.ws.client;


public class UsuarioTest extends TestIntegracion {
	
	public void testGuardarUsuario(){
		String xml = "<?xml version=\"1.0\"?><WS><Usuario><username>catuffina</username><password>123456</password><activado>true</activado><habilitado>true</habilitado></Usuario></WS>";	
		this.guardarDatos(xml);
	}
		
}
