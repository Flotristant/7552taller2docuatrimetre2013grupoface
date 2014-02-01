package com.ws.handler;

import com.db.querys.UsuarioQueryBuilder;
import com.utils.MockCache;
import com.utils.NotificacionFactory;
import com.ws.parsers.UsuarioParser;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.UsuarioSerializer;

public class UsuarioHandlerMock extends Handler {

    public UsuarioHandlerMock() {
        super(new UsuarioParser(), new UsuarioSerializer());
        this.queryBuilder = new UsuarioQueryBuilder();
    }

    @Override
    public String guardarDatos(String xml) {
        Long id = MockCache.guardarUsuario(xml);
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.ExitoGuardado(id.toString()));
    }

    @Override
    public String actualizarDatos(String xml) {
        MockCache.guardarUsuario(xml);
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }
    
    @Override
    public String seleccionarDatos(String xml) {
        return MockCache.seleccionarUsuario(xml);
    }

    @Override
    public String borrarDatos(String xml) {
        if (MockCache.borrarUsuario(xml))
            return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
        else
            return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.sinResultados());
    }

}
