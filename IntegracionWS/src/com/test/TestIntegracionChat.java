package com.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Chat;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.MiembroChat;

import com.ws.services.IntegracionWS;

public class TestIntegracionChat {
	private IntegracionWS integracionWS;
	
	private Chat chat;
	private List<MiembroChat> miembrosChat;

	DataService service;
	IData port;

    @Before
    public void setUp() throws Exception {
    	this.integracionWS = new IntegracionWS();
        IntegracionWS.setMockService(false);
		service = new DataService();
		port = service.getDataPort();
    }	
    
    @After 
    public void tearDown() throws Exception {
    	if(chat != null ) {
//    		TestHelper.borrarDatos(chat, "ar.fiuba.redsocedu.datalayer.dtos.Chat", service, port);
    	}
    }
    
    @Test
    public void chatNoCreadoConMiembrosNoCreados() {
    	String consulta = "<?xml version=\"1.0\"?><WS><Chat>" +
    			"<miembrosChat>" +
    			"<MiembroChat>" +
				"<nombre>"+ "LALA" + "</nombre>" +
    			"</MiembroChat>" +
    			"</miembrosChat></Chat></WS>";
    	
		String rdo = integracionWS.guardarDatos(consulta);
		System.err.println(rdo);
    }
    
    @Test
    public void chatCreadoConMiembrosNoCreados() {
      this.chat = new Chat();
      Long id_chat = TestHelper.guardarDatos(chat, "ar.fiuba.redsocedu.datalayer.dtos.Chat", service, port);
      this.chat.setId(id_chat);
    	String consulta = "<?xml version=\"1.0\"?><WS><Chat>" +
    			"<id>" + id_chat + "</id>" + 
    			"<miembrosChat>" +
    			"<MiembroChat>" +
				"<nombre>"+ "LALA" + "</nombre>" +
    			"</MiembroChat>" +
    			"</miembrosChat></Chat></WS>";
    	
		String rdo = integracionWS.actualizarDatos(consulta);
		System.err.println(rdo);
		
		String consultaChat = "<?xml version=\"1.0\"?><WS><Chat><id>" + id_chat + "</id></Chat></WS>";
		String rdoSel = integracionWS.actualizarDatos(consultaChat);
		System.err.println("\nSELECT: \n" + rdoSel);
    }    

    @Test
    public void chatCreadoConMiembrosCreados() {
    	this.chat = new Chat();
	  	Long id_chat = TestHelper.guardarDatos(chat, "ar.fiuba.redsocedu.datalayer.dtos.Chat", service, port);
	  	this.chat.setId(id_chat);
	  
	  	MiembroChat miembroChat = new MiembroChat();
	  	miembroChat.setNombre("MiembrosCreados");
	  	Long id_miembro = TestHelper.guardarDatos(miembroChat, "ar.fiuba.redsocedu.datalayer.dtos.MiembroChat", service, port);
	  	miembroChat.setId(id_miembro);
      
		String consulta = "<?xml version=\"1.0\"?><WS><Chat>" +
				"<id>" + id_chat + "</id>" + 
				"<miembrosChat>" +
				"<MiembroChat>" +
				"<nombre>"+ miembroChat.getNombre() + "</nombre>" +
//				"<estado>"+ miembroChat.isEstado() + "</estado>" +
				"<id>"+ miembroChat.getId() + "</id>" +
				"</MiembroChat>" +
				"</miembrosChat></Chat></WS>";
		
		String rdo = integracionWS.actualizarDatos(consulta);
		System.err.println(rdo);
   }    

}
