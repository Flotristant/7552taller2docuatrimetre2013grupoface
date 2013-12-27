package com.ws.handler;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.db.querys.QueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.utils.NotificacionFactory;
import com.ws.parsers.Parser;
import com.ws.pojos.Pojo;
import com.ws.serializers.NotificacionSerializer;
import com.ws.serializers.Serializer;

public abstract class Handler {

    QueryBuilder queryBuilder;

    DataService service;

    IData port;

    Parser parser;

    Serializer serializer;

    protected String databaseEntityPath;

    public Handler(String databaseEntityPath, Parser parser, Serializer serializer, QueryBuilder queryBuilder) {
        this.databaseEntityPath = databaseEntityPath;
        this.service = new DataService();
        this.port = service.getDataPort();
        this.parser = parser;
        this.serializer = serializer;
        this.queryBuilder = queryBuilder;
    }

    // for mock tests
    public Handler(Parser parser, Serializer serializer) {
        this.databaseEntityPath = "";
        this.service = null;
        this.port = null;
        this.parser = parser;
        this.serializer = serializer;
    }

    public String guardarDatos(String xml) {
        // this.parser.inicializarDocumento(doc);
        Long transactionId = IdGenerator.generateTransactionId();
        Long idnuevo;
        try {
        	Object obj = parser.getDBObjectFromBusinessXML(xml);
            port.beginTransaction(transactionId);
            idnuevo = port.saveOrUpdate(transactionId, this.databaseEntityPath, obj);
            port.commit(transactionId);
        } catch (ClientTransportException e) {
            port.rollback(transactionId);
            return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
        }
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.ExitoGuardado(idnuevo.toString()));
    }
    
    private String resolveDirectJoin( Map<String, Object> campos, Handler handlerJoin) throws Exception {
    	String joinXML = getJoinXML(campos);
    	String xmlJoinResult = "";
    	//obtengo todo el objeto con la lista adentro
    	xmlJoinResult = handlerJoin.seleccionarDatos(joinXML);
    	// se queda solo con los datos de la lista
		String nombreRelacion = handlerJoin.getParser().getNombreRelacionDirecta(this.parser.getClass().toString());
		if( nombreRelacion != null && !"".equals(nombreRelacion)) {
			String relationXml = getOnlyRelation(nombreRelacion, xmlJoinResult);
    		return parser.createXmlResponse(relationXml);	
		} 
		return "";
    }

    /**
     * Este metodo verifica si la consulta es o no un join. En caso de ser join, valida si la relacion consultada
     * es directa o inversa. En caso de no ser una relacion válida, se retorna un mensaje de error.
     * En caso de no ser un join, se realiza una consulta basica utilizando los campos obtenidos del xml como filtro.
     * @param xml
     * @return
     * @throws Exception
     */
    public String seleccionarDatos(String xml) throws Exception {
        Map<String, Object> campos = this.parser.inicializarCampos(xml);
        String query;
        if (this.parser.esJoin()) {
        	Handler handlerJoin = HandlerFactory.getHandler(Parser.JOIN_TAG, (String)campos.get(Parser.JOIN_TAG));        	
        	if(handlerJoin.getParser().isRelacionDirecta(this.parser.getClass().toString())) {        		
	        	return resolveDirectJoin(campos, handlerJoin);         	
        	} else if(this.parser.isRelacionDirecta(handlerJoin.getParser().getClass().toString())) {         		
        		query = resolveInverseJoin(campos, handlerJoin);
        	} else {
        		//TODO: indicar que es un join no valido
        		return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
        	}
        } else {
            query = this.queryBuilder.getAllByAttributes(campos);
        }
        return queryToDatabase(query);
    }

	private String queryToDatabase(String query) {
		Long transactionId = IdGenerator.generateTransactionId();
        try {
            port.beginTransaction(transactionId);
            List<ReturnedObject> objects = null;
            objects = port.query(transactionId, query);
            if (objects == null || objects.isEmpty()) {
            	port.commit(transactionId);
                return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.sinResultados());
            }
            port.commit(transactionId);
            if (this.parser.esJoin()) {
            	if(objects.isEmpty() || objects.size() > 1) {
                    port.rollback(transactionId);// if not
                    return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
            	} else {
            		return this.serializer.getXMLfromPojo(objects);
            	}
            } else {
                return this.serializer.getXMLfromPojo(objects);
            }
        } catch (ClientTransportException e) {
            port.rollback(transactionId);// if not
            return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
        }
	}

	private String resolveInverseJoin(Map<String, Object> campos,
			Handler handlerJoin) {
		String query;
		//obtengo el nombre de la relacion
		String nombre_relacion = this.parser.getNombreRelacionDirecta(handlerJoin.getParser().getClass().toString());
		//obtengo los campos para el join
		String joinXML = getJoinXML(campos);
		Map<String, Object> campos_join = handlerJoin.getParser().inicializarCampos(joinXML);
		//armo query de join
		query = this.queryBuilder.resolveJoin(campos_join, nombre_relacion);
		return query;
	}

	private String getJoinXML(Map<String, Object> campos) {
		String joinXML = (String)campos.get(Parser.JOIN_TAG);
		joinXML=joinXML.replace("<join>", "");
		joinXML=joinXML.replace("</join>", "");
		return joinXML;
	}

    private String getOnlyRelation(String nombreRelacion, String xmlJoin) {
    	String initialTag = "<"+nombreRelacion+">";
    	String endTag = "</"+nombreRelacion+">";
		int first = xmlJoin.indexOf(initialTag);
		int last = xmlJoin.indexOf(endTag);
		if(first > 0 && last > 0 && first < last) {
			return xmlJoin.substring(first, last + endTag.length());
		}
		return "";
	}

	public String actualizarDatos(String xml) {
        this.parser.inicializarCampos(xml);
        Long transactionId = IdGenerator.generateTransactionId();
        try {
            port.beginTransaction(transactionId);
            Pojo pojo = (Pojo) parser.getEntidadNegocio(xml);
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
            Object pojoDB = pojo.getDatabaseEntity(); //this.toDatabaseEntity(pojo);
            port.saveOrUpdate(transactionId, this.databaseEntityPath, pojoDB);
            port.commit(transactionId);

        } catch (ClientTransportException e) {
            port.rollback(transactionId);
            return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
        }

        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }

    public String borrarDatos(String xml) {
        this.parser.inicializarCampos(xml);
        Long transactionId = IdGenerator.generateTransactionId();
        String query = this.queryBuilder.getAllByAttributes(parser.getCampos());
        List<ReturnedObject> pojos = null;
        try {
            port.beginTransaction(transactionId);
            pojos = port.query(transactionId, query);
            if (pojos == null || pojos.isEmpty() || pojos.size() > 1) {
            	port.commit(transactionId);
                return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
            }
            port.commit(transactionId);
        } catch (ClientTransportException e) {
            port.rollback(transactionId);// if not
            return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
        }
        Long transactionId2 = IdGenerator.generateTransactionId();
        try {
            port.beginTransaction(transactionId2);
            for (ReturnedObject ro : pojos) {
                port.delete(transactionId2, this.databaseEntityPath, ro);
            }
            port.commit(transactionId2);// if ok
        } catch (ClientTransportException e) {
            port.rollback(transactionId2);// if not
            return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Error());
        }
        return NotificacionSerializer.getXMLfromPojo(NotificacionFactory.Exito());
    }

    public abstract Object toDatabaseEntity(Object object);
    
    public Parser getParser() {
    	return this.parser;
    }
}
