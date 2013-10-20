package com.ws.servidor;

public class Calculadora {

    /**

     * Realiza la suma dos n�meros enteros

     * @param x Primer operando

     * @param y Segundo operando

     * @return Devuelve el resultado de la operaci�n (x+y)

     */     

    public int suma(int x, int y) {

            return x + y;

    }

            

    /**

     * Realiza la resta dos n�meros enteros

     * @param x Primer operando

     * @param y Segundo operando

     * @return Devuelve el resultado de la operaci�n (x-y)

     */     

    public int resta(int x, int y) {

            return x - y;

    }

    

    

    /**

     * Realiza la multiplicaci�n de dos n�meros enteros

     * @param x Primer operando

     * @param y Segundo operando

     * @return Devuelve el resultado de la operaci�n (x*y)

     */     

    public int multiplica(int x, int y) {

            return x * y;

    }

    

    /**

     * Realiza la divisi�n de dos n�meros enteros

     * @param x Primer operando

     * @param y Segundo operando

     * @return Devuelve el resultado de la operaci�n (x/y)

     */     

    public int divide(int x, int y) {

            return x / y;

    }

}