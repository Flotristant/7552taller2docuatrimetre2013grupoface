package com.ws.handler;

import org.w3c.dom.Document;

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
    public String guardarDatos(Document doc) {
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }

    @Override
    public String actualizarDatos(Document doc) {
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }

    @Override
    public String borrarDatos(Document doc) {
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }

    @Override
    protected Object toDatabaseEntity(Object object) {
        Mensaje mensaje = (Mensaje) object;
        ar.fiuba.redsocedu.datalayer.ws.Mensaje DBmensaje = new ar.fiuba.redsocedu.datalayer.ws.Mensaje();
        DBmensaje.setAutor(mensaje.getAutor());
        DBmensaje.setContenido(mensaje.getContenido());
        DBmensaje.setMensajeId(mensaje.getId());
        return DBmensaje;
    }

    @Override
    public String seleccionarDatos(Document doc) {
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }
}
