package com.ws.parsers;

import com.ws.tags.MensajeChatTags;

public class MensajeChatParser extends Parser {

	public MensajeChatParser(){
		super(MensajeChatTags.CLASS_TAG);
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MensajeChatTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
