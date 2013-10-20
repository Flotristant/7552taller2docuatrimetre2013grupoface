
/**
 * CalculadoraCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.ws.servidor;

    /**
     *  CalculadoraCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CalculadoraCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CalculadoraCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CalculadoraCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for multiplica method
            * override this method for handling normal response from multiplica operation
            */
           public void receiveResultmultiplica(
                    com.ws.servidor.CalculadoraStub.MultiplicaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from multiplica operation
           */
            public void receiveErrormultiplica(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for suma method
            * override this method for handling normal response from suma operation
            */
           public void receiveResultsuma(
                    com.ws.servidor.CalculadoraStub.SumaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from suma operation
           */
            public void receiveErrorsuma(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for divide method
            * override this method for handling normal response from divide operation
            */
           public void receiveResultdivide(
                    com.ws.servidor.CalculadoraStub.DivideResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from divide operation
           */
            public void receiveErrordivide(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resta method
            * override this method for handling normal response from resta operation
            */
           public void receiveResultresta(
                    com.ws.servidor.CalculadoraStub.RestaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resta operation
           */
            public void receiveErrorresta(java.lang.Exception e) {
            }
                


    }
    