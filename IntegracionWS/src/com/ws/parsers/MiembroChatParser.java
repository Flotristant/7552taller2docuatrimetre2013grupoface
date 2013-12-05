package com.ws.parsers;

import com.ws.tags.MiembroChatTags;

public class MiembroChatParser extends Parser {

	public MiembroChatParser(){
		super(MiembroChatTags.CLASS_TAG);
	}
	
	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MiembroChatTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
