package com.db.querys;

import com.ws.tags.MensajeChatTags;

public class MensajeChatQueryBuilder extends QueryBuilder{
	
	public MensajeChatQueryBuilder(){
		super("ar.fiuba.redsocedu.datalayer.dtos.MensajeChat", MensajeChatTags.ID_TAG);
	}

}
