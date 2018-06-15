package pi.vezbe.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pi.vezbe.model.Smestaj;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.TipSmestajaService;

import com.xml.booking.backendmain.ws_classes.SmestajRequest;
import com.xml.booking.backendmain.ws_classes.SmestajResponse;
import com.xml.booking.backendmain.ws_classes.TestRequest;
import com.xml.booking.backendmain.ws_classes.TestResponse;

@Endpoint
public class WSEndpoint {
	private static final String NAMESPACE_URI = "http://booking.xml.com/backendmain/ws-classes";
	
	@Autowired
	private SmestajService smestajService; 
	
	@Autowired
	private TipSmestajaService tipSmestajaService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "testRequest")
	@ResponsePayload
	public TestResponse testRequest(@RequestPayload TestRequest request) {
		TestResponse response = new TestResponse();
		response.setName(request.getName().toUpperCase());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "smestajRequest")
	@ResponsePayload
	public SmestajResponse smestajRequest(@RequestPayload SmestajRequest request) {
		SmestajResponse response = new SmestajResponse();
		Smestaj smestaj = new Smestaj();
		smestaj.setNaziv(request.getNaziv());
		smestaj.setLokacija(request.getLokacija());
		smestaj.setOpis(request.getOpis());
		smestaj.setTipSmestaja((new TipSmestaja()));
		Smestaj saved = smestajService.save(smestaj);
		if(saved!=null){
			response.setNaziv(saved.getNaziv());
			response.setLokacija(saved.getLokacija());
			response.setOpis(saved.getOpis());
			response.setTip(saved.getTipSmestaja().getNaziv());
		}
		//response.setName(request.getName().toUpperCase());
		return response;
	}
	
}
