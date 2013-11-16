
package ar.fiuba.redsocedu.datalayer.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "DataService", targetNamespace = "http://ws.datalayer.redsocedu.fiuba.ar/", wsdlLocation = "http://192.168.43.178:8080/rsedatos/rsedatos?wsdl")
public class DataService
    extends Service
{

    private final static URL DATASERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ar.fiuba.redsocedu.datalayer.ws.DataService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = ar.fiuba.redsocedu.datalayer.ws.DataService.class.getResource(".");
            url = new URL(baseUrl, "http://192.168.43.178:8080/rsedatos/rsedatos?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://192.168.43.178:8080/rsedatos/rsedatos?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        DATASERVICE_WSDL_LOCATION = url;
    }

    public DataService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DataService() {
        super(DATASERVICE_WSDL_LOCATION, new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "DataService"));
    }

    /**
     * 
     * @return
     *     returns IData
     */
    @WebEndpoint(name = "DataPort")
    public IData getDataPort() {
        return super.getPort(new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "DataPort"), IData.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IData
     */
    @WebEndpoint(name = "DataPort")
    public IData getDataPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.datalayer.redsocedu.fiuba.ar/", "DataPort"), IData.class, features);
    }

}
