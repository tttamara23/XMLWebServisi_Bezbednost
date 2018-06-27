package pi.vezbe.config;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pi.vezbe.service.SmestajService;
import pi.vezbe.ws.WSClient;
import soapservices.LodgingWebService;

/*
@Configuration
public class ServiceConfig {
	
	@Bean
	public SmestajService getSmestajService() {
		LodgingWebService service = new LodgingWebService();
		SmestajService sservice = service.getLodgingServicePort();
		setUpInterceptors(sservice);
		return sservice;
	}
	
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		SpringBus springBus = new SpringBus();
		springBus.getInInterceptors().add(getWSS4JInInterceptor());
		springBus.getOutInterceptors().add(getWSS4JOutInterceptor());
		return springBus;
	}
	
	private void setUpInterceptors(Object o) {
		
		Client client = ClientProxy.getClient(o);
		client.getOutInterceptors().add(getWSS4JOutInterceptor());
		client.getInInterceptors().add(getWSS4JInInterceptor());
	}
	
	@Bean
	public WSS4JOutInterceptor getWSS4JOutInterceptor() {
		Map<String, Object> outProps = new HashMap<String, Object>();
		outProps.put(WSHandlerConstants.ACTION,
				WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE + " " + WSHandlerConstants.ENCRYPT);
		outProps.put(WSHandlerConstants.USER, "a1");
		outProps.put(WSHandlerConstants.SIG_PROP_FILE, "client-crypto.properties");
		outProps.put(WSHandlerConstants.ENC_PROP_FILE, "client-crypto.properties");
		outProps.put(WSHandlerConstants.DEC_PROP_FILE, "client-crypto.properties");
		outProps.put(WSHandlerConstants.ENCRYPTION_USER, "server");
		outProps.put(WSHandlerConstants.SIGNATURE_PARTS,
				"{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body");
		outProps.put(WSHandlerConstants.ENCRYPTION_PARTS,
				"{Element}{http://www.w3.org/2000/09/xmldsig#}Signature;{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");
		outProps.put(WSHandlerConstants.ENC_SYM_ALGO, "http://www.w3.org/2001/04/xmlenc#tripledes-cbc");
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientPasswordCallback.class.getName());

		return new WSS4JOutInterceptor(outProps);
	}
	
	@Bean
	public WSS4JInInterceptor getWSS4JInInterceptor() {
		Map<String, Object> inProps = new HashMap<String, Object>();
		inProps.put(WSHandlerConstants.ACTION, 
				WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE + " " + WSHandlerConstants.ENCRYPT);
		inProps.put(WSHandlerConstants.SIG_PROP_FILE, "client-crypto.properties");
		inProps.put(WSHandlerConstants.DEC_PROP_FILE, "client-crypto.properties");
		inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientPasswordCallback.class.getName());

		return new WSS4JInInterceptor(inProps);
	}
	
}*/
