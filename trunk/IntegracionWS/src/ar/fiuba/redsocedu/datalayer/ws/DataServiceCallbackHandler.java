
/**
 * DataServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package ar.fiuba.redsocedu.datalayer.ws;

    /**
     *  DataServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DataServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DataServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DataServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for commit method
            * override this method for handling normal response from commit operation
            */
           public void receiveResultcommit(
                    ar.fiuba.redsocedu.datalayer.ws.DataServiceStub.CommitResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from commit operation
           */
            public void receiveErrorcommit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for delete method
            * override this method for handling normal response from delete operation
            */
           public void receiveResultdelete(
                    ar.fiuba.redsocedu.datalayer.ws.DataServiceStub.DeleteResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from delete operation
           */
            public void receiveErrordelete(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for saveOrUpdate method
            * override this method for handling normal response from saveOrUpdate operation
            */
           public void receiveResultsaveOrUpdate(
                    ar.fiuba.redsocedu.datalayer.ws.DataServiceStub.SaveOrUpdateResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from saveOrUpdate operation
           */
            public void receiveErrorsaveOrUpdate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for beginTransaction method
            * override this method for handling normal response from beginTransaction operation
            */
           public void receiveResultbeginTransaction(
                    ar.fiuba.redsocedu.datalayer.ws.DataServiceStub.BeginTransactionResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from beginTransaction operation
           */
            public void receiveErrorbeginTransaction(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for query method
            * override this method for handling normal response from query operation
            */
           public void receiveResultquery(
                    ar.fiuba.redsocedu.datalayer.ws.DataServiceStub.QueryResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from query operation
           */
            public void receiveErrorquery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rollback method
            * override this method for handling normal response from rollback operation
            */
           public void receiveResultrollback(
                    ar.fiuba.redsocedu.datalayer.ws.DataServiceStub.RollbackResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rollback operation
           */
            public void receiveErrorrollback(java.lang.Exception e) {
            }
                


    }
    