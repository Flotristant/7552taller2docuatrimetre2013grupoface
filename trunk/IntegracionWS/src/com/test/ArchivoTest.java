package com.test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
		
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><nombre>nuevaPruebaRecursoNuevo</nombre><tamanio>1</tamanio><tipo>txt</tipo><recursoId>1022</recursoId></ArchivoMetadata></WS>";
		
		
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
		
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><id>1030</id><nombre>nuevaPruebaArchivoRecurso1030Actualizacion</nombre><tamanio>1</tamanio><tipo>txt</tipo><recursoId>1030</recursoId></ArchivoMetadata></WS>";
		
		System.out.println(ws.actualizarArchivo(xml, bytes));
		
	}
	
	@Test
	public void seleccionarArchivo(){
		
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><nombre>nuevaPruebaArchivoRecurso1030</nombre></ArchivoMetadata></WS>";
		
		ArchivoMetadata[] archivos  =  ws.seleccionarArchivo(xml);
		
		for (int i=0; i < archivos.length ; i ++){
			ArchivoMetadata archivo = (ArchivoMetadata) archivos[i];
			System.out.println(archivo.getNombre());
			System.out.println(archivo.getTipo());
			System.out.println(archivo.getRecursoId());
			System.out.println(archivo.getTamanio());
			System.out.println(archivo.getId());
		}	
	}
}
