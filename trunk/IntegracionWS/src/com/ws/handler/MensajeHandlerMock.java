package com.ws.handler;

import com.utils.NotificacionFactory;
import com.ws.parsers.MensajeParser;
import com.ws.pojos.Mensaje;
import com.ws.serializers.MensajeSerializer;
import com.ws.serializers.NotificacionSerializer;

public class MensajeHandlerMock extends Handler {

    public MensajeHandlerMock() {
        super(new MensajeParser(), new MensajeSerializer());
    }

    @Override
    public String guardarDatos(String xml) {
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }

    @Override
    public String actualizarDatos(String xml) {
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }

    @Override
    public String borrarDatos(String xml) {
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }


//    @Override
//    public String seleccionarDatos(String xml) {
//        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
//    }
}
