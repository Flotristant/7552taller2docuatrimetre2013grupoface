package com.ws.parsers;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.XStream;
import com.ws.handler.Handler;
import com.ws.pojos.Chat;
import com.ws.pojos.MensajeChat;
import com.ws.pojos.MiembroChat;
import com.ws.tags.ChatTags;

public class ChatParser extends Parser {
	
	Map<String, String> relaciones;
	
	public ChatParser() {
		super(ChatTags.CLASS_TAG);
		relaciones = new HashMap<String, String>();
		relaciones.put(MensajeChatParser.class.toString(), "mensajesChat");
		relaciones.put(MiembroChatParser.class.toString(), "miembrosChat");
	}
	
	@Override
	public Map<String, String> getJoinFields() {
		String joinXML = this.campos.get(Parser.JOIN_TAG);
		Map<String, String> joinFields = new HashMap<String, String>();
		Parser parser = getJoinParser(joinXML);
		if(parser == null)
			return joinFields;
		String nombreRelacion = relaciones.get(parser.getClass().toString());
		joinXML = joinXML.replace("<join>", "");
		joinXML = joinXML.replace("</join>", "");
		parser.inicializarCampos(joinXML);
		Map<String, String> camposRelacion = parser.getCampos();
		for(String campo : camposRelacion.keySet()) {
			joinFields.put(nombreRelacion+"."+campo,camposRelacion.get(campo));
		}
		return joinFields;		
	}
	
	private Parser getJoinParser(String joinXML) {
		Parser parser = getParserFromJoinXML(joinXML);
		if((parser instanceof MensajeChatParser)||(parser instanceof MiembroChatParser)) {
			return parser;
		}
		return null;
	}


	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(ChatTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		
		Chat miChatNegocio = (Chat) getEntidadNegocio(xml);
		
		ar.fiuba.redsocedu.datalayer.ws.Chat miChatDB = new ar.fiuba.redsocedu.datalayer.ws.Chat();
		
		miChatDB.setChatId(miChatNegocio.getIdChat());
		
		//miChatDB.setIdAmbito(miChatNegocio.getIdAmbito());
		
		return miChatDB;
	}
	
}
