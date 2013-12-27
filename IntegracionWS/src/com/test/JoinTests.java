package com.test;

import java.util.Map;

import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Cartelera;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Noticia;

import com.ws.parsers.MensajeChatParser;
import com.ws.services.IntegracionWS;

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
        String consulta_join = "<MensajeChat><join><Chat><id>25</id></Chat></join></MensajeChat>";
        MensajeChatParser parser = new MensajeChatParser();
        parser.inicializarCampos(consulta_join);
        Map<String, Object> campos_query = parser.getJoinFields();
        System.out.println(campos_query);
    }
    
    @Test
    public void ChatJoinMensajesChatTest() {
        String consulta_join = "<WS><Chat><join><MensajeChat><id>25</id></MensajeChat></join></Chat></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.seleccionarDatos(consulta_join);
    	System.out.println(resultado);
    }
    
    @Test
    public void consultarChatPorId() {
    	String consulta = "<WS><Chat><id>57</id></Chat></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.seleccionarDatos(consulta);
    	System.out.println(resultado);
    }
    
    @Test
    public void updateChat() {
    	String consulta = "<WS><Chat><id>57</id></Chat></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.actualizarDatos(consulta);
    	System.out.println(resultado);
    }
    
    @Test
    public void UsuarioJoinActividadTest() {
        String consulta_join = "<WS><Usuario><join><Actividad><id>25</id></Actividad></join></Usuario></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.seleccionarDatos(consulta_join);
    	System.out.println(resultado);
    }
    
    @Test
    public void UsuarioJoinActividad() {
    	String consulta = "<WS><Actividad><join><Usuario><id>63</id></Usuario></join></Actividad></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.seleccionarDatos(consulta);
    	System.out.println(resultado);
    }
    
    @Test
    public void SubforoSeccionJoinTest() {
    	 String consulta_join = "<WS><Evento><join><Muro><nombre>Muro Integración</nombre></Muro></join></Evento></WS>";//"<WS><Subforo>" + "	<join><Seccion>" + "			<id>1</id>" + "		</Seccion></join>" + "</Subforo></WS>";
    	 IntegracionWS integracionWS = new IntegracionWS();
    	 String resultado = integracionWS.seleccionarDatos(consulta_join);
    	 System.out.println(resultado);
    }

}
