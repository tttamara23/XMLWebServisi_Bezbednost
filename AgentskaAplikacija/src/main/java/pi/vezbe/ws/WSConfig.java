package pi.vezbe.ws;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

import pi.vezbe.config.ClientPasswordCallback;

@Configuration
public class WSConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("glavna.wsdl");
		return marshaller;
	}

	@Bean
	public WSClient backendMainClient(Jaxb2Marshaller marshaller) {
		WSClient client = new WSClient();
		client.setDefaultUri("http://localhost:1234/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		
		return client;
	}
	
	/*public WSS4JOutInterceptor getWSS4JOutInterceptor() {
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
	}*/
	
}
