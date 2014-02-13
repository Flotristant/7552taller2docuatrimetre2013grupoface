package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Chat;
import ar.fiuba.redsocedu.datalayer.ws.DataService;
import ar.fiuba.redsocedu.datalayer.ws.IData;
import ar.fiuba.redsocedu.datalayer.ws.MensajeChat;
import ar.fiuba.redsocedu.datalayer.ws.MiembroChat;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.ws.services.IntegracionWS;
import com.ws.tags.ChatTags;
import com.ws.tags.MiembroChatTags;

public class TestIntegracionChat extends TestCase {
	private IntegracionWS integracionWS;
	
	private Chat chat;

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
    		TestHelper.borrarDatos(chat, "ar.fiuba.redsocedu.datalayer.dtos.Chat", service, port);
    	}
    }
    
    @Test
    public void chatNoCreadoConMiembrosNoCreados() {
    	Long randomName = System.currentTimeMillis();
    	String consulta = "<?xml version=\"1.0\"?><WS><Chat>" +
    			"<miembrosChat>" +
    			"<MiembroChat>" +
				"<nombre>"+ "LALA" + randomName.toString()+ "</nombre>" +
    			"</MiembroChat>" +
    			"</miembrosChat></Chat></WS>";
    	
		String rdo = integracionWS.guardarDatos(consulta);
		Assert.assertTrue(rdo.contains("La entidad ha sido almacenada con exito"));
		System.err.println(rdo);
    }
    
    
    @Test
    public void chatCreado() {
        this.chat = new Chat();
        Long id_chat = TestHelper.guardarDatos(chat, ChatTags.PACKET_AND_CLASS_NAME, service, port);
        this.chat.setId(id_chat);
    
		String consultaChat = "<?xml version=\"1.0\"?><WS><Chat><id>" + id_chat + "</id></Chat></WS>";
		String rdoSel = integracionWS.seleccionarDatos(consultaChat);
		System.err.println("\nSELECT: \n" + rdoSel);
    }
    
    @Test
    public void chatCreadoConMiembrosNoCreados() {
    	Long randomName = System.currentTimeMillis();
      this.chat = new Chat();
      Long id_chat = TestHelper.guardarDatos(chat, ChatTags.PACKET_AND_CLASS_NAME, service, port);
      this.chat.setId(id_chat);
    	String consulta = "<?xml version=\"1.0\"?><WS><Chat>" +
    			"<id>" + id_chat + "</id>" + 
    			"<miembrosChat>" +
    			"<MiembroChat>" +
				"<nombre>"+ "LALA" + randomName.toString()+ "</nombre>" +
    			"</MiembroChat>" +
    			"</miembrosChat></Chat></WS>";
    	
		String rdo = integracionWS.actualizarDatos(consulta);
		Assert.assertTrue(rdo.contains("exito"));
		System.err.println(rdo);
		
		String consultaChat = "<?xml version=\"1.0\"?><WS><Chat><id>" + id_chat + "</id></Chat></WS>";
		String rdoSel = integracionWS.seleccionarDatos(consultaChat);
		System.err.println("\nSELECT: \n" + rdoSel);
    }    

    @Test
    public void chatCreadoConMiembrosCreados() {
    	this.chat = new Chat();
    	Long id_chat = TestHelper.guardarDatos(chat, ChatTags.PACKET_AND_CLASS_NAME, service, port);
	  	this.chat.setId(id_chat);
	  
	  	MiembroChat miembroChat = new MiembroChat();
	  	miembroChat.setNombre("MiembrosCreados");
	  	Long id_miembro = TestHelper.guardarDatos(miembroChat, MiembroChatTags.PACKET_AND_CLASS_NAME, service, port);
	  	miembroChat.setId(id_miembro);
      
		String consulta = "<?xml version=\"1.0\"?><WS><Chat>" +
				"<id>" + id_chat + "</id>" + 
				"<miembrosChat>" +
				"<MiembroChat>" +
				"<nombre>"+ miembroChat.getNombre() + "</nombre>" +
				"<estado>"+ miembroChat.isEstado() + "</estado>" +
				"<id>"+ miembroChat.getId() + "</id>" +
				"</MiembroChat>" +
				"</miembrosChat></Chat></WS>";
		
		String rdo = integracionWS.actualizarDatos(consulta);
		System.err.println(rdo);
		Assert.assertTrue(rdo.contains("exito"));
   }   
    
    @Test
    public void chatCreadoConMiembrosYMensajesCreados() {
    	this.chat = new Chat();
	  	Long id_chat = TestHelper.guardarDatos(chat, "ar.fiuba.redsocedu.datalayer.dtos.Chat", service, port);
	  	this.chat.setId(id_chat);
	  
	  	MiembroChat miembroChat = new MiembroChat();
	  	miembroChat.setNombre("MiembrosCreados");
	  	Long id_miembro = TestHelper.guardarDatos(miembroChat, "ar.fiuba.redsocedu.datalayer.dtos.MiembroChat", service, port);
	  	miembroChat.setId(id_miembro);
	  	
	  	MensajeChat mensaje = new MensajeChat();
	  	mensaje.setChatId(id_chat);
	  	mensaje.setContenido("HELLOO WOORLD!");
	  	mensaje.setFecha(XMLGregorianCalendarImpl.createDate(2014, 02, 1, 0));
	  	mensaje.setMiembroChatId(id_miembro);
	  	Long id_mensaje = TestHelper.guardarDatos(mensaje, "ar.fiuba.redsocedu.datalayer.dtos.MensajeChat", service, port);
	  	mensaje.setId(id_mensaje);
      
	  	Date fecha = new Date();
	  	SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/mm/yyyy");
	  	String fecha_mensaje = simpleFormat.format(fecha);
	  	
		String consulta = "<?xml version=\"1.0\"?><WS><Chat>" +
				"<id>" + id_chat + "</id>" + 
				"<miembrosChat>" +
				"<MiembroChat>" +
				"<nombre>"+ miembroChat.getNombre() + "</nombre>" +
				"<estado>"+ miembroChat.isEstado() + "</estado>" +
				"<id>"+ miembroChat.getId() + "</id>" +
				"</MiembroChat>" +
				"</miembrosChat>" +
				"<mensajesChat>"+
				"<MensajeChat>" +
				"<id>"+ mensaje.getId()+ "</id>" +
				"<contenido>"+mensaje.getContenido()+ "</contenido>" +
				"<fecha>"+ fecha_mensaje+"</fecha>" +
				"</MensajeChat>" +
				"</mensajesChat>"+
				"</Chat></WS>";
		
		String rdo = integracionWS.actualizarDatos(consulta);
		System.err.println(rdo);
		Assert.assertTrue(rdo.contains("exito"));
   }  
}
