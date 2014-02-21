package com.ws.client;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.activation.DataHandler;

import org.apache.axis2.AxisFault;

import com.ws.services.IntegracionStub;
import com.ws.services.IntegracionStub.SeleccionarBytesArchivo;


import junit.framework.TestCase;

public class ArchivoTest extends TestCase {
	
	IntegracionStub archivoStub;
	IntegracionStub.GuardarArchivo guardarArchivoRequest;
	IntegracionStub.GuardarArchivoResponse guardarArchivoResponse;
	IntegracionStub.ActualizarArchivo actualizarArchivoRequest;
	IntegracionStub.ActualizarArchivoResponse actualizarArchivoResponse;
	IntegracionStub.EliminarArchivo eliminarArchivoRequest;
	IntegracionStub.EliminarArchivoResponse eliminarArchivoResponse;
	IntegracionStub.SeleccionarArchivoMetadata seleccionarArchivoMetadataRequest;
	IntegracionStub.SeleccionarArchivoMetadataResponse seleccionarArchivoMetadataResponse;
	IntegracionStub.SeleccionarBytesArchivo seleccionarBytesArchivoRequest;
	IntegracionStub.SeleccionarBytesArchivoResponse seleccionarBytesArchivoResponse;
	
	
	public void setUp(){
		try {
		archivoStub = new IntegracionStub();
		guardarArchivoRequest = new IntegracionStub.GuardarArchivo();
		actualizarArchivoRequest = new IntegracionStub.ActualizarArchivo();
		eliminarArchivoRequest = new IntegracionStub.EliminarArchivo();
		seleccionarArchivoMetadataRequest = new IntegracionStub.SeleccionarArchivoMetadata();
		seleccionarBytesArchivoRequest = new IntegracionStub.SeleccionarBytesArchivo();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	
	
	public void testGuardarArchivo(){
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><nombre>nuevaPruebaArchivoRecurso1030</nombre><tamanio>1</tamanio><tipo>txt</tipo><recursoId>1030</recursoId></ArchivoMetadata></WS>";
		Path ruta = Paths.get("c:\\entrada.txt");
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(ruta);
	
			DataHandler dataHandler = new DataHandler(bytes,"application/octet-stream");
			
			guardarArchivoRequest.setArchivo(dataHandler);
			
			guardarArchivoRequest.setXml(xml);
			
			guardarArchivoResponse = archivoStub.guardarArchivo(guardarArchivoRequest);
		
			System.out.println(guardarArchivoResponse.get_return());
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void testActualizarArchivo(){
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><id>1030</id><nombre>nuevaPruebaArchivoRecurso1030Actualizacion</nombre><tamanio>1</tamanio><tipo>txt</tipo><recursoId>1030</recursoId></ArchivoMetadata></WS>";
		Path ruta = Paths.get("c:\\entrada.txt");
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(ruta);
	
			DataHandler dataHandler = new DataHandler(bytes,"application/octet-stream");
			
			actualizarArchivoRequest.setArchivo(dataHandler);
			
			actualizarArchivoRequest.setXml(xml);
			
			actualizarArchivoResponse = archivoStub.actualizarArchivo(actualizarArchivoRequest);
		
			System.out.println(actualizarArchivoResponse.get_return());
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
		
	
	public void testSeleccionarArchivo(){
		String xml = "<?xml version=\"1.0\"?><WS><ArchivoMetadata><id>1074</id></ArchivoMetadata></WS>";
		
		try{
			seleccionarArchivoMetadataRequest.setXml(xml);
			
			seleccionarArchivoMetadataResponse = archivoStub.seleccionarArchivoMetadata(seleccionarArchivoMetadataRequest);
			
			System.out.println("----------------------Metadata ----------------");
			System.out.println(seleccionarArchivoMetadataResponse.get_return());
			
			
			seleccionarBytesArchivoRequest.setXml(xml);
			seleccionarBytesArchivoResponse = archivoStub.seleccionarBytesArchivo(seleccionarBytesArchivoRequest);
			if(seleccionarBytesArchivoResponse.get_return() != null){
				System.out.println("Bytes no nulos");
			}
		}
		catch (Exception e) {
		e.printStackTrace();
	}	
		
		
	}

}
