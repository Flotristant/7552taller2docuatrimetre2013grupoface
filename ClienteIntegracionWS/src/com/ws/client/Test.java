package com.ws.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;

import javax.activation.DataHandler;

import com.ws.services.*;


public class Test {
	


	/**
	 * @param args
	 */
	 
	public static void main(String[] args) {
		
		
		Path ruta = Paths.get("c:\\entrada.txt");
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*java.io.File fichero = new java.io.File(rootCompleted); 
		byte contenido[] = new byte[(int)fichero.length()]; 
		return contenido;*/

		
		IntegracionStub integracion = null;
		IntegracionStub.GuardarArchivo requestArchivo = null;
		IntegracionStub.GuardarArchivoResponse responseArchivo = null;
		
		try{
			
			/*Stub stub = integracion;
			
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(1200000);*/
			
			
			integracion = new IntegracionStub();
			requestArchivo = new IntegracionStub.GuardarArchivo();
		
			DataHandler dataHandler = new DataHandler(bytes,"application/octet-stream");
			
			requestArchivo.setArchivo(dataHandler);
			requestArchivo.setXml("c:\\salida.txt");
			
			responseArchivo = integracion.guardarArchivo(requestArchivo);
			
			System.out.println("La salida es : " + responseArchivo.get_return());		
		
		}catch(RemoteException excepcionDeInvocacion){
			System.err.println(excepcionDeInvocacion.toString());
			
		}

	}

}
