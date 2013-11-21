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
		IntegracionStub.SeleccionarDatos requestSeleccionar = null;
		IntegracionStub.SeleccionarDatosResponse responseSeleccionar = null;
		IntegracionStub.ActualizarDatos requestActualizar = null;
		IntegracionStub.ActualizarDatosResponse responseActualizar = null;
		
		try{
			
			integracion = new IntegracionStub();
			request = new IntegracionStub.GuardarDatos();
			
			requestSeleccionar = new IntegracionStub.SeleccionarDatos();
			requestActualizar = new IntegracionStub.ActualizarDatos();
			
			
			//Stub stub = integracion;
			
			//stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(1200000);
			
			String xmlUser = "<?xml version=\"1.0\"?><WS><Usuario><username>usuarioCatalina</username><password>1234</password><activado>true</activado><habilitado>true</habilitado></Usuario></WS>";
			//String xmlConsulta = "<?xml version=\"1.0\"?><WS><Usuario><username>testuser</username></Usuario></WS>";
			String xmlActualizar = "<?xml version=\"1.0\"?><WS><Usuario><id>66</id><username>usuarioCatalina</username><password>123HOLA</password><activado>true</activado><habilitado>true</habilitado></Usuario></WS>";
			
			
			//requestSeleccionar.setXml(xmlConsulta);
			//request.setXml(xmlConsulta);
			requestActualizar.setXml(xmlActualizar);
			
			
			//response = integracion.guardarDatos(request);
			//responseSeleccionar = integracion.seleccionarDatos(requestSeleccionar);
			responseActualizar = integracion.actualizarDatos(requestActualizar);
			
			//System.out.println("Respuesta guardar "+response.get_return());
			System.out.println("------------------Respuesta actualizar--------------- ");
			System.out.println("");
			System.out.println(responseActualizar.get_return());
			//System.out.println("Respuesta actualizar "+responseActualizar.get_return());
			
		
		}catch(RemoteException excepcionDeInvocacion){
			System.err.println(excepcionDeInvocacion.toString());
			
		}

	}

}
