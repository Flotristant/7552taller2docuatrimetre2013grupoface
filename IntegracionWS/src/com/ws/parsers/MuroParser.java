package com.ws.parsers;

import com.ws.pojos.Muro;
import com.ws.tags.MuroTags;

public class MuroParser extends Parser {

	public MuroParser() {
		super(MuroTags.CLASS_TAG);
	}

	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(MuroTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
