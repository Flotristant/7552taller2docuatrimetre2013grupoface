package com.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.utils.NotificacionFactory;
import com.ws.pojos.Mensaje;
import com.ws.serializers.MensajeSerializer;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;

public class TestIntegracionComunicacion {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMensaje() {
		// iniciar Servicio BD mock
		IntegracionWS.setMockService();
		IntegracionWS integracionWS = new IntegracionWS();

		// guardar mensaje
		Mensaje mensaje = crearMensaje();
		MensajeSerializer serializer = new MensajeSerializer();
		String resultadoTransaccion = integracionWS.guardarDatos(serializer.getXMLfromPojo(mensaje));
		Assert.assertEquals(NotificacionFactory.Exito(), resultadoTransaccion);

		// consultar mensaje por id
		// consultar mensaje por props
		// eliminar mensaje
	}

	private Mensaje crearMensaje() {
		Mensaje mensaje = new Mensaje();
		mensaje.setAutor("Pepe");
		mensaje.setContenido("Hola querido!, como estas??");
		mensaje.setFecha("10/02/2013");

		return mensaje;
	}

	private String getMensajeNegocioXML(Mensaje mensaje) {
		String xml = "<?xml version=\"1.0\"?><WS><Mensaje><autor>"+mensaje.getAutor()+
				"</autor><contenido>"+mensaje.getContenido()+"</contenido><fecha>"+
				mensaje.getFecha()+"</fecha></Mensaje></WS>";
		if(mensaje.getId() != 0L) {
			xml = "<?xml version=\"1.0\"?><WS><Mensaje><id>"+mensaje.getId()+"</id><autor>"+mensaje.getAutor()+
					"</autor><contenido>"+mensaje.getContenido()+"</contenido><fecha>"+
					mensaje.getFecha()+"</fecha></Mensaje></WS>";
		}
		return xml;
	}

}
