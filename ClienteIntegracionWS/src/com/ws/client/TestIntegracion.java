package com.ws.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.ws.services.IntegracionStub;

import junit.framework.TestCase;

public class TestIntegracion extends TestCase {
	
	protected IntegracionStub integracionStub;
	protected IntegracionStub.GuardarDatos guardarDatosRequest;
	protected IntegracionStub.GuardarDatosResponse guardarDatosResponse;
	protected IntegracionStub.ActualizarDatos actualizarDatosRequest;
	protected IntegracionStub.ActualizarDatosResponse actualizarDatosResponse;
	protected IntegracionStub.EliminarDatos eliminarDatosRequest;
	protected IntegracionStub.EliminarDatosResponse eliminarDatosResponse;
	protected IntegracionStub.SeleccionarDatos seleccionarDatosRequest;
	protected IntegracionStub.SeleccionarDatosResponse seleccionarDatosResponse;
	
	public void setUp() {
		try {
			integracionStub = new IntegracionStub();
			guardarDatosRequest = new IntegracionStub.GuardarDatos();
			actualizarDatosRequest = new IntegracionStub.ActualizarDatos();
			eliminarDatosRequest = new IntegracionStub.EliminarDatos();
			seleccionarDatosRequest = new IntegracionStub.SeleccionarDatos();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	
	protected void guardarDatos(String xml){
		try {
			guardarDatosRequest.setXml(xml);
			guardarDatosResponse = integracionStub.guardarDatos(guardarDatosRequest);
			System.out.println(guardarDatosResponse.get_return());
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
	}
	
	protected void actualizarDatos(String xml){
		try{
			actualizarDatosRequest.setXml(xml);
			actualizarDatosResponse = integracionStub.actualizarDatos(actualizarDatosRequest);
			System.out.println(actualizarDatosResponse.get_return());
		}catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	protected void eliminarDatos(String xml){
		try{
			eliminarDatosRequest.setXml(xml);
			eliminarDatosResponse = integracionStub.eliminarDatos(eliminarDatosRequest);
			System.out.println(eliminarDatosResponse.get_return());
		}catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	protected void seleccionarDatos(String xml){
		try{
			seleccionarDatosRequest.setXml(xml);
			seleccionarDatosResponse = integracionStub.seleccionarDatos(seleccionarDatosRequest);
			System.out.println(seleccionarDatosResponse.get_return());
		}catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
