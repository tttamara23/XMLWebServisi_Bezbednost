package pi.vezbe.controller;

import glavna.wsdl.AccommodationXML;
import glavna.wsdl.ChatKorisnikXML;
import glavna.wsdl.ChatXML;
import glavna.wsdl.DBRequestType;
import glavna.wsdl.GetDBResponse;
import glavna.wsdl.KategorijaSmestajaXML;
import glavna.wsdl.KorisnikXML;
import glavna.wsdl.LogInResponse;
import glavna.wsdl.PonudaXML;
import glavna.wsdl.PonudauslugaXML;
import glavna.wsdl.PorukaXML;
import glavna.wsdl.RezervacijaXML;
import glavna.wsdl.SmestajVlasnikXML;
import glavna.wsdl.TipSmestajaXML;
import glavna.wsdl.UslugaXML;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.dto.ChangePasswordDTO;
import pi.vezbe.dto.LoggedInUserDTO;
import pi.vezbe.dto.LoginDTO;
import pi.vezbe.model.Agent;
import pi.vezbe.model.Chat;
import pi.vezbe.model.ChatKorisnik;
import pi.vezbe.model.KategorijaSmestaja;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.model.Ponuda;
import pi.vezbe.model.PonudaUsluga;
import pi.vezbe.model.Poruka;
import pi.vezbe.model.Rezervacija;
import pi.vezbe.model.Role;
import pi.vezbe.model.Smestaj;
import pi.vezbe.model.SmestajVlasnik;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.model.Usluga;
import pi.vezbe.service.AgentService;
import pi.vezbe.service.ChatKorisnikService;
import pi.vezbe.service.ChatService;
import pi.vezbe.service.KategorijaSmestajaService;
import pi.vezbe.service.PonudaService;
import pi.vezbe.service.PonudaUslugaService;
import pi.vezbe.service.PorukaService;
import pi.vezbe.service.RezervacijaService;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.SmestajVlasnikService;
import pi.vezbe.service.TipSmestajaService;
import pi.vezbe.service.UserService;
import pi.vezbe.service.UslugaService;
import pi.vezbe.ws.WSClient;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WSClient wsClient;
	
	@Autowired
	private TipSmestajaService tipSmestajaService;
	
	@Autowired	
	private KategorijaSmestajaService kategorijaSmestajaService;
	
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired 
	private UslugaService uslugeService;
	
	@Autowired
	private PonudaUslugaService ponudaUslugaService;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private PorukaService porukaService;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private AgentService agentService;

	@Autowired
	private ChatKorisnikService chatKorisnikService;
	
	@Autowired
	private SmestajVlasnikService smestajVlasnikService;
	
	@CrossOrigin
	@RequestMapping(
            value = "/loginAgent",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> loginAgent(@RequestBody LoginDTO loginDTO) throws ParseException {
		LogInResponse response  = wsClient.logInWS(loginDTO);
		if(response==null){
			return new ResponseEntity<>("Email or password incorrect!", HttpStatus.BAD_REQUEST);
		}
		String email = response.getUser().getEmail();
		getDB(email);
		Korisnik ulogovani = userService.findByEmail(email);
		userService.setCurrentUser(ulogovani);
		Korisnik ulogovani2 = userService.getCurrentUser();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public boolean getDB(String email) throws ParseException{
		ArrayList<DBRequestType> requestTypes = new ArrayList<DBRequestType>();
		requestTypes.add(DBRequestType.KATEGORIJA);
		requestTypes.add(DBRequestType.TIP);
		
		GetDBResponse response  = wsClient.getDBRequest(requestTypes);
		ArrayList<TipSmestajaXML> listaTipSmestaja =(ArrayList<TipSmestajaXML>) response.getTipoviSmestaja();
		for(int i=0; i< listaTipSmestaja.size(); i++){
			TipSmestaja tipSmestaja = new TipSmestaja(); 
			tipSmestaja.setId(listaTipSmestaja.get(i).getId());
			tipSmestaja.setNaziv(listaTipSmestaja.get(i).getNaziv());
			tipSmestajaService.save(tipSmestaja);
		}
		ArrayList<KategorijaSmestajaXML> listaKategorijaSmestaja =(ArrayList<KategorijaSmestajaXML>) response.getKategorijaSmestaja();
		for(int i=0; i< listaKategorijaSmestaja.size(); i++){
			KategorijaSmestaja kategorijaSmestaja = new KategorijaSmestaja(); 
			kategorijaSmestaja.setId(listaKategorijaSmestaja.get(i).getId());
			kategorijaSmestaja.setKategorija(listaKategorijaSmestaja.get(i).getKategorija());
			kategorijaSmestajaService.save(kategorijaSmestaja);
		}
		ArrayList<KorisnikXML> korisnici = (ArrayList<KorisnikXML>) response.getKorisnici();
		for(int i=0; i< korisnici.size(); i++){
			
			if(korisnici.get(i).getIdrole() == new Long(1L)){
				KrajnjiKorisnik kor = new KrajnjiKorisnik(korisnici.get(i).getId(),
						korisnici.get(i).getIme(), korisnici.get(i).getPrezime(),
						korisnici.get(i).getEmail(),"", korisnici.get(i).getKontakt(),
						false);
				
				userService.save(kor);
			}
			if(korisnici.get(i).getIdrole() == new Long(3L)){
				Agent kor = new Agent(korisnici.get(i).getId(),
						korisnici.get(i).getIme(), korisnici.get(i).getPrezime(),
						korisnici.get(i).getEmail(),"", korisnici.get(i).getKontakt(),
						"12345");
				
				userService.save(kor);
			}
		}
		
		ArrayList<AccommodationXML> smestajevi = (ArrayList<AccommodationXML>) response.getSmestajevi();
		for(int i=0; i< smestajevi.size(); i++){
			Smestaj smestaj = new Smestaj();
			smestaj.setId(smestajevi.get(i).getId());
			smestaj.setNaziv(smestajevi.get(i).getNaziv());
			smestaj.setOpis(smestajevi.get(i).getOpis());
			smestaj.setLokacija(smestajevi.get(i).getLokacija());
			TipSmestaja tip = new TipSmestaja();
			tip.setId(smestajevi.get(i).getTipSmestaja().getId());
			tip.setNaziv(smestajevi.get(i).getTipSmestaja().getNaziv());
			smestaj.setTipSmestaja(tip);
			KategorijaSmestaja kat = kategorijaSmestajaService.findByKategorija(smestajevi.get(i).getKategorijaSmestaja());
			smestaj.setKategorijaSmestaja(kat);
			smestajService.save(smestaj);
		}
		
		ArrayList<PonudaXML> ponude = (ArrayList<PonudaXML>) response.getPonude();
		for(int i=0; i< ponude.size(); i++){
			Ponuda ponuda = new Ponuda();
			ponuda.setBrojLezaja(ponude.get(i).getBrojLezaja());
			ponuda.setBrojSlobodnihPonuda(ponude.get(i).getBrojSlobodnihPonuda());
			ponuda.setCena(new BigDecimal(ponude.get(i).getCena()));
			ponuda.setId(ponude.get(i).getId());
			Smestaj smestaj = smestajService.findById(ponude.get(i).getSmestajId());
			ponuda.setSmestaj(smestaj);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ponuda.setDatumDo(dateFormat.parse(ponude.get(i).getDatumDo()));
			ponuda.setDatumOd(dateFormat.parse(ponude.get(i).getDatumOd()));
			ponudaService.save(ponuda);
		}
		
		ArrayList<UslugaXML> usluge = (ArrayList<UslugaXML>) response.getUsluge();
		for(int i=0; i< usluge.size(); i++){
			Usluga usl = new Usluga();
			usl.setId(usluge.get(i).getId());
			usl.setNaziv(usluge.get(i).getNaziv());
			uslugeService.save(usl);
		}
		
		ArrayList<PonudauslugaXML> ponUsl = (ArrayList<PonudauslugaXML>) response.getPonudeusluge();
		for(int i=0; i< ponUsl.size(); i++){
			PonudaUsluga pon = new PonudaUsluga();
			pon.setId(ponUsl.get(i).getId());
			Ponuda p = ponudaService.findOne(ponUsl.get(i).getPonudaid());
			pon.setPonuda(p);
			Usluga u = uslugeService.findById(ponUsl.get(i).getUslugaid());
			pon.setUsluga(u);
			ponudaUslugaService.save(pon);
				
		}
		
		ArrayList<RezervacijaXML> rezervacijeXML = (ArrayList<RezervacijaXML>) response.getRezervacije();
		for(int i = 0; i < rezervacijeXML.size(); i++){
			Rezervacija rezervacija = new Rezervacija();
			rezervacija.setId(rezervacijeXML.get(i).getId());
			KrajnjiKorisnik korisnik = userService.findKrajnjiKorisnikById(rezervacijeXML.get(i).getIdKorisnika());
			
			rezervacija.setKorisnik(korisnik);
			rezervacija.setRealizovano(rezervacijeXML.get(i).isRealizovana());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rezervacija.setDatumRezervacije(dateFormat.parse(rezervacijeXML.get(i).getDatumRezervacije()));
			Ponuda ponuda = ponudaService.findOne(rezervacijeXML.get(i).getIdPonude());
			rezervacija.setPonuda(ponuda);
			rezervacijaService.save(rezervacija);
			
		}
		
		ArrayList<ChatXML> chatoviXML = (ArrayList<ChatXML>) response.getChatovi();
		for(int i = 0; i < chatoviXML.size(); i++){
			Chat chat = new Chat();
			chat.setId(chatoviXML.get(i).getId());
			chatService.save(chat);
		}
		
		ArrayList<ChatKorisnikXML> chatKorisnikListXML = (ArrayList<ChatKorisnikXML>) response.getChatKorisnikList();
		for(int i = 0 ; i < chatKorisnikListXML.size(); i++){
			ChatKorisnik ck = new ChatKorisnik();
			ck.setId(chatKorisnikListXML.get(i).getId());
			ck.setChat(chatService.findById(chatKorisnikListXML.get(i).getIdChata()));
			ck.setUcesnik(userService.findById(chatKorisnikListXML.get(i).getIdKorisnika()));
			chatKorisnikService.save(ck);
		}
		ArrayList<PorukaXML> porukeXML = (ArrayList<PorukaXML>) response.getPoruke();
		for(int i = 0; i < porukeXML.size(); i++){
			Poruka poruka = new Poruka();
			poruka.setId(porukeXML.get(i).getId());
			Chat chatPoruke = chatService.findById(porukeXML.get(i).getIdChata());
			poruka.setChat(chatPoruke);
			Korisnik posiljalac = userService.findById(porukeXML.get(i).getIdPosiljaoca());
			
			poruka.setPosiljalac(posiljalac);
			poruka.setSadrzaj(porukeXML.get(i).getSadrzaj());
			poruka.setSeen(porukeXML.get(i).isSeen());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			poruka.setDatumSlanja(dateFormat.parse(porukeXML.get(i).getDatumSlanja()));
			porukaService.save(poruka);
		}
		
		ArrayList<SmestajVlasnikXML> smestajVlasnikList =  (ArrayList<SmestajVlasnikXML>) response.getSmestajVlasnikList();
		for(int i =0 ; i <smestajVlasnikList.size(); i++){
			SmestajVlasnik smestajVlasnik = new SmestajVlasnik();
			Agent vlasnik = userService.findAgentById(smestajVlasnikList.get(i).getIdVlasnika());
			Smestaj smestaj = smestajService.findById(smestajVlasnikList.get(i).getIdSmestaja());
			smestajVlasnik.setId(smestajVlasnikList.get(i).getId());
			
			smestajVlasnik.setAgent(vlasnik);
			smestajVlasnik.setSmestaj(smestaj);;
			smestajVlasnikService.save(smestajVlasnik);
		}
	
		return true;
	}
	
	@CrossOrigin
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(
            value = "/changePassword",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		Korisnik loggedIn = userService.getCurrentUser();
		if(!loggedIn.getLozinka().equals(changePasswordDTO.getOldPassword())) {
			return new ResponseEntity<>("Incorrect old password!", HttpStatus.BAD_REQUEST);
		}
		
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{10,}";
		if(!changePasswordDTO.getNewPassword().matches(pattern)) {
			return new ResponseEntity<>("Password must be at least ten characters including"
				+ " one uppercase letter, one special character and alphanumeric characters!", HttpStatus.BAD_REQUEST);
		}
		
		if(!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getPasswordConfirm())) {
			return new ResponseEntity<>("Passwords don't match!", HttpStatus.BAD_REQUEST);
		}
		
		loggedIn.setLozinka(changePasswordDTO.getNewPassword());
		userService.save(loggedIn);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PreAuthorize("isAuthenticated()")
    @RequestMapping(
            value = "/logout",
            method = RequestMethod.POST)
    public ResponseEntity<?> signout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@CrossOrigin()
	@PreAuthorize("isAuthenticated()")
    @RequestMapping(
            value = "/getLoggedIn",
            method = RequestMethod.GET)
    public ResponseEntity<?> getLoggedIn(HttpServletResponse response, HttpServletRequest request) {
		Korisnik loggedIn = userService.getCurrentUser();
		response.addCookie(request.getCookies()[0]);
		if(loggedIn == null) {
			return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		}
		String role = "";
		if(loggedIn.getRole().equals(Role.ADMIN)) {
			role = "ADMIN";
		} else if(loggedIn.getRole().equals(Role.AGENT)) {
			role = "AGENT";
		} else if(loggedIn.getRole().equals(Role.REGISTERED)) {
			role = "REGISTERED";
		}
        return new ResponseEntity<>(new LoggedInUserDTO(loggedIn.getIme(), role), HttpStatus.OK);
    }
	
	@CrossOrigin()
	@PreAuthorize("isAuthenticated()")
    @RequestMapping(
            value = "/getReservations",
            method = RequestMethod.POST)
    public ResponseEntity<?> getReservations() {
		Korisnik loggedIn = userService.getCurrentUser();
		
		if(loggedIn == null) {
			return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		}
		List<Rezervacija> korisnickeRezervacije = ((KrajnjiKorisnik)loggedIn).getRezervacije();
		
        return new ResponseEntity<>(korisnickeRezervacije, HttpStatus.OK);
    }

}
