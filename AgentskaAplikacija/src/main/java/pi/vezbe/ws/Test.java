package pi.vezbe.ws;

import glavna.wsdl.TestResponse;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
	
	@Autowired
	private WSClient wsClient;
	
	@PostConstruct
	private void init() {
		TestResponse response = wsClient.testWS("test");
		System.out.println(response.getName());
	}
}
