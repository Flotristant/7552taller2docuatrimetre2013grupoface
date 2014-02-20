package com.ws.parsers;

import com.ws.pojos.Mensaje;
import com.ws.tags.MensajeTags;

public class MensajeParser extends Parser  {

	public MensajeParser() {
		super(MensajeTags.CLASS_TAG);
	}

	@Override
	public Object getDBObjectFromBusinessXML(String xml) {
		Mensaje mensaje = (Mensaje) getEntidadNegocio(xml);
		return mensaje.getDatabaseEntity();
	}

	@Override
	protected Boolean validateJoinParser(Parser parser) {
		// TODO Auto-generated method stub
		return null;
	}

}
