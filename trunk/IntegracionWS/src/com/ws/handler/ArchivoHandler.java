package com.ws.handler;

import com.db.querys.ArchivoMetadataQueryBuilder;
import com.ws.parsers.ArchivoMetadataParser;
import com.ws.serializers.ArchivoMetadataSerializer;


public class ArchivoHandler extends Handler {

	public ArchivoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Archivo", new ArchivoMetadataParser(),
				new ArchivoMetadataSerializer(), new ArchivoMetadataQueryBuilder());
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String guardarDatos(String xml, byte[] Archivo){
		
		return "ok";
	}
	
	public String borrarDatos(String xml){
		
		return "ok";
	}
	
	public String actualizarDatos(String xml, byte[] Archivo){
		return "ok";
	}
	

}
