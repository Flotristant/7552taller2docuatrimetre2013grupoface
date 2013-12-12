package com.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import com.db.querys.QueryBuilder;
import com.sun.xml.internal.ws.client.ClientTransportException;
import com.utils.IdGenerator;
import com.ws.parsers.ChatParser;

import ar.fiuba.redsocedu.datalayer.ws.Ambito;
import ar.fiuba.redsocedu.datalayer.ws.Cartelera;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Noticia;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

public class JoinTests {

	DataService service;
	IData port;
	Noticia noticia;
	Cartelera cartelera;
	
//	@Before
//	public void setUp() throws Exception {
//		service = new DataService();
//		port = service.getDataPort();
//		
//		Ambito ambito = new Ambito();
//		
//		
//		noticia = new Noticia();
//		noticia.setTitulo("Titulo1");
//		noticia.setContenido("lala");
//		
//		cartelera = new Cartelera();
//		cartelera.setNombre("Mi cartelera");
//		cartelera.setAmbito(ambito);
//		
//		Long id_ambito = guardarDatos(cartelera, "ar.fiuba.redsocedu.datalayer.dtos.Ambito");
//		ambito.setAmbitoId(id_ambito);
//		ambito.setId(id_ambito);
//		
//		cartelera.setAmbito(ambito);
//		cartelera.setAmbitoId(id_ambito);
//		Long id_cartelera = guardarDatos(cartelera, "ar.fiuba.redsocedu.datalayer.dtos.Cartelera");
//		cartelera.setId(id_cartelera);
//		
//		noticia.setCartelera(cartelera);
//		noticia.setCarteleraId(id_cartelera);
//		Long id = guardarDatos(noticia, "ar.fiuba.redsocedu.datalayer.dtos.Noticia");
//		noticia.setId(id);			
//	}
//	
//	public Long guardarDatos(Object o, String databaseEntityPath) {
//		Long transactionId = IdGenerator.generateTransactionId();
//		Long idnuevo;
//		try {
//			port.beginTransaction(transactionId);
//			Object obj = o;
//			idnuevo = port.saveOrUpdate(transactionId, databaseEntityPath, obj);
//			port.commit(transactionId);
//			return idnuevo;
//		} catch (ClientTransportException e) {
//			port.rollback(transactionId);
//			return 0L;
//		}
//	}
//
//	@Test
//	public void test() {
//		DetachedCriteria criteria = DetachedCriteria.forEntityName("ar.fiuba.redsocedu.datalayer.dtos.Cartelera")
//				  .createAlias("noticias", "n")
//				  .add(Restrictions.eq("n.titulo", "Titulo1"));
//		String query = QueryBuilder.getSerializedCriteria(criteria);
//
//		Long transactionId = IdGenerator.generateTransactionId();
//
//		port.beginTransaction(transactionId);
//		List<ReturnedObject> objects = port.query(transactionId, query);
//		if (objects == null || objects.isEmpty()) {
//			System.out.println("error al consultar");
//		}
//		port.commit(transactionId);
//
//	}
	
	@Test
	public void ChatJoinTest() {
		String consulta_join = "<Chat>" +
				"	<join><MensajeChat>" +
				"			<id>7</id>" +
				"			<contenido>holaaaa!</contenido>"+
				"		</MensajeChat></join>" +
				"</Chat>";
		ChatParser parser = new ChatParser();
		parser.inicializarCampos(consulta_join);
		Map<String, String> campos_query = parser.getJoinFields();
		System.out.println(campos_query);
	}

}
