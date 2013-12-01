package com.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.utils.NotificacionFactory;
import com.ws.pojos.Mensaje;
import com.ws.serializers.NotificacionSerializer;
import com.ws.services.IntegracionWS;

public class TestIntegracionComunicacion {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMensaje() {
        // iniciar Servicio BD 

        //mock, para probar integraci�n real, borrar esta linea.
        IntegracionWS.setMockService(true);

        IntegracionWS integracionWS = new IntegracionWS();

        // guardar mensaje
        Mensaje mensaje = crearMensaje();
        String resultadoTransaccion = integracionWS.guardarDatos(getMensajeNegocioXML(mensaje));
        Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), resultadoTransaccion);

        // consultar mensaje por props
        resultadoTransaccion = integracionWS.seleccionarDatos(getMensajeNegocioXML(mensaje));
        Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), resultadoTransaccion);

        // consultar mensaje por id
        //IMPORTANTE: setear el id que corresponde!
        Mensaje mensaje2 = crearMensajeConId();
        resultadoTransaccion = integracionWS.seleccionarDatos(getMensajeNegocioXML(mensaje));
        Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), resultadoTransaccion);

        // eliminar mensaje
        Mensaje mensaje4 = crearMensajeConId();
        resultadoTransaccion = integracionWS.eliminarDatos(getMensajeNegocioXML(mensaje4));
        Assert.assertEquals(NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito()), resultadoTransaccion);
    }

    private Mensaje crearMensaje() {
        Mensaje mensaje = new Mensaje();
        mensaje.setAutor("Pepe");
        mensaje.setContenido("Hola querido!, como estas??");
        mensaje.setFecha("10/02/2013");
        return mensaje;
    }

    private Mensaje crearMensajeConId() {
        Mensaje mensaje = new Mensaje();
        mensaje.setAutor("Pepe");
        mensaje.setContenido("Hola querido!, como estas??");
        mensaje.setFecha("10/02/2013");
        //TODO: setear el que corresponde!
        mensaje.setId(5L);
        return mensaje;
    }

    private String getMensajeNegocioXML(Mensaje mensaje) {
        String xml = "<?xml version=\"1.0\"?><WS><Mensaje><autor>" + mensaje.getAutor() + "</autor><contenido>" + mensaje.getContenido() + "</contenido><fecha>" + mensaje.getFecha() + "</fecha></Mensaje></WS>";
        if (mensaje.getId() != null) {
            xml = "<?xml version=\"1.0\"?><WS><Mensaje><id>" + mensaje.getId() + "</id></Mensaje></WS>";
        }
        return xml;
    }

}
