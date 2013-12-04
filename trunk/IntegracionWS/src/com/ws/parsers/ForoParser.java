package com.ws.parsers;

import com.ws.tags.ForoTags;

public class ForoParser extends Parser {
	
	public ForoParser() {
		super(ForoTags.CLASS_TAG);
	}
	
	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(ForoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
