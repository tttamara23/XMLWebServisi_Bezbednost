
package pi.vezbe.config;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TestService")
public class TestService
    extends Service
{

    private final static URL TESTSERVICE_WSDL_LOCATION;
    private final static WebServiceException TESTSERVICE_EXCEPTION;
    private final static QName TESTSERVICE_QNAME = new QName("http://booking.xws.ftn.rs/test", "TestService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/services/TestService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TESTSERVICE_WSDL_LOCATION = url;
        TESTSERVICE_EXCEPTION = e;
    }

    public TestService() {
        super(__getWsdlLocation(), TESTSERVICE_QNAME);
    }

    public TestService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TESTSERVICE_QNAME, features);
    }

    public TestService(URL wsdlLocation) {
        super(wsdlLocation, TESTSERVICE_QNAME);
    }

    public TestService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TESTSERVICE_QNAME, features);
    }

    public TestService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TestServiceSoap
     */
    @WebEndpoint(name = "TestServicePort")
    public TestServiceSoap getTestServicePort() {
        return super.getPort(new QName("http://booking.xws.ftn.rs/test", "TestServicePort"), TestServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestServiceSoap
     */
    @WebEndpoint(name = "TestServicePort")
    public TestServiceSoap getTestServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://booking.xws.ftn.rs/test", "TestServicePort"), TestServiceSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TESTSERVICE_EXCEPTION!= null) {
            throw TESTSERVICE_EXCEPTION;
        }
        return TESTSERVICE_WSDL_LOCATION;
    }

}
