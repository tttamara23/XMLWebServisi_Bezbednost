package pi.vezbe.ws;

import glavna.wsdl.SmestajRequest;
import glavna.wsdl.SmestajResponse;
import glavna.wsdl.TestRequest;
import glavna.wsdl.TestResponse;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import pi.vezbe.dto.SmestajDTO;

public class WSClient extends WebServiceGatewaySupport {
	private static final String URI = "http://localhost:1234/ws";
	
	public TestResponse testWS(String text) {
		TestRequest request = new TestRequest();
		request.setName(text);
		TestResponse response = (TestResponse) getWebServiceTemplate().marshalSendAndReceive(URI , request, new SoapActionCallback(URI + "/testRequest"));
		return response;
	}
	
	public SmestajResponse smestajWS(SmestajDTO smestaj) throws IOException  {
		SmestajRequest request = new SmestajRequest();
		request.setNaziv(smestaj.getNaziv());
		request.setOpis(smestaj.getOpis());
		request.setLokacija(smestaj.getLokacija());
		request.setTip(smestaj.getTip());
		//String aa = jaxbObjectToXML(request); // pretvara objekat u xml string
	//	stringToDom(aa); // pravi xml fajl od xml stringa
		SmestajResponse response = (SmestajResponse) getWebServiceTemplate().marshalSendAndReceive(URI ,
				request, new SoapActionCallback(URI + "/smestajRequest"));
		return response;
	}
	
	/*private static String jaxbObjectToXML(SmestajRequest customer) {
	    String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(SmestajRequest.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(customer, sw);
	        xmlString = sw.toString();

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}
	
	public static void stringToDom(String xmlSource) 
	        throws IOException {
	    java.io.FileWriter fw = new java.io.FileWriter("my-file.xml");
	    fw.write(xmlSource);
	    fw.close();
	}*/
	
	
	
}
