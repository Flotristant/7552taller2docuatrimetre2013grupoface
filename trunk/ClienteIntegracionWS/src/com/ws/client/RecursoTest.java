package com.ws.client;


public class RecursoTest extends TestIntegracion {

	
	public void testGuardarRecurso(){
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><descripcion>Recurso prueba para Archivo 11:26 noche</descripcion><ambitoId>1</ambitoId><tipo>L</tipo></Recurso></WS>";
		this.guardarDatos(xml);	
	}
	
	public void testSeleccionarRecurso(){
		String xml = "<?xml version=\"1.0\"?><WS><Recurso><descripcion>Recurso prueba para Archivo 11:26 noche</descripcion></Recurso></WS>";
		this.seleccionarDatos(xml);
	}
}
