package pi.vezbe.controller;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.annotations.PermissionAnnotation;
import pi.vezbe.converters.AgentDtoToAgentConverter;
import pi.vezbe.converters.AgentToAgentDTOConverter;
import pi.vezbe.converters.KategorijaSmestajaDTOToKategorijaSmestajaConverter;
import pi.vezbe.converters.KategorijaSmestajaToKategorijaSmestajaDTOConverter;
import pi.vezbe.converters.KomentarToKomentarDTOConverter;
import pi.vezbe.converters.KrajnjiKorisnikToKrajnjiKorisnikDTO;
import pi.vezbe.converters.TipSmestajaDTOToTipSmestajaConverter;
import pi.vezbe.converters.TipSmestajaToTipSmestajaDTO;
import pi.vezbe.converters.UslugaDTOToUslugaConverter;
import pi.vezbe.converters.UslugaToUslugaDtoConverter;
import pi.vezbe.dto.AgentDTO;
import pi.vezbe.dto.KategorijaSmestajaDTO;
import pi.vezbe.dto.KomentarDTO;
import pi.vezbe.dto.KrajnjiKorisnikDTO;
import pi.vezbe.dto.TipSmestajaDTO;
import pi.vezbe.dto.UslugaDTO;
import pi.vezbe.model.Agent;
import pi.vezbe.model.KategorijaSmestaja;
import pi.vezbe.model.Komentar;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.model.Usluga;
import pi.vezbe.service.AgentService;
import pi.vezbe.service.EmailService;
import pi.vezbe.service.KategorijaSmestajaService;
import pi.vezbe.service.KomentarService;
import pi.vezbe.service.RandomString;
import pi.vezbe.service.TipSmestajaService;
import pi.vezbe.service.UserService;
import pi.vezbe.service.UslugaService;

@RestController()
@RequestMapping(value = "/administrator")
public class AdminisrtatorController {
	
	@Autowired
	private KrajnjiKorisnikToKrajnjiKorisnikDTO krajnjiKorisnikToKrajnjiKorisnikDTO;
	
	@Autowired
	private AgentDtoToAgentConverter agentDtoToAgentConverter;
	
	@Autowired
	private TipSmestajaDTOToTipSmestajaConverter tipSmestajaDTOToTipSmestajaConverter;
	
	@Autowired
	private TipSmestajaToTipSmestajaDTO tipSmestajaToTipSmestajaDTOConverter;
	
	@Autowired
	private KategorijaSmestajaDTOToKategorijaSmestajaConverter kategorijaSmestajaDTOToKategorijaSmestajaConverter;
	
	@Autowired
	private KategorijaSmestajaToKategorijaSmestajaDTOConverter kategorijaSmestajaToKategorijaSmestajaDTOConverter;
	
	@Autowired
	private UslugaDTOToUslugaConverter dodatneUslugeDTOToDodatneUslugeConverter;
	
	@Autowired
	private AgentToAgentDTOConverter agentToAgentDTOConverter;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
    private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KomentarService komentarService;
	
	@Autowired
	private TipSmestajaService tipSmestajaService;
	
	@Autowired
	private KategorijaSmestajaService kategorijaSmestajaService;
	
	@Autowired
	private UslugaService dodatneUslugeService;
	
	@Autowired
	private UslugaToUslugaDtoConverter uslugaToUslugaDtoConverter;
	
	@Autowired
	private KomentarToKomentarDTOConverter komentarToKomentarDtoConverter;
	
	private static Logger logger = LogManager.getLogger(AdminisrtatorController.class);
	
