package com.test;

import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Cartelera;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.Noticia;

import com.utils.NotificacionFactory;
import com.ws.parsers.MensajeChatParser;
import com.ws.services.IntegracionWS;

public class JoinTests extends TestCase {

    DataService service;

    IData port;

    Noticia noticia;

    Cartelera cartelera;

    @Test
    public void testChatJoinTest() {
        String consulta_join = "<MensajeChat><join><Chat><id>25</id></Chat></join></MensajeChat>";
        MensajeChatParser parser = new MensajeChatParser();
        parser.inicializarCampos(consulta_join);
        Map<String, Object> campos_query = parser.getJoinFields();
        System.out.println(campos_query);
    }
    
    @Test
    public void testChatJoinMensajesChatTest() {
        String consulta_join = "<WS><Chat><join><MensajeChat><id>25</id></MensajeChat></join></Chat></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.seleccionarDatos(consulta_join);
    	System.out.println(resultado);
    }
    
    @Test
    public void testConsultarChatPorId() {
    	String consulta = "<WS><Chat><id>57</id></Chat></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.seleccionarDatos(consulta);
    	System.out.println(resultado);
    }
    
    @Test
    public void testUpdateChat() {
    	String consulta = "<WS><Chat><id>57</id></Chat></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.actualizarDatos(consulta);
    	System.out.println(resultado);
    }
    
    @Test
    public void testUsuarioJoinActividadTest() {
    	IntegracionWS integracionWS = new IntegracionWS();
    	String usuarioAGuardar = "<WS><Usuario><actividades><Actividad><id>27</id><gruposExclusivos>false</gruposExclusivos></Actividad></actividades></Usuario></WS>";
    	String response = integracionWS.guardarDatos(usuarioAGuardar);
    	System.out.println(response);
    	Assert.assertTrue(response.contains("exito"));
    	
        String consulta_join = "<WS><Usuario><join><Actividad><id>27</id></Actividad></join></Usuario></WS>";
    	String resultado = integracionWS.seleccionarDatos(consulta_join);
    	Assert.assertTrue(resultado, resultado.contains(NotificacionFactory.Exito().getMensaje()));
    }
    
    @Test
    public void testUsuarioJoinActividad() {
    	String consulta = "<WS><Actividad><join><Usuario><id>63</id></Usuario></join></Actividad></WS>";
    	IntegracionWS integracionWS = new IntegracionWS();
    	String resultado = integracionWS.seleccionarDatos(consulta);
    	Assert.assertFalse(resultado, resultado.contains(NotificacionFactory.Error().getMensaje()));	
    }
    
    @Test
    public void testSubforoSeccionJoinTest() {
	 String consulta_join = "<WS><Evento><join><Muro><nombre>Muro Integración</nombre></Muro></join></Evento></WS>";//"<WS><Subforo>" + "	<join><Seccion>" + "			<id>1</id>" + "		</Seccion></join>" + "</Subforo></WS>";
	 IntegracionWS integracionWS = new IntegracionWS();
	 String resultado = integracionWS.seleccionarDatos(consulta_join);
	 System.out.println(resultado);
	 Assert.assertFalse(resultado.contains(NotificacionFactory.Error().getMensaje()));	 
    }
    
    @Test
    public void testMuroEventoInversa() {
   	 String consulta_join = "<WS><Muro><join><Evento><id>1</id></Evento></join></Muro></WS>";//"<WS><Subforo>" + "	<join><Seccion>" + "			<id>1</id>" + "		</Seccion></join>" + "</Subforo></WS>";
   	 IntegracionWS integracionWS = new IntegracionWS();
   	 String resultado = integracionWS.seleccionarDatos(consulta_join);
   	 System.out.println(resultado);
   	 Assert.assertFalse(resultado.contains(NotificacionFactory.Error().getMensaje()));
    }

}
