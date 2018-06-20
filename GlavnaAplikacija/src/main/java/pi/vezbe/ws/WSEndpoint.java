package pi.vezbe.ws;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pi.vezbe.converters.SmestajDTOToSmestajConverter;
import pi.vezbe.converters.SmestajToSmestajDtoConverter;
import pi.vezbe.converters.UslugaDTOToUslugaConverter;
import pi.vezbe.converters.UslugaToUslugaDtoConverter;
import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.model.KategorijaSmestaja;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.Role;
import pi.vezbe.model.Smestaj;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.service.KategorijaSmestajaService;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.TipSmestajaService;
import pi.vezbe.service.UserService;

import com.xml.booking.backendmain.ws_classes.AccommodationXML;
import com.xml.booking.backendmain.ws_classes.GetDBRequest;
import com.xml.booking.backendmain.ws_classes.GetDBResponse;
import com.xml.booking.backendmain.ws_classes.KategorijaSmestajaXML;
import com.xml.booking.backendmain.ws_classes.LogInRequest;
import com.xml.booking.backendmain.ws_classes.LogInResponse;
import com.xml.booking.backendmain.ws_classes.SmestajRequest;
import com.xml.booking.backendmain.ws_classes.SmestajResponse;
import com.xml.booking.backendmain.ws_classes.TestRequest;
import com.xml.booking.backendmain.ws_classes.TestResponse;
import com.xml.booking.backendmain.ws_classes.TipSmestajaXML;
import com.xml.booking.backendmain.ws_classes.UserXML;

@Endpoint
public class WSEndpoint {
	private static final String NAMESPACE_URI = "http://booking.xml.com/backendmain/ws-classes";
	
	@Autowired
	private SmestajService smestajService; 
	
	@Autowired
	private TipSmestajaService tipSmestajaService;
	
	@Autowired
	private UslugaDTOToUslugaConverter uslugaConverter;
	
	@Autowired
	private UslugaToUslugaDtoConverter uslugaToUslugaDTO;
	
	@Autowired	
	private SmestajDTOToSmestajConverter smestajDtoToSmestaj ;
	
	@Autowired	
	private SmestajToSmestajDtoConverter smestajToSmestajDTO;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private KategorijaSmestajaService kategorijaSmestajaService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "testRequest")
	@ResponsePayload
	public TestResponse testRequest(@RequestPayload TestRequest request) {
		TestResponse response = new TestResponse();
		response.setName(request.getName().toUpperCase());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "logInRequest")
	@ResponsePayload
	public LogInResponse logINRequest(@RequestPayload LogInRequest request) {
		LogInResponse response = new LogInResponse();
		Korisnik korisnik = userService.findByEmail(request.getUser().getEmail());
		if(!korisnik.getRole().equals(Role.AGENT)) {
			return null;		}
		String enteredPassword = request.getUser().getPassword();
		byte[] salt = korisnik.getSalt();
		byte[] hashForEnteredPassword = userService.hashPassword(enteredPassword, salt);
		if(!korisnik.getLozinka().equals(new String(hashForEnteredPassword))) {
			return null;
		}
		UserXML user = new UserXML();
		user.setEmail(korisnik.getEmail());
		
		response.setUser(user);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DB")
	@ResponsePayload
	public GetDBResponse dbRequest(@RequestPayload GetDBRequest request) {
		GetDBResponse response = new GetDBResponse();
		ArrayList<TipSmestaja> listaTipSmestaja = (ArrayList<TipSmestaja>)tipSmestajaService.findAllTipS();
		for(int i=0; i< listaTipSmestaja.size(); i++){
			TipSmestajaXML tipSmestajaXml = new TipSmestajaXML(); 
			tipSmestajaXml.setId(listaTipSmestaja.get(i).getId());
			tipSmestajaXml.setNaziv(listaTipSmestaja.get(i).getNaziv());
			response.getTipoviSmestaja().set(i, tipSmestajaXml);
		}
		ArrayList<KategorijaSmestaja> listaKategorijaSmestaja = (ArrayList<KategorijaSmestaja>)kategorijaSmestajaService.findAllKS();
		for(int i=0; i< listaKategorijaSmestaja.size(); i++){
			KategorijaSmestajaXML kategorijaSmestajaXml = new KategorijaSmestajaXML(); 
			kategorijaSmestajaXml.setId(listaKategorijaSmestaja.get(i).getId());
			kategorijaSmestajaXml.setKategorija(listaKategorijaSmestaja.get(i).getKategorija());
			response.getKategorijaSmestaja().set(i, kategorijaSmestajaXml);
		}
		
		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "smestajRequest")
	@ResponsePayload
	public SmestajResponse smestajRequest(@RequestPayload SmestajRequest request) {
		SmestajResponse response = new SmestajResponse();
		Smestaj smestajZaUnos = new Smestaj();
		AccommodationXML smestajXML = request.getAccommodation();
		smestajZaUnos.setNaziv(smestajXML.getNaziv());
		smestajZaUnos.setOpis(smestajXML.getOpis());
		smestajZaUnos.setLokacija(smestajXML.getLokacija());
		
		
		TipSmestaja tip = tipSmestajaService.findById("1");
		
		smestajZaUnos.setTipSmestaja(tip);
		
		
		Smestaj saved = smestajService.save(smestajZaUnos);
		if(saved!=null){
			AccommodationXML smestajXML1 = new AccommodationXML();
			smestajXML1.setId(saved.getId());
			smestajXML1.setLokacija(saved.getLokacija());
			smestajXML1.setNaziv(saved.getNaziv());
			smestajXML1.setOpis(saved.getOpis());
			TipSmestajaXML tip2 = new TipSmestajaXML();
			tip2.setId(saved.getTipSmestaja().getId());
			tip2.setNaziv(saved.getTipSmestaja().getNaziv());
			
			smestajXML1.setTipSmestaja(tip2);
			response.setAccommodation(smestajXML1);
			return response;
		}
		
		return null;
	}
	
}
