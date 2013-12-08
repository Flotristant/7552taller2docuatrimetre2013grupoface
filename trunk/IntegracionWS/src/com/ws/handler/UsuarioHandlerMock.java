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

    @Override
	public Object toDatabaseEntity(Object object) {
    	com.ws.pojos.Usuario usuario = (com.ws.pojos.Usuario) object; 
        ar.fiuba.redsocedu.datalayer.ws.Usuario user = new ar.fiuba.redsocedu.datalayer.ws.Usuario();
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setPadron(usuario.getPadron());
        //user.setFechaNac(usuario.getFechaNacimiento());
        user.setActivado(usuario.getActivado());
        user.setHabilitado(usuario.getHabilitado());
        user.setEmail(usuario.getEmail());
        user.setPassword(usuario.getPassword());
        user.setUsername(usuario.getUsername());
        user.setId(usuario.getId());
        return user;    
    }

}
