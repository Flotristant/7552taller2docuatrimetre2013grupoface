package com.ws.handler;

import java.util.List;
import java.util.Map;

import ar.fiuba.redsocedu.datalayer.ws.DataException;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.ArchivoMetadataQueryBuilder;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.ArchivoMetadataParser;
import com.ws.pojos.ArchivoMetadata;
import com.ws.serializers.ArchivoMetadataSerializer;
import com.ws.serializers.NotificacionSerializer;


public class ArchivoHandler extends Handler {
	
	ArchivoMetadataParser parserArchivo;

	public ArchivoHandler() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Archivo", new ArchivoMetadataParser(),
				new ArchivoMetadataSerializer(), new ArchivoMetadataQueryBuilder());
		this.parserArchivo = new ArchivoMetadataParser();
	}

	@Override
	public Object toDatabaseEntity(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String guardarArchivo(String xml, byte[] datos){
		 Long transactionId = IdGenerator.generateTransactionId();
	     Long idnuevo = null;
	     Object obj = this.parserArchivo.getDBArchivoObjectFromBusinessXML(xml, datos);
	     try {
				port.beginTransaction(transactionId);
				idnuevo = port.saveOrUpdate(transactionId, this.databaseEntityPath, obj);
				port.commit(transactionId);
	     }
	     catch (DataException e) {
	     	try{
	     		port.rollback(transactionId);
	     		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
	     			
	     	}
	     	catch (DataException e1){
	     		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
	     	}
	     }
     return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.ExitoGuardado(idnuevo.toString()));
    }
	
	public String actualizarArchivo(String xml, byte[] datos){
		this.parser.inicializarCampos(xml);
	    Long transactionId = IdGenerator.generateTransactionId();
        try {
            port.beginTransaction(transactionId);
            ArchivoMetadata pojo = (ArchivoMetadata) parser.getEntidadNegocio(xml);
            String query = this.queryBuilder.getAllById(pojo.getId());
            List<ReturnedObject> dbPojos = null;

            dbPojos = port.query(transactionId, query);
            port.commit(transactionId);
            if (dbPojos == null || dbPojos.isEmpty() || dbPojos.size() > 1) {
                return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
            }
            
            // Los pasos previos solo se hacen para verificar que existe el
            // objeto en la BBDD?? yes.
            transactionId = IdGenerator.generateTransactionId();
            port.beginTransaction(transactionId);
            //Se le setea al pojo de negocio los datos que representan al archivo en si.
            pojo.setContenido(datos);
            
            Object pojoDB = pojo.getDatabaseEntity(); 
            port.saveOrUpdate(transactionId, this.databaseEntityPath, pojoDB);
            port.commit(transactionId);

        } catch (DataException e) {
            
        	try{
        		port.rollback(transactionId);
        		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
        	}
        	catch(DataException e1){
        		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
        	}
        }

        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
  
	
	}
	
	
	public List<ReturnedObject> seleccionarArchivo(String xml){
		
		Map<String, Object> campos = this.parser.inicializarCampos(xml);
		
		Long transactionId = IdGenerator.generateTransactionId();
        String query = this.queryBuilder.getAllByAttributes(campos);
        
        try {
        	port.beginTransaction(transactionId);
        	List<ReturnedObject> objects = null; 
        	objects = port.query(transactionId, query);
        	
        	if(objects == null || objects.isEmpty()) {
        		
        		return null;
        	}
        	
        	port.commit(transactionId);
		
        	return objects;
        }
        catch (DataException e ) {
        	
        	try{
        		port.rollback(transactionId);//if not
        		return null;
        	}
        	catch(DataException e1){
				return null;
			}
		}
		
		
	}
	

}
