package com.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.ws.services.IntegracionWS;

public class LinkTest extends TestCase {
	
IntegracionWS ws;
	
	@Before
	public void setUp() {
		ws = new IntegracionWS();
	}
	
	@Test
	public void guardarLink(){
		
		String xml = "<?xml version=\"1.0\"?><WS><Link><nombre>ejemplo link</nombre><recursoId>1027</recursoId></Link></WS>";
		
		System.out.println(ws.guardarDatos(xml));
	}
	
	@Test
	public void seleccionarLink(){
		String xml = "<?xml version=\"1.0\"?><WS><Link><recursoId>1027</recursoId></Link></WS>";
		System.out.println(ws.seleccionarDatos(xml));
		
	}

}
