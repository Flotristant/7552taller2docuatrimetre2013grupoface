package com.ws.cliente;

import com.ws.servidor.CalculadoraStub;

import java.rmi.RemoteException;

public class Test {
	
	  public static void main(String[] args) {
		  
		  CalculadoraStub calculadora = null;   
		  CalculadoraStub.Suma request = null;
		  CalculadoraStub.SumaResponse response = null;
		  
		  try {
			  
				calculadora = new CalculadoraStub();
				request = new CalculadoraStub.Suma();
				// establecemos los parámetros
				
				request.setSuma(7);
	            request.setSuma(2);
				
				// invocamos al web service
				response = calculadora.suma(request);
				// mostramos la respuesta
				
				System.out.println("La suma es: " + response.get_return());
	 
			} catch (RemoteException excepcionDeInvocacion) {
				System.err.println(excepcionDeInvocacion.toString());
			}
	      

          
  }

}

