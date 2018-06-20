package pi.vezbe.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CXFConfig {

	/*@Autowired
	private SmestajService smestajService;
	
	
	@Bean
	public Endpoint testServiceEndpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), smestajService);
		endpoint.publish("/SmestajService");
		return endpoint;
	}

	
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		SpringBus springBus = new SpringBus();
		springBus.getInInterceptors().add(getWSS4JInInterceptor());
		springBus.getOutInterceptors().add(getWSS4JOutInterceptor());
		return springBus;
	}
	
	private WSS4JInInterceptor getWSS4JInInterceptor() {
		Map<String, Object> inProps = new HashMap<String, Object>();
		inProps.put(WSHandlerConstants.ACTION,
				WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE + " " + WSHandlerConstants.ENCRYPT);
		inProps.put(WSHandlerConstants.SIG_PROP_FILE, "server-crypto.properties");
		inProps.put(WSHandlerConstants.DEC_PROP_FILE, "server-crypto.properties");
		inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ServerPasswordCallback.class.getName());

		return new WSS4JInInterceptor(inProps);
	}

	private WSS4JOutInterceptor getWSS4JOutInterceptor() {
		Map<String, Object> outProps = new HashMap<String, Object>();
		outProps.put(WSHandlerConstants.ACTION, 
				WSHandlerConstants.TIMESTAMP + " " + WSHandlerConstants.SIGNATURE + " " + WSHandlerConstants.ENCRYPT);
		outProps.put(WSHandlerConstants.USER, "server");
		outProps.put(WSHandlerConstants.SIG_PROP_FILE, "server-crypto.properties");
		outProps.put(WSHandlerConstants.ENC_PROP_FILE, "server-crypto.properties");
		outProps.put(WSHandlerConstants.ENCRYPTION_USER, WSHandlerConstants.USE_REQ_SIG_CERT);
		outProps.put(WSHandlerConstants.SIGNATURE_PARTS,
				"{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body");
		outProps.put(WSHandlerConstants.ENCRYPTION_PARTS,
				"{Element}{http://www.w3.org/2000/09/xmldsig#}Signature;{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");
		outProps.put(WSHandlerConstants.ENC_SYM_ALGO, WSConstants.TRIPLE_DES);
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ServerPasswordCallback.class.getName());

		return new WSS4JOutInterceptor(outProps);
	}*/
	
}
