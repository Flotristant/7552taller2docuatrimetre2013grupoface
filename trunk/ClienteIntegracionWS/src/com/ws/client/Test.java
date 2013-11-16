package com.ws.client;

import java.rmi.RemoteException;
import com.ws.services.*;
import org.apache.axis2.client.Stub;

public class Test {

	/**
	 * @param args
	 */
	 
	public static void main(String[] args) {
		
		IntegracionStub integracion = null;
		IntegracionStub.GuardarDatos request = null;
		IntegracionStub.GuardarDatosResponse response = null;
		
		try{
			
			integracion = new IntegracionStub();
			request = new IntegracionStub.GuardarDatos();
			
			Stub stub = integracion;
			
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(120000);
			
			String xmlUser = "<?xml version=\"1.0\"?><WS><Usuario><username>usuario_prueba1</username><password>1234</password><activado>true</activado><habilitado>true</habilitado></Usuario></WS>";
			
			request.setXml(xmlUser);
			
			response = integracion.guardarDatos(request);
			
			System.out.println(response.get_return());
		
		}catch(RemoteException excepcionDeInvocacion){
			System.err.println(excepcionDeInvocacion.toString());
			
		}

	}

}
