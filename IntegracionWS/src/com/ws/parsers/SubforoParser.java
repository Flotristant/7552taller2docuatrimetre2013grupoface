package com.ws.parsers;

import com.ws.pojos.Subforo;
import com.ws.tags.SubforoTags;

public class SubforoParser extends Parser{

	
	public SubforoParser() {
		super(SubforoTags.CLASS_TAG);
	}
	
	@Override
	public Long getId() {
		return Long.parseLong(this.campos.get(SubforoTags.ID_TAG));
	}

	@Override
	public Object getDBObject(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String replaceClassTag(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
