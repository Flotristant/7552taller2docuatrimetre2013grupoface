package com.ws.parsers;

import com.ws.pojos.MiembroChat;
import com.ws.tags.MiembroChatTags;

public class MiembroChatParser extends Parser {

    public MiembroChatParser() {
        super(MiembroChatTags.CLASS_TAG);
        this.relaciones.put(MiembroChatParser.class.toString(), "miembrosChat"); //TODO: chequear nombre
    }

    @Override
    public Long getId() {
        return Long.parseLong(this.campos.get(MiembroChatTags.ID_TAG));
    }

    @Override
    public Object getDBObject(String xml) {
        MiembroChat miembroChat = (MiembroChat) getEntidadNegocio(xml);
        ar.fiuba.redsocedu.datalayer.ws.MiembroChat miembroChatDb = new ar.fiuba.redsocedu.datalayer.ws.MiembroChat();
        miembroChatDb.setNombre(miembroChat.getNombre());
        miembroChatDb.setId(miembroChat.getId());
        miembroChatDb.setEstado(miembroChat.getEstado());
        return miembroChatDb;
    }

    @Override
    protected Boolean validateJoinParser(Parser parser) {
        // TODO Auto-generated method stub
        return null;
    }

}
