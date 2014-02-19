package com.ws.client;

public class EncuestaTest extends TestIntegracion{
	
	
	public void guardarEncuesta(){
		String xml = "<?xml version=\"1.0\"?><WS><Encuesta><preguntas>preguntas lala otro ejemplo</preguntas><evaluada>1</evaluada><recursoId>1029</recursoId></Encuesta></WS>";
		this.guardarDatos(xml);
	}
	
	public void seleccionarEncuesta(){
		String xml = "<?xml version=\"1.0\"?><WS><Encuesta><recursoId>1029</recursoId></Encuesta></WS>";
		this.seleccionarDatos(xml);
	}

}
