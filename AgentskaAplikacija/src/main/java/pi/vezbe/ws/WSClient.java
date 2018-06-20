package pi.vezbe.ws;

import glavna.wsdl.AccommodationXML;
import glavna.wsdl.DBRequestType;
import glavna.wsdl.GetDBRequest;
import glavna.wsdl.GetDBResponse;
import glavna.wsdl.LogInRequest;
import glavna.wsdl.LogInResponse;
import glavna.wsdl.SmestajRequest;
import glavna.wsdl.SmestajResponse;
import glavna.wsdl.TestRequest;
import glavna.wsdl.TestResponse;
import glavna.wsdl.TipSmestajaXML;
import glavna.wsdl.UserXML;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import pi.vezbe.converters.SmestajDTOToSmestajConverter;
import pi.vezbe.converters.TipSmestajaDTOToTipSmestajaConverter;
import pi.vezbe.converters.XMLConverter;
import pi.vezbe.dto.LoginDTO;
import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.model.Smestaj;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.service.TipSmestajaService;

public class WSClient extends WebServiceGatewaySupport {
	private static final String URI = "http://localhost:1234/ws";
	
	private XMLConverter xmlConverter;
	@Autowired
	private SmestajDTOToSmestajConverter smestajDtoToSmestajConverter;
	@Autowired
	private TipSmestajaDTOToTipSmestajaConverter tipDTOtoTip;
	
	@Autowired
	private TipSmestajaService tipSmestajaService;
	
	public TestResponse testWS(String text) {
		TestRequest request = new TestRequest();
		request.setName(text);
		TestResponse response = (TestResponse) getWebServiceTemplate().marshalSendAndReceive(URI , request, new SoapActionCallback(URI + "/testRequest"));
		return response;
	}
	
	public SmestajResponse smestajWS(SmestajDTO smestaj) throws IOException  {
		SmestajRequest request = new SmestajRequest();
		Smestaj uneti = smestajDtoToSmestajConverter.convert(smestaj);
		TipSmestaja tipSmestaja = tipSmestajaService.findByNaziv(smestaj.getTip());
		xmlConverter = new XMLConverter();
		TipSmestajaXML tipXML = xmlConverter.convertTipSmestajaToTipSmestajaXML(tipSmestaja);
		AccommodationXML smestajXML = new AccommodationXML();
		smestajXML.setTipSmestaja(tipXML);
		smestajXML.setLokacija(smestaj.getLokacija());
		smestajXML.setNaziv(smestaj.getNaziv());
		smestajXML.setOpis(smestaj.getOpis());
		request.setAccommodation(smestajXML);
		
		SmestajResponse response = (SmestajResponse) getWebServiceTemplate().marshalSendAndReceive(URI ,
				request, new SoapActionCallback(URI + "/smestajRequest"));
		return response;
	}
	
	public LogInResponse logInWS(LoginDTO agent) {
		LogInRequest request = new LogInRequest();
		UserXML user = new UserXML();
		user.setEmail(agent.getEmail());
		user.setPassword(agent.getPassword());
		request.setUser(user);
		LogInResponse response = (LogInResponse) getWebServiceTemplate().marshalSendAndReceive(URI ,
				request, new SoapActionCallback(URI + "/logInRequest"));
		return response;
		
	}
	
	public GetDBResponse getDBWS(List<DBRequestType> type){
		GetDBRequest request = new GetDBRequest();
		request.getType().addAll(type);
	
		GetDBResponse response = (GetDBResponse) getWebServiceTemplate().marshalSendAndReceive(URI ,
				request, new SoapActionCallback(URI + "/DB"));
		return response;
	}
	
	
	
	
	
}
