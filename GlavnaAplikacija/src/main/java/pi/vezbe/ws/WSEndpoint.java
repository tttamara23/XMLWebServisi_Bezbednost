package pi.vezbe.ws;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pi.vezbe.controller.PorukaController;
import pi.vezbe.converters.SmestajDTOToSmestajConverter;
import pi.vezbe.converters.SmestajToSmestajDtoConverter;
import pi.vezbe.converters.UslugaDTOToUslugaConverter;
import pi.vezbe.converters.UslugaToUslugaDtoConverter;
import pi.vezbe.model.Agent;
import pi.vezbe.model.Chat;
import pi.vezbe.model.ChatKorisnik;
import pi.vezbe.model.KategorijaSmestaja;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.Ponuda;
import pi.vezbe.model.PonudaUsluga;
import pi.vezbe.model.Poruka;
import pi.vezbe.model.Rezervacija;
import pi.vezbe.model.Slika;
import pi.vezbe.model.Smestaj;
import pi.vezbe.model.SmestajUsluga;
import pi.vezbe.model.SmestajVlasnik;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.model.Usluga;
import pi.vezbe.service.AgentService;
import pi.vezbe.service.ChatKorisnikService;
import pi.vezbe.service.ChatService;
import pi.vezbe.service.KategorijaSmestajaService;
import pi.vezbe.service.KorisnikService;
import pi.vezbe.service.PonudaService;
import pi.vezbe.service.PonudaUslugaService;
import pi.vezbe.service.PorukaService;
import pi.vezbe.service.RezervacijaService;
import pi.vezbe.service.RoleService;
import pi.vezbe.service.SlikaService;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.SmestajUslugaService;
import pi.vezbe.service.SmestajVlasnikService;
import pi.vezbe.service.TipSmestajaService;
import pi.vezbe.service.UserService;
import pi.vezbe.service.UslugaService;

