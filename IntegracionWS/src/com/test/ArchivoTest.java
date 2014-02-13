package com.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ar.fiuba.redsocedu.datalayer.ws.Archivo;
import ar.fiuba.redsocedu.datalayer.ws.ReturnedObject;

import com.ws.services.IntegracionWS;

public class ArchivoTest extends TestCase {

	IntegracionWS ws;
	
	@Before
	public void setUp() {
		ws = new IntegracionWS();
	}
	
	
	@Test
	public void guardarArchivo(){
		
		Path ruta = Paths.get("c:\\entrada.txt");
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><nombre>nuevaPruebaRecursoNuevo</nombre><tamanio>1</tamanio><tipo>txt</tipo><recursoId>1022</recursoId></ArchivoMetadata></WS>";
		
		
		System.out.println(ws.guardarArchivo(xml, bytes));
		
		
	}
	
	@Test
	public void seleccionarArchivo(){
		
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><recursoId>1017</recursoId></ArchivoMetadata></WS>";
		//String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><nombre>nuevaPruebaRecursoNuevo</nombre></ArchivoMetadata></WS>";
		
		/*List<ReturnedObject> archivos  =  ws.seleccionarArchivo(xml);
		
		for (int i=0; i < archivos.size() ; i ++){
			Object objetoArchivo = (Object) archivos.get(i);
			Archivo archivo = (Archivo) objetoArchivo;
			System.out.println(archivo.getNombre());
		}	*/	
		Assert.assertTrue(!ws.seleccionarArchivo(xml).isEmpty());
	}
}