	@PermissionAnnotation(name = "INSERT_AGENT")
	@CrossOrigin
	@RequestMapping(
            value = "addAgent",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> addAgent(@RequestBody AgentDTO agentDTO) {
		if(agentDTO.getIme().equals("") || agentDTO.getIme() == null ||
				agentDTO.getPrezime().equals("") || agentDTO.getPrezime() == null ||
				agentDTO.getEmail().equals("") || agentDTO.getEmail() == null ||
				agentDTO.getKontakt().equals("") || agentDTO.getKontakt() == null ||
				agentDTO.getPoslovniMaticniBroj().equals("") || agentDTO.getPoslovniMaticniBroj() == null) {
			return new ResponseEntity<>("Fill in all required entry fields!", HttpStatus.BAD_REQUEST);
		}
		
        Agent agentToSave = agentDtoToAgentConverter.convert(agentDTO);
        byte[] salt = userService.salt();
        agentToSave.setSalt(salt);
        
        RandomString gen = new RandomString(10, ThreadLocalRandom.current());
        String newPassword = gen.nextString();
		
        byte[] hashedPassword = userService.hashPassword(newPassword, salt);
		String lozinkaUneta = "";
		
		for(int i=0; i<hashedPassword.length; i++) {
			lozinkaUneta = lozinkaUneta.concat(Byte.toString(hashedPassword[i]));
		}
		agentToSave.setLozinka(lozinkaUneta);
		
        Agent saved = agentService.save(agentToSave);
        logger.info("Admin " + userService.getCurrentUser().getEmail() + " je dodao agenta " + saved.getEmail());
        emailService.getMail().setTo(agentToSave.getEmail());
        emailService.getMail().setFrom(emailService.getEnv().getProperty("spring.mail.username"));
        emailService.getMail().setSubject("Setting password for your account");
        emailService.getMail().setText("Hello " + agentToSave.getIme() + ",\n\nThis is your new password:\n\n" + newPassword + "");
        try {
			emailService.sendNotificaitionAsync(userService.getCurrentUser());
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PermissionAnnotation(name = "INSERT_TIP_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "addTipSmestaja",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> addTipSmestaja(@RequestBody TipSmestajaDTO tipSmestajaDTO) {
		if(tipSmestajaDTO.getNaziv().equals("") || tipSmestajaDTO.getNaziv() == null)	{
			return new ResponseEntity<>("Fill in all required entry fields!", HttpStatus.BAD_REQUEST);
		}
        TipSmestaja TipToSave = tipSmestajaDTOToTipSmestajaConverter.convert(tipSmestajaDTO);
        @SuppressWarnings("unused")
        TipSmestaja saved = tipSmestajaService.save(TipToSave);
        logger.info("Admin " + userService.getCurrentUser().getEmail() + " je dodao tip smestaja " + saved.getNaziv());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PermissionAnnotation(name = "INSERT_KATEGORIJA_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "addKategorijaSmestaja",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> addKategorijaSmestaja(@RequestBody KategorijaSmestajaDTO kategorijaSmestajaDTO) {
		if(kategorijaSmestajaDTO.getKategorija().equals("") || kategorijaSmestajaDTO.getKategorija() == null)	{
			return new ResponseEntity<>("Fill in all required entry fields!", HttpStatus.BAD_REQUEST);
		}
		KategorijaSmestaja KategorijaToSave = kategorijaSmestajaDTOToKategorijaSmestajaConverter.convert(kategorijaSmestajaDTO);
		@SuppressWarnings("unused")
		KategorijaSmestaja saved = kategorijaSmestajaService.save(KategorijaToSave);
		logger.info("Admin " + userService.getCurrentUser().getEmail() + " je dodao kategoriju smestaja " + saved.getKategorija());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PermissionAnnotation(name = "INSERT_DODATNA_USLUGA")
	@CrossOrigin
	@RequestMapping(
            value = "addDodatneUsluge",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> addDodatneUsluge(@RequestBody UslugaDTO dodatneUslugeDTO) {
		if(dodatneUslugeDTO.getNaziv().equals("") || dodatneUslugeDTO.getNaziv() == null)	{
			return new ResponseEntity<>("Fill in all required entry fields!", HttpStatus.BAD_REQUEST);
		}
		Usluga UslugaToSave = dodatneUslugeDTOToDodatneUslugeConverter.convert(dodatneUslugeDTO);
		@SuppressWarnings("unused")
		Usluga saved = dodatneUslugeService.save(UslugaToSave);
		logger.info("Admin " + userService.getCurrentUser().getEmail() + " je dodao dodatnu uslugu " + saved.getNaziv());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@PermissionAnnotation(name = "GET_USERS")
	@CrossOrigin
	@RequestMapping(
            value = "showUsers",
            method = RequestMethod.GET
    )
    public List<KrajnjiKorisnikDTO> showUsers() {
		List<KrajnjiKorisnik> lista = userService.findAll();
		List<KrajnjiKorisnikDTO> listaDTO = krajnjiKorisnikToKrajnjiKorisnikDTO.convert(lista);
		
		return listaDTO;
    }
	
	@PermissionAnnotation(name = "BLOCK_UNBLOCK_USER")
	@CrossOrigin
	@RequestMapping(
            value = "blokiraj",
            method = RequestMethod.POST
    )
    public boolean blokiraj(@RequestBody String id) {
		KrajnjiKorisnik zaBlok = userService.findRegisteredByEmail(id);
		if(zaBlok!=null){
			zaBlok.setBlokiran(true);
			@SuppressWarnings("unused")
			KrajnjiKorisnik saved = userService.save(zaBlok);
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je blokirao korisnika " + saved.getEmail());
			return true;	
		}
		
		return false;
    }
	
	@PermissionAnnotation(name = "BLOCK_UNBLOCK_USER")
	@CrossOrigin
	@RequestMapping(
            value = "aktiviraj",
            method = RequestMethod.POST
    )
    public boolean aktiviraj(@RequestBody String id) {
		KrajnjiKorisnik zaAktivaciju = userService.findRegisteredByEmail(id);
		if(zaAktivaciju!=null){
			zaAktivaciju.setBlokiran(false);
			@SuppressWarnings("unused")
			KrajnjiKorisnik saved = userService.save(zaAktivaciju);
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je odblokirao korisnika " + saved.getEmail());
			return true;	
		}
		
		return false;
    }
	
	@PermissionAnnotation(name = "DELETE_USER")
	@CrossOrigin
	@RequestMapping(
            value = "ukloni",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> ukloni(@RequestBody String id) {
		KrajnjiKorisnik zaBrisanje = userService.findRegisteredByEmail(id);
		if(zaBrisanje!=null){
			userService.delete(zaBrisanje);
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je obrisao korisnika " + zaBrisanje.getEmail());
			return new ResponseEntity<>(HttpStatus.OK);	
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
    }
	
	@PermissionAnnotation(name = "DELETE_TIP_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "ukloniTipSmestaja",
            method = RequestMethod.POST
    )
    public boolean ukloniTipSmestaja(@RequestBody String id) {
		//Long idSmestaja = Long.parseLong(id);
		TipSmestaja zaBrisanje = tipSmestajaService.findById(id);
		if(zaBrisanje!=null){
			tipSmestajaService.delete(zaBrisanje);
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je obrisao tip smestaja " + zaBrisanje.getNaziv());
			return true;	
		}
		
		return false;
    }
	
	@PermissionAnnotation(name = "DELETE_KATEGORIJA_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "ukloniKategoriju",
            method = RequestMethod.POST
    )
    public boolean ukloniKategoriju(@RequestBody String id) {
		//Long idSmestaja = Long.parseLong(id);
		KategorijaSmestaja zaBrisanje = kategorijaSmestajaService.findById(id);
		if(zaBrisanje!=null){
			kategorijaSmestajaService.delete(zaBrisanje);
			
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je obrisao kategoriju smestaja " + zaBrisanje.getKategorija());
			return true;	
		}
		
		return false;
    }
	
	@PermissionAnnotation(name = "DELETE_DODATNA_USLUGA")
	@CrossOrigin
	@RequestMapping(
            value = "ukloniUslugu",
            method = RequestMethod.POST
    )
    public boolean ukloniUslugu(@RequestBody String id) {
		//Long idSmestaja = Long.parseLong(id);
		Usluga zaBrisanje = dodatneUslugeService.findById(id);
		if(zaBrisanje!=null){
			dodatneUslugeService.delete(zaBrisanje);
			
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je obrisao dodatnu uslugu " + zaBrisanje.getNaziv());
			return true;	
		}
		
		return false;
    }
	
	@PermissionAnnotation(name = "UPDATE_TIP_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "izmeniTipSmestaja",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> izmeniTipSmestaja(@RequestBody String id) {
		//Long idSmestaja = Long.parseLong(id);
		TipSmestaja zaIzmenu = tipSmestajaService.findById(id);
		if(zaIzmenu!=null){
			//tipSmestajaService.delete(zaBrisanje);
			
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je izmenio tip smestaja " + zaIzmenu.getNaziv());
			return new ResponseEntity<>(tipSmestajaToTipSmestajaDTOConverter.convert(zaIzmenu), HttpStatus.OK);
		}
		
		return null;
    }
	
	@PermissionAnnotation(name = "UPDATE_KATEGORIJA_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "izmeniKategoriju",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> izmeniKategoriju(@RequestBody String id) {
		
		KategorijaSmestaja zaIzmenu = kategorijaSmestajaService.findById(id);
		if(zaIzmenu!=null){
			
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je izmenio kategoriju smestaja " + zaIzmenu.getKategorija());
			return new ResponseEntity<>(kategorijaSmestajaToKategorijaSmestajaDTOConverter.convert(zaIzmenu), HttpStatus.OK);
		}
		
		return null;
    }
	
	@PermissionAnnotation(name = "UPDATE_DODATNA_USLUGA")
	@CrossOrigin
	@RequestMapping(
            value = "izmeniUslugu",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> izmeniUslugu(@RequestBody String id) {
		
		Usluga zaIzmenu = dodatneUslugeService.findById(id);
		if(zaIzmenu!=null){
			
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je izmenio dodatnu uslugu " + zaIzmenu.getNaziv());
			return new ResponseEntity<>(uslugaToUslugaDtoConverter.convert(zaIzmenu), HttpStatus.OK);
		}
		
		return null;
    }
	
	@PermissionAnnotation(name = "GET_ALL_COMMENTS")
	@CrossOrigin
	@RequestMapping(
            value = "showComments",
            method = RequestMethod.GET
    )
    public List<KomentarDTO> showComments() {
		List<Komentar> lista = komentarService.findAllComments();
		List<KomentarDTO> listaDTO = komentarToKomentarDtoConverter.convert(lista);
		return listaDTO;
    }
	
	@PermissionAnnotation(name = "GET_TIP_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "tipSmestaja",
            method = RequestMethod.GET
    )
    public List<TipSmestajaDTO> showTipSmestaja() {
		List<TipSmestaja> lista = tipSmestajaService.findAllTipS();
		
		return tipSmestajaToTipSmestajaDTOConverter.convert(lista);
    }
	
	@PermissionAnnotation(name = "GET_KATEGORIJA_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "kategorijaSmestaja",
            method = RequestMethod.GET
    )
    public List<KategorijaSmestajaDTO> showKategorijaSmestaja() {		
		return kategorijaSmestajaToKategorijaSmestajaDTOConverter.convert(kategorijaSmestajaService.findAllKS());
    }
	
	@PermissionAnnotation(name = "GET_DODATNA_USLUGA")
	@CrossOrigin
	@RequestMapping(
            value = "dodatneUsluge",
            method = RequestMethod.GET
    )
    public List<UslugaDTO> showDodatneUsluge() {		
		return uslugaToUslugaDtoConverter.convert(dodatneUslugeService.findAll());
    }
	
	@PermissionAnnotation(name = "PUBLISH_COMMENTS")
	@CrossOrigin
	@RequestMapping(
            value = "objaviKomentar",
            method = RequestMethod.POST
    )
    public boolean objaviKomentar(@RequestBody String id) {
		Komentar zaObjavljivanje = komentarService.findById(id);
		if(zaObjavljivanje!=null){
			zaObjavljivanje.setObjavljen(true);
			@SuppressWarnings("unused")
			Komentar saved = komentarService.save(zaObjavljivanje);
			logger.info("Admin " + userService.getCurrentUser().getEmail() + " je objavio komentar #" + saved.getId());
			return true;	
		}
		
		return false;
    }
	
	@PermissionAnnotation(name = "UPDATE_TIP_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "/sacuvajIzmenuTipaSmestaja",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> sacuvajIzmenuTipaSmestaja(@RequestBody TipSmestaja tipSmestaja) {
		@SuppressWarnings("unused")
		TipSmestaja saved = tipSmestajaService.save(tipSmestaja);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PermissionAnnotation(name = "UPDATE_KATEGORIJA_SMESTAJA")
	@CrossOrigin
	@RequestMapping(
            value = "/sacuvajIzmenuKategorijeSmestaja",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> sacuvajIzmenuKategorijeSmestaja(@RequestBody KategorijaSmestaja ks) {
		@SuppressWarnings("unused")
		KategorijaSmestaja saved = kategorijaSmestajaService.save(ks);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PermissionAnnotation(name = "UPDATE_DODATNA_USLUGA")
	@CrossOrigin
	@RequestMapping(
            value = "/sacuvajIzmenuUsluge",
            method = RequestMethod.POST
    )
	public ResponseEntity<?> sacuvajIzmenuUsluge(@RequestBody Usluga usluga) {
		@SuppressWarnings("unused")
		Usluga saved = dodatneUslugeService.save(usluga);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
