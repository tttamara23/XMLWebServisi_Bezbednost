package soapservices;

import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.jaxws.handler.soap.SOAPMessageContextImpl;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

public class MyInterceptor implements ClientInterceptor {

	@Override
	public boolean handleRequest(MessageContext messageContext)
			throws WebServiceClientException {
		
		SaajSoapMessage messageSOAP = (SaajSoapMessage) messageContext.getRequest();
	
		SoapBody soapBody = messageSOAP.getSoapBody();
		System.out.println("ASDJAKSL");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleResponse(MessageContext messageContext)
			throws WebServiceClientException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleFault(MessageContext messageContext)
			throws WebServiceClientException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Exception ex)
			throws WebServiceClientException {
		// TODO Auto-generated method stub

	}

}