import com.xml.booking.backendmain.ws_classes.AccommodationXML;
import com.xml.booking.backendmain.ws_classes.ChatKorisnikXML;
import com.xml.booking.backendmain.ws_classes.ChatXML;
import com.xml.booking.backendmain.ws_classes.GetDBRequest;
import com.xml.booking.backendmain.ws_classes.GetDBResponse;
import com.xml.booking.backendmain.ws_classes.KategorijaSmestajaXML;
import com.xml.booking.backendmain.ws_classes.KorisnikXML;
import com.xml.booking.backendmain.ws_classes.LogInRequest;
import com.xml.booking.backendmain.ws_classes.LogInResponse;
import com.xml.booking.backendmain.ws_classes.PonudaRequest;
import com.xml.booking.backendmain.ws_classes.PonudaResponse;
import com.xml.booking.backendmain.ws_classes.PonudaXML;
import com.xml.booking.backendmain.ws_classes.PonudauslugaXML;
import com.xml.booking.backendmain.ws_classes.PorukaRequest;
import com.xml.booking.backendmain.ws_classes.PorukaResponse;
import com.xml.booking.backendmain.ws_classes.PorukaXML;
import com.xml.booking.backendmain.ws_classes.PotvrdiRequest;
import com.xml.booking.backendmain.ws_classes.PotvrdiResponse;
import com.xml.booking.backendmain.ws_classes.RezXML;
import com.xml.booking.backendmain.ws_classes.RezervacijaXML;
import com.xml.booking.backendmain.ws_classes.SmestajRequest;
import com.xml.booking.backendmain.ws_classes.SmestajResponse;
import com.xml.booking.backendmain.ws_classes.SmestajVlasnikRequest;
import com.xml.booking.backendmain.ws_classes.SmestajVlasnikResponse;
import com.xml.booking.backendmain.ws_classes.SmestajVlasnikXML;
import com.xml.booking.backendmain.ws_classes.TestRequest;
import com.xml.booking.backendmain.ws_classes.TestResponse;
import com.xml.booking.backendmain.ws_classes.TipSmestajaXML;
import com.xml.booking.backendmain.ws_classes.UserXML;
import com.xml.booking.backendmain.ws_classes.UslugaXML;
import com.xml.booking.backendmain.ws_classes.ZauzetostRequest;
import com.xml.booking.backendmain.ws_classes.ZauzetostResponse;
import com.xml.booking.backendmain.ws_classes.ZauzetostXML;

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
	private UslugaService uslugaService;
	
	@Autowired 
	private ChatService chatService;

	@Autowired 
	private PorukaService porukaService;
	
	@Autowired 
	private RoleService roleService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private KategorijaSmestajaService kategorijaSmestajaService;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired	
	private KorisnikService korisnikService;
	
	@Autowired
	private PonudaUslugaService ponudaUslugaService;
	
	@Autowired
	private SmestajVlasnikService smestajVlasnikService;
	
	@Autowired
	private ChatKorisnikService chatKorisnikService;
	
	@Autowired
	private SlikaService slikaService;
	

	@Autowired
	private SmestajUslugaService smestajUslugaService;
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ponudaRequest")
	@ResponsePayload
	public PonudaResponse ponudaRequest(@RequestPayload PonudaRequest request) throws ParseException {
		PonudaResponse response = new PonudaResponse();
		response.setPonuda(new PonudaXML());
		
		Ponuda ponuda = new Ponuda();
		ponuda.setBrojLezaja(request.getPonuda().getBrojLezaja());
		ponuda.setBrojSlobodnihPonuda(request.getPonuda().getBrojSlobodnihPonuda());
		ponuda.setCena(new BigDecimal(request.getPonuda().getCena()));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ponuda.setDatumDo(dateFormat.parse(request.getPonuda().getDatumDo()));
		ponuda.setDatumOd(dateFormat.parse(request.getPonuda().getDatumOd()));
		Smestaj smestaj = smestajService.findById(request.getPonuda().getSmestajId());
		
		ponuda.setSmestaj(smestaj);
		
		Ponuda toSave = ponudaService.save(ponuda);
		if(toSave!=null){
			List<SmestajUsluga> smestajUsluge = smestajUslugaService.findAllBySmestajId(smestaj.getId());
			for(SmestajUsluga su : smestajUsluge){
				PonudaUsluga ponudaUsluga = new PonudaUsluga();
				ponudaUsluga.setPonuda(toSave);
				ponudaUsluga.setUsluga(su.getIdUsluge());
				ponudaUslugaService.save(ponudaUsluga);
			}
			
			response.getPonuda().setBrojLezaja(toSave.getBrojLezaja());
			response.getPonuda().setBrojSlobodnihPonuda(toSave.getBrojSlobodnihPonuda());
			response.getPonuda().setCena(Double.parseDouble(toSave.getCena().toString()));
			response.getPonuda().setDatumDo(request.getPonuda().getDatumDo());
			response.getPonuda().setDatumOd(request.getPonuda().getDatumOd());
			response.getPonuda().setSmestajId(request.getPonuda().getSmestajId());
			response.getPonuda().setId(toSave.getId());
			return response;
		}
		
		return null;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "testRequest")
	@ResponsePayload
	public TestResponse testRequest(@RequestPayload TestRequest request) {
		TestResponse response = new TestResponse();
		Long id = new Long(request.getName());
		Rezervacija rez = rezervacijaService.findOne(id);
		rez.setRealizovano(true);
		response.setName(rez.getId().toString());
		rezervacijaService.save(rez);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "logInRequest")
	@ResponsePayload
	public LogInResponse logINRequest(@RequestPayload LogInRequest request) {
		LogInResponse response = new LogInResponse();
		Korisnik korisnik = userService.findByEmail(request.getUser().getEmail());
		if(!korisnik.getRole().getId().equals(3L)) {
			return null;		}
		String enteredPassword = request.getUser().getPassword();
		byte[] salt = korisnik.getSalt();
		byte[] hashForEnteredPassword = userService.hashPassword(enteredPassword, salt);
	
		String lozinkaIzBaze = korisnik.getLozinka();
		String lozinkaUneta = "";
		for(int i=0; i<hashForEnteredPassword.length; i++) {
			lozinkaUneta = lozinkaUneta.concat(Byte.toString(hashForEnteredPassword[i]));
		}
		if(!lozinkaIzBaze.equals(lozinkaUneta)) {
			return null;
		}
		userService.setCurrentUser(korisnik);
		/*if(!korisnik.getLozinka().equals(new String(hashForEnteredPassword))) {
			return null;
		}*/
		UserXML user = new UserXML();
		user.setEmail(korisnik.getEmail());
		user.setPassword(lozinkaUneta);
		response.setUser(user);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDBRequest")
	@ResponsePayload
	public GetDBResponse getDBRequest(@RequestPayload GetDBRequest request) {
		GetDBResponse response = new GetDBResponse();
		ArrayList<TipSmestaja> listaTipSmestaja = (ArrayList<TipSmestaja>)tipSmestajaService.findAllTipS();
		for(int i=0; i< listaTipSmestaja.size(); i++){
			TipSmestajaXML tipSmestajaXml = new TipSmestajaXML(); 
			tipSmestajaXml.setId(listaTipSmestaja.get(i).getId());
			tipSmestajaXml.setNaziv(listaTipSmestaja.get(i).getNaziv());
			response.getTipoviSmestaja().add(tipSmestajaXml);
		}
		ArrayList<KategorijaSmestaja> listaKategorijaSmestaja = (ArrayList<KategorijaSmestaja>)kategorijaSmestajaService.findAllKS();
		for(int i=0; i< listaKategorijaSmestaja.size(); i++){
			KategorijaSmestajaXML kategorijaSmestajaXml = new KategorijaSmestajaXML(); 
			kategorijaSmestajaXml.setId(listaKategorijaSmestaja.get(i).getId());
			kategorijaSmestajaXml.setKategorija(listaKategorijaSmestaja.get(i).getKategorija());
			response.getKategorijaSmestaja().add(kategorijaSmestajaXml);
		}
		
		ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>) korisnikService.findAll();
		for(int i=0; i< korisnici.size(); i++){
			KorisnikXML korisnik = new KorisnikXML();
			korisnik.setId(korisnici.get(i).getId());
			korisnik.setEmail(korisnici.get(i).getEmail());
			korisnik.setIdrole(korisnici.get(i).getRole().getId());
			korisnik.setIme(korisnici.get(i).getIme());
			korisnik.setKontakt(korisnici.get(i).getKontakt());
			korisnik.setPrezime(korisnici.get(i).getPrezime());
			response.getKorisnici().add(korisnik);
		}
		
		ArrayList<Smestaj> smestajevi = (ArrayList<Smestaj>) smestajService.getAll();
		for(int i=0; i< smestajevi.size(); i++){
			AccommodationXML acc = new AccommodationXML();
			acc.setId(smestajevi.get(i).getId());
			acc.setKategorijaSmestaja(smestajevi.get(i).getKategorijaSmestaja().getKategorija());
			acc.setLokacija(smestajevi.get(i).getLokacija());
			acc.setNaziv(smestajevi.get(i).getNaziv());
			acc.setOpis(smestajevi.get(i).getOpis());
			TipSmestajaXML tip = new TipSmestajaXML();
			tip.setId(smestajevi.get(i).getTipSmestaja().getId());
			tip.setNaziv(smestajevi.get(i).getTipSmestaja().getNaziv());
			acc.setTipSmestaja(tip);
			response.getSmestajevi().add(acc);
		}
		
		ArrayList<Ponuda> ponude = (ArrayList<Ponuda>) ponudaService.getAll();
		for(int i=0; i< ponude.size(); i++){
			PonudaXML ponuda = new PonudaXML();
			ponuda.setBrojLezaja(ponude.get(i).getBrojLezaja());
			ponuda.setBrojSlobodnihPonuda(ponude.get(i).getBrojSlobodnihPonuda());
			ponuda.setCena(Double.parseDouble(ponude.get(i).getCena().toString()));
			ponuda.setId(ponude.get(i).getId());
			ponuda.setSmestajId(ponude.get(i).getSmestaj().getId());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ponuda.setDatumDo(dateFormat.format(ponude.get(i).getDatumDo()));
			ponuda.setDatumOd(dateFormat.format(ponude.get(i).getDatumOd()));
			response.getPonude().add(ponuda);
		}
		
		ArrayList<Usluga> usluge = (ArrayList<Usluga>) uslugaService.findAll();
		for(int i=0; i< usluge.size(); i++){
			UslugaXML usluga = new UslugaXML();
			usluga.setId(usluge.get(i).getId());
			usluga.setNaziv(usluge.get(i).getNaziv());
			response.getUsluge().add(usluga);
		}
		
		ArrayList<PonudaUsluga> ponudeusluge = (ArrayList<PonudaUsluga>) ponudaUslugaService.getAll();
		for(int i=0; i< ponudeusluge.size(); i++){
			PonudauslugaXML ponudausluga = new PonudauslugaXML();
			ponudausluga.setId(ponudeusluge.get(i).getId());
			ponudausluga.setPonudaid(ponudeusluge.get(i).getPonuda().getId());
			ponudausluga.setUslugaid(ponudeusluge.get(i).getUsluga().getId());
			response.getPonudeusluge().add(ponudausluga);
		}
		
		ArrayList<Rezervacija> rezervacije = (ArrayList<Rezervacija>) rezervacijaService.findAll();
		for(int i=0;i<rezervacije.size();i++){
			RezervacijaXML rezXML = new RezervacijaXML();
			rezXML.setId(rezervacije.get(i).getId());
			rezXML.setIdKorisnika(rezervacije.get(i).getKorisnik().getId());
			rezXML.setIdPonude(rezervacije.get(i).getPonuda().getId());
			rezXML.setRealizovana(rezervacije.get(i).isRealizovano());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rezXML.setDatumRezervacije(dateFormat.format(rezervacije.get(i).getDatumRezervacije()));
			response.getRezervacije().add(rezXML);
			
		}
		ArrayList<Chat> chatovi = (ArrayList<Chat>) chatService.findAll();
		for(int i=0;i<chatovi.size();i++){
			ChatXML chatXML = new ChatXML();
			chatXML.setId(chatovi.get(i).getId());
			response.getChatovi().add(chatXML);
		}
		
		ArrayList<ChatKorisnik> chatKorisnikList = (ArrayList<ChatKorisnik>) chatKorisnikService.findAll();
		for(ChatKorisnik ck : chatKorisnikList){
			ChatKorisnikXML ckXML = new ChatKorisnikXML();
			ckXML.setId(ck.getId());
			ckXML.setIdChata(ck.getChat().getId());
			ckXML.setIdKorisnika(ck.getUcesnik().getId());
			response.getChatKorisnikList().add(ckXML);
		}
		
		ArrayList<SmestajVlasnik> smestajVlasnikList =  (ArrayList<SmestajVlasnik>) smestajVlasnikService.findAll();
		for(int i = 0; i<smestajVlasnikList.size();i++){
			SmestajVlasnikXML smestajVlasnikXML = new SmestajVlasnikXML();
			smestajVlasnikXML.setId(smestajVlasnikList.get(i).getId());
			smestajVlasnikXML.setIdSmestaja(smestajVlasnikList.get(i).getSmestaj().getId());
			smestajVlasnikXML.setIdVlasnika(smestajVlasnikList.get(i).getAgent().getId());
			response.getSmestajVlasnikList().add(smestajVlasnikXML);
		}
		
		ArrayList<Poruka> poruke = (ArrayList<Poruka>) porukaService.findAll();
		for(int i = 0; i<poruke.size(); i++){
			PorukaXML porukaXML = new PorukaXML();
			porukaXML.setId(poruke.get(i).getId());
			porukaXML.setIdChata(poruke.get(i).getChat().getId());
			porukaXML.setIdPosiljaoca(poruke.get(i).getPosiljalac().getId());
			porukaXML.setSadrzaj(poruke.get(i).getSadrzaj());
			porukaXML.setSeen(poruke.get(i).isSeen());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			porukaXML.setDatumSlanja(dateFormat.format(poruke.get(i).getDatumSlanja()));
			response.getPoruke().add(porukaXML);
		}
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "potvrdi")
	@ResponsePayload
	public PotvrdiResponse potvrdiRezervacijuRequest(@RequestPayload PotvrdiRequest request) {
		PotvrdiResponse response = new PotvrdiResponse();
		Long id = request.getId().getId();
		Rezervacija rez = rezervacijaService.findOne(id);
		rez.setRealizovano(true);
		RezXML rezXML = new RezXML();
		rezXML.setId(rez.getId());
		response.setId(rezXML);
		rezervacijaService.save(rez);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "smestajVlasnikRequest")
	@ResponsePayload
	public SmestajVlasnikResponse smestajVlasnikRequest(@RequestPayload SmestajVlasnikRequest request) {
		
		SmestajVlasnik sv = new SmestajVlasnik();
		Smestaj smestaj = smestajService.findById(request.getSvRequest().getIdSmestaja());
		Agent agent = userService.findAgentById(request.getSvRequest().getIdVlasnika());
		sv.setSmestaj(smestaj);
		sv.setAgent(agent);
		SmestajVlasnik saved = smestajVlasnikService.save(sv);
		if(saved!=null){
			SmestajVlasnikResponse response = new SmestajVlasnikResponse();
			SmestajVlasnikXML sv2 = new SmestajVlasnikXML();
			sv2.setId(saved.getId());
			sv2.setIdSmestaja(saved.getSmestaj().getId());
			sv2.setIdVlasnika(saved.getAgent().getId());
			response.setSvResponse(sv2);
			return response;
		}
		return null;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "porukaRequest")
	@ResponsePayload
	public PorukaResponse porukaRequest(@RequestPayload PorukaRequest request) throws ParseException {
		PorukaResponse response = new PorukaResponse();
		response.setPoruka(new PorukaXML());
		
		Poruka toSave = new Poruka();
		Chat chatPoruke = chatService.findById(request.getPoruka().getIdChata());
		Korisnik posiljalac = userService.findById(request.getPoruka().getIdPosiljaoca());
		toSave.setChat(chatPoruke);
		toSave.setPosiljalac(posiljalac);
		toSave.setSadrzaj(request.getPoruka().getSadrzaj());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		toSave.setDatumSlanja(new Date());
		toSave.setSeen(request.getPoruka().isSeen());
		
		Poruka saved = porukaService.save(toSave);
		if(saved!=null){
			response.getPoruka().setId(saved.getId());
			response.getPoruka().setIdChata(saved.getChat().getId());
			response.getPoruka().setIdPosiljaoca(saved.getPosiljalac().getId());
			response.getPoruka().setDatumSlanja(dateFormat.format(saved.getDatumSlanja()));
			response.getPoruka().setSadrzaj(saved.getSadrzaj());
			response.getPoruka().setSeen(saved.isSeen());
			return response;
		}
		return null;
	}
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "zauzetostRequest")
	@ResponsePayload
	public ZauzetostResponse zauzetostRequest(@RequestPayload ZauzetostRequest request) {
		ZauzetostResponse response = new ZauzetostResponse();
		response.setZauzetost(new ZauzetostXML());
		
		Ponuda toSave = ponudaService.findOne(request.getZauzetost().getIdPonude());
		int brSlobodnih = toSave.getBrojSlobodnihPonuda();
		if(brSlobodnih < request.getZauzetost().getBrojSoba()){
			return null;
		}
		toSave.setBrojSlobodnihPonuda(brSlobodnih - request.getZauzetost().getBrojSoba());
		Ponuda saved = ponudaService.save(toSave);
		if(saved!=null){
			response.getZauzetost().setBrojSoba(request.getZauzetost().getBrojSoba());
			response.getZauzetost().setIdPonude(saved.getId());
			return response;
		}
		return null;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "smestajRequest")
	@ResponsePayload
	public SmestajResponse smestajRequest(@RequestPayload SmestajRequest request) {
		SmestajResponse response = new SmestajResponse();
		Smestaj smestajZaUnos = new Smestaj();
		smestajZaUnos.setUsluga(new ArrayList<Usluga>());
		AccommodationXML smestajXML = request.getAccommodation();
		smestajZaUnos.setNaziv(smestajXML.getNaziv());
		smestajZaUnos.setOpis(smestajXML.getOpis());
		smestajZaUnos.setLokacija(smestajXML.getLokacija());
		
		
		Long a = request.getAccommodation().getTipSmestaja().getId();
		
		TipSmestaja tip = tipSmestajaService.findById(a.toString());
		
		KategorijaSmestaja kat = kategorijaSmestajaService.findByKategorija(request.getAccommodation().getKategorijaSmestaja());
		smestajZaUnos.setKategorijaSmestaja(kat);
		
		smestajZaUnos.setTipSmestaja(tip);
		
		
		Smestaj saved = smestajService.save(smestajZaUnos);
		saved.setSlika(new ArrayList<Slika>());
		//ArrayList<Slika> slike = new ArrayList<Slika>();
		for(int i=0; i< smestajXML.getSlike().size(); i++){
			Slika slika = new Slika();
			slika.setSmestaj(saved);
			slika.setUrl(smestajXML.getSlike().get(i).getUrl());
			//slika.setUrl("aa");
			slikaService.save(slika);
			saved.getSlika().add(slika);
		}
		
		smestajService.save(saved);
		if(saved!=null){
			for(int i=0; i< request.getAccommodation().getUsluge().size(); i++){
				Usluga u = uslugaService.findById(request.getAccommodation().getUsluge().get(i).toString());
				SmestajUsluga smestajUsluga = new SmestajUsluga();
				smestajUsluga.setIdSmestaja(saved);
				smestajUsluga.setIdUsluge(u);
				smestajUslugaService.save(smestajUsluga);
				
			}
			AccommodationXML smestajXML1 = new AccommodationXML();
			smestajXML1.setId(saved.getId());
			smestajXML1.setLokacija(saved.getLokacija());
			smestajXML1.setNaziv(saved.getNaziv());
			smestajXML1.setOpis(saved.getOpis());
			smestajXML1.setKategorijaSmestaja(saved.getKategorijaSmestaja().getKategorija());
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
