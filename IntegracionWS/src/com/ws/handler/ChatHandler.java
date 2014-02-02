package com.ws.handler;

import com.db.querys.ChatQueryBuilder;
import com.ws.parsers.ChatParser;
import com.ws.serializers.ChatSerializer;
import com.ws.tags.ChatTags;

public class ChatHandler extends Handler {

	public ChatHandler() {
		super(ChatTags.PACKET_AND_CLASS_NAME, new ChatParser(),
				new ChatSerializer(), new ChatQueryBuilder());
	}
}
