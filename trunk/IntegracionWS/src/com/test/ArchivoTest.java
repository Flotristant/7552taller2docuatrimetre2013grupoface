package com.test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;



import com.ws.pojos.ArchivoMetadata;
import com.ws.services.IntegracionWS;

public class ArchivoTest {

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
		
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><nombre>nuevaPruebaRecursoNuevo7:48am</nombre><tamanio>1</tamanio><tipo>txt</tipo><recursoId>1074</recursoId></ArchivoMetadata></WS>";
		
		
		System.out.println(ws.guardarArchivo(xml, bytes));
		
		
	}
	
	@Test
	public void actualizarArchivo(){
		Path ruta = Paths.get("c:\\entrada.txt");
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><id>1074</id><nombre>nuevaPruebaArchivoRecurso1074Actualizacion</nombre><tamanio>1</tamanio><tipo>txt</tipo><recursoId>1074</recursoId></ArchivoMetadata></WS>";
		
		System.out.println(ws.actualizarArchivo(xml, bytes));
		
	}
	
	@Test
	public void seleccionarArchivo(){
		
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><id>1074</id></ArchivoMetadata></WS>";
		
		String xmlMetadata = ws.seleccionarArchivoMetadata(xml);
		byte[] bytes = ws.seleccionarBytesArchivo(xml);
		
		System.out.println(xmlMetadata);
		if(bytes != null)
			System.out.println("Los bytes no estan vacíos");
	}
}
