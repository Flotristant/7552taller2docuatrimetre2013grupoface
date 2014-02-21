package com.ws.client;

public class LinkTest extends TestIntegracion {
	
	
	public void guardarLink(){
		
		String xml = "<?xml version=\"1.0\"?><WS><Link><nombre>ejemplo link para recurso 1076</nombre><recursoId>1076</recursoId></Link></WS>";
		
		this.guardarDatos(xml);
	}
	
	
	public void actualizarLink(){
		
		String xml = "<?xml version=\"1.0\"?><WS><Link><id>1076</id><nombre>ejemplo link para recurso 1076 actualizacion a las 13</nombre><recursoId>1076</recursoId></Link></WS>";
		
		this.actualizarDatos(xml);
	}
	
	
	public void seleccionarLink(){
		String xml = "<?xml version=\"1.0\"?><WS><Link><id>1076</id></Link></WS>";
		this.seleccionarDatos(xml);
		
	}

}
