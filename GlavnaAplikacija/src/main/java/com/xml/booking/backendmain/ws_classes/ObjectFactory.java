
package com.xml.booking.backendmain.ws_classes;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.xml.booking.backendmain.ws_classes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xml.booking.backendmain.ws_classes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LogInResponse }
     * 
     */
    public LogInResponse createLogInResponse() {
        return new LogInResponse();
    }

    /**
     * Create an instance of {@link UserXML }
     * 
     */
    public UserXML createUserXML() {
        return new UserXML();
    }

    /**
     * Create an instance of {@link LogInRequest }
     * 
     */
    public LogInRequest createLogInRequest() {
        return new LogInRequest();
    }

    /**
     * Create an instance of {@link GetDBResponse }
     * 
     */
    public GetDBResponse createGetDBResponse() {
        return new GetDBResponse();
    }

    /**
     * Create an instance of {@link TipSmestajaXML }
     * 
     */
    public TipSmestajaXML createTipSmestajaXML() {
        return new TipSmestajaXML();
    }

    /**
     * Create an instance of {@link KategorijaSmestajaXML }
     * 
     */
    public KategorijaSmestajaXML createKategorijaSmestajaXML() {
        return new KategorijaSmestajaXML();
    }

    /**
     * Create an instance of {@link TestRequest }
     * 
     */
    public TestRequest createTestRequest() {
        return new TestRequest();
    }

    /**
     * Create an instance of {@link GetDBRequest }
     * 
     */
    public GetDBRequest createGetDBRequest() {
        return new GetDBRequest();
    }

    /**
     * Create an instance of {@link TestResponse }
     * 
     */
    public TestResponse createTestResponse() {
        return new TestResponse();
    }

    /**
     * Create an instance of {@link SmestajResponse }
     * 
     */
    public SmestajResponse createSmestajResponse() {
        return new SmestajResponse();
    }

    /**
     * Create an instance of {@link AccommodationXML }
     * 
     */
    public AccommodationXML createAccommodationXML() {
        return new AccommodationXML();
    }
}
