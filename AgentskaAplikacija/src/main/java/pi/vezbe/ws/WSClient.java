package pi.vezbe.ws;

import glavna.wsdl.AccommodationXML;
import glavna.wsdl.DBRequestType;
import glavna.wsdl.GetDBRequest;
import glavna.wsdl.GetDBResponse;
import glavna.wsdl.LogInRequest;
import glavna.wsdl.LogInResponse;
import glavna.wsdl.PonudaRequest;
import glavna.wsdl.PonudaResponse;
import glavna.wsdl.PonudaXML;
import glavna.wsdl.PorukaRequest;
import glavna.wsdl.PorukaResponse;
import glavna.wsdl.PorukaXML;
import glavna.wsdl.PotvrdiRequest;
import glavna.wsdl.PotvrdiResponse;
import glavna.wsdl.RezXML;
import glavna.wsdl.SlikaXML;
import glavna.wsdl.SmestajRequest;
import glavna.wsdl.SmestajResponse;
import glavna.wsdl.SmestajVlasnikRequest;
import glavna.wsdl.SmestajVlasnikResponse;
import glavna.wsdl.SmestajVlasnikXML;
import glavna.wsdl.TestRequest;
import glavna.wsdl.TestResponse;
import glavna.wsdl.TipSmestajaXML;
import glavna.wsdl.UserXML;
import glavna.wsdl.ZauzetostRequest;
import glavna.wsdl.ZauzetostResponse;
import glavna.wsdl.ZauzetostXML;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import pi.vezbe.converters.SmestajDTOToSmestajConverter;
import pi.vezbe.converters.TipSmestajaDTOToTipSmestajaConverter;
import pi.vezbe.converters.XMLConverter;
import pi.vezbe.dto.LoginDTO;
import pi.vezbe.dto.PorukaChatDTO;
import pi.vezbe.dto.PorukaDTO;
import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.dto.ZauzimanjeTerminaDTO;
import pi.vezbe.model.Ponuda;
import pi.vezbe.model.Poruka;
import pi.vezbe.model.Smestaj;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.service.PonudaService;
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
	
	public PonudaResponse ponudaWS(Ponuda ponuda){
		PonudaRequest request = new PonudaRequest();
		PonudaXML ponudaXML = new PonudaXML();
		ponudaXML.setBrojLezaja(ponuda.getBrojLezaja());
		ponudaXML.setBrojSlobodnihPonuda(ponuda.getBrojSlobodnihPonuda());

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ponudaXML.setDatumDo(dateFormat.format(ponuda.getDatumDo()));
		ponudaXML.setDatumOd(dateFormat.format(ponuda.getDatumOd()));
		ponudaXML.setCena(Double.parseDouble((ponuda.getCena().toString())));
		ponudaXML.setSmestajId(ponuda.getSmestaj().getId());
		request.setPonuda(ponudaXML);
		PonudaResponse response = (PonudaResponse) getWebServiceTemplate().marshalSendAndReceive(URI , 
				request, new SoapActionCallback(URI + "/ponudaRequest"));

		return response;
	}
	
	public ZauzetostResponse zauzetostWS(ZauzimanjeTerminaDTO zauzimanjeDTO){
		ZauzetostRequest request = new ZauzetostRequest();
		ZauzetostXML zauzetostXML = new ZauzetostXML();
		
		zauzetostXML.setIdPonude(zauzimanjeDTO.getIdTermina());
		zauzetostXML.setBrojSoba(zauzimanjeDTO.getBrojSoba());
		request.setZauzetost(zauzetostXML);
		
		ZauzetostResponse response = (ZauzetostResponse) getWebServiceTemplate().marshalSendAndReceive(URI , 
				request, new SoapActionCallback(URI + "/zauzetostRequest"));

		return response;
	}
	
	public PorukaResponse porukaWS(PorukaChatDTO porukaChatDTO){
		PorukaRequest request = new PorukaRequest();
		request.setPoruka(new PorukaXML());
		
		request.getPoruka().setIdChata(new Long(porukaChatDTO.getIdChat()));
		request.getPoruka().setSadrzaj(porukaChatDTO.getSadrzajPoruke());
		
		request.getPoruka().setIdPosiljaoca(4L);;
		request.getPoruka().setDatumSlanja("");
		request.getPoruka().setSeen(false);
		PorukaResponse response = (PorukaResponse) getWebServiceTemplate().marshalSendAndReceive(URI , 
				request, new SoapActionCallback(URI + "/ponudaRequest"));

		return response;
	}
	public SmestajVlasnikResponse smestajVlasnikWS(SmestajVlasnikXML SmestajVlasnikXML){
		SmestajVlasnikRequest request = new SmestajVlasnikRequest();
		request.setSvRequest(new SmestajVlasnikXML());
		request.getSvRequest().setIdSmestaja(SmestajVlasnikXML.getIdSmestaja());
		request.getSvRequest().setIdVlasnika(SmestajVlasnikXML.getIdVlasnika());
		SmestajVlasnikResponse response = (SmestajVlasnikResponse) getWebServiceTemplate().marshalSendAndReceive(URI ,
				request, new SoapActionCallback(URI + "/smestajVlasnikRequest"));
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
		for(int i=0; i< smestaj.getSlike().size(); i++){
			SlikaXML slika = new SlikaXML();
			slika.setUrl(smestaj.getSlike().get(i));
			smestajXML.getSlike().add(slika);
		}
		smestajXML.setLokacija(smestaj.getLokacija());
		smestajXML.setNaziv(smestaj.getNaziv());
		smestajXML.setOpis(smestaj.getOpis());
		smestajXML.setKategorijaSmestaja(smestaj.getKategorija());
		if(smestaj.getUsluge()!=null){
			for(int i = 0; i<smestaj.getUsluge().size(); i++){
				smestajXML.getUsluge().add(smestaj.getUsluge().get(i).getId());
			}
		}
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
	
	public PotvrdiResponse potvrdiRezervacijuWS(String id){
		PotvrdiRequest rez = new PotvrdiRequest();
		RezXML rezXML = new RezXML();
		rezXML.setId(new Long(id));
		rez.setId(rezXML);
		PotvrdiResponse response = (PotvrdiResponse) getWebServiceTemplate().marshalSendAndReceive(URI ,
				rez, new SoapActionCallback(URI + "/potvrdi"));
		return response;
	
	}
	
	public GetDBResponse getDBRequest(List<DBRequestType> type){
		GetDBRequest request = new GetDBRequest();
		request.getType().addAll(type);
	
		GetDBResponse response = (GetDBResponse) getWebServiceTemplate().marshalSendAndReceive(URI ,
				request, new SoapActionCallback(URI + "/getDBRequest"));
		return response;
	}
	
	
	
	
	
}

