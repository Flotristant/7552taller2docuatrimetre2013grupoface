package com.ws.handler;

import java.util.List;

import ar.fiuba.redsocedu.datalayer.ws.DataException;
import ar.fiuba.redsocedu.datalayer.ws.Recurso;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.QueryBuilder;
import com.db.querys.RecursoQueryBuilder;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.MaterialesParser;
import com.ws.parsers.Parser;
import com.ws.parsers.RecursoParser;
import com.ws.pojos.Pojo;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.Serializer;

public abstract class MaterialesHandler extends Handler{
	
	RecursoParser recursoParser;
	QueryBuilder recursoQueryBuilder;
	MaterialesParser materialesParser;

	public MaterialesHandler(String databaseEntityPath, Parser parser,
			Serializer serializer, QueryBuilder queryBuilder) {
		super(databaseEntityPath, parser, serializer, queryBuilder);
		this.recursoParser = new RecursoParser();
		this.recursoQueryBuilder = new RecursoQueryBuilder();
		this.materialesParser = (MaterialesParser) this.getParser();
	}
	
	
	protected Recurso obtenerRecursoById(String xml, Long transactionId){
		
		Recurso recurso = null;
	    String xmlRecurso = this.materialesParser.getXmlRecursoId(xml);
	    
	    try{
	     	
	    	this.recursoParser.inicializarCampos(xmlRecurso);
			Pojo pojo = (Pojo) this.recursoParser.getEntidadNegocio(xmlRecurso);
	    	String query = this.recursoQueryBuilder.getAllById(pojo.getId());
	    	List<ReturnedObject> dbPojos = null;
	    	
	    	port.beginTransaction(transactionId);
	    	dbPojos = port.query(transactionId, query);
	    	port.commit(transactionId);
	    	 
	    	if (!dbPojos.isEmpty())
	    		recurso = (Recurso) dbPojos.get(0);
	    	return recurso;
	    }
	    catch (DataException e) {
	    	 try{
	    		 port.rollback(transactionId);
	    		 return recurso;
	    	 }
	    	 catch(DataException e1){
	    		 return recurso;
	    	 }
	    }
	 } 
	
	@Override
	public String guardarDatos(String xml){
		
	 Long transactionId = IdGenerator.generateTransactionId();
     Long idnuevo = null;
     Recurso recurso;
     
     try{
     	
    	recurso = this.obtenerRecursoById(xml,transactionId);
    	 
    	if (recurso == null) {
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
    	}
    	
    	Object obj = this.materialesParser.getDBObjectFromBusinessXML(xml, this.materialesParser.getRecursoNegocio(recurso));
 	    
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
	
	
	@Override
	public String actualizarDatos(String xml){
		this.parser.inicializarCampos(xml);
	    Long transactionId = IdGenerator.generateTransactionId();
	    Recurso recurso = null;
        
	    try {
           
	    	//Verificamos existencia del archivo en la base de datos
        	port.beginTransaction(transactionId);
            Pojo pojo = (Pojo) materialesParser.getEntidadNegocio(xml);
            String query = this.queryBuilder.getAllById(pojo.getId());
            List<ReturnedObject> dbPojos = null;

            dbPojos = port.query(transactionId, query);
            port.commit(transactionId);
            if (dbPojos == null || dbPojos.isEmpty() || dbPojos.size() > 1) {
                return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
            }
        
            recurso = this.obtenerRecursoById(xml,transactionId);
          
            Object obj = this.materialesParser.getDBObjectFromBusinessXML(xml, this.materialesParser.getRecursoNegocio(recurso));
            
            port.beginTransaction(transactionId);
            port.saveOrUpdate(transactionId, this.databaseEntityPath, obj);
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
}
