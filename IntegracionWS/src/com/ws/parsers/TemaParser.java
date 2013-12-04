package com.ws.parsers;

import java.util.Map;

import com.ws.pojos.Tema;
import com.ws.tags.TemaTags;

public class TemaParser extends Parser  {

	public TemaParser() {
		super(TemaTags.CLASS_TAG);
	}
	
	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(TemaTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}
}
