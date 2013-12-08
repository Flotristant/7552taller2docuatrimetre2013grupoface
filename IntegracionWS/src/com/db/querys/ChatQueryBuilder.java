package com.db.querys;

import com.ws.tags.ChatTags;

public class ChatQueryBuilder extends QueryBuilder {
	
	public ChatQueryBuilder() {
		super("ar.fiuba.redsocedu.datalayer.dtos.Chat", ChatTags.ID_TAG);
	}
}
