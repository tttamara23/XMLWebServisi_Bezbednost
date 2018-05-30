package pi.vezbe.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.AgentDtoToAgentConverter;
import pi.vezbe.dto.AgentDTO;
import pi.vezbe.model.Agent;
import pi.vezbe.model.Komentar;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.service.AgentService;
import pi.vezbe.service.EmailService;
import pi.vezbe.service.KomentarService;
import pi.vezbe.service.UserService;

@RestController()
@RequestMapping(value = "/administrator")
public class AdminisrtatorController {
	
	@Autowired
	private AgentDtoToAgentConverter agentDtoToAgentConverter;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
    private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KomentarService komentarService;
	
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
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
        agentToSave.setLozinka(getSaltString());
        Agent saved = agentService.save(agentToSave);
        
        emailService.getMail().setTo(agentToSave.getEmail());
        emailService.getMail().setFrom(emailService.getEnv().getProperty("spring.mail.username"));
        emailService.getMail().setSubject("Setting password for your account");
        emailService.getMail().setText("Hello " + agentToSave.getIme() + ",\n\nThis is your new password:\n\n" + saved.getLozinka() + "");
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
	
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
            value = "showUsers",
            method = RequestMethod.GET
    )
    public List<KrajnjiKorisnik> showUsers() {
		List<KrajnjiKorisnik> lista = userService.findAll();
		
		return lista;
    }
	
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
            value = "blokiraj",
            method = RequestMethod.POST
    )
    public boolean blokiraj(@RequestBody String id) {
		KrajnjiKorisnik zaBlok = userService.findRegisteredByEmail(id);
		if(zaBlok!=null){
			zaBlok.setBlokiran(true);
			KrajnjiKorisnik saved = userService.save(zaBlok);
			return true;	
		}
		
		return false;
    }
	
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
            value = "aktiviraj",
            method = RequestMethod.POST
    )
    public boolean aktiviraj(@RequestBody String id) {
		KrajnjiKorisnik zaAktivaciju = userService.findRegisteredByEmail(id);
		if(zaAktivaciju!=null){
			zaAktivaciju.setBlokiran(false);
			KrajnjiKorisnik saved = userService.save(zaAktivaciju);
			return true;	
		}
		
		return false;
    }
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
            value = "ukloni",
            method = RequestMethod.POST
    )
    public boolean ukloni(@RequestBody String id) {
		KrajnjiKorisnik zaBrisanje = userService.findRegisteredByEmail(id);
		if(zaBrisanje!=null){
			userService.delete(zaBrisanje);
			
			return true;	
		}
		
		return false;
    }
	
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
            value = "showComments",
            method = RequestMethod.GET
    )
    public List<Komentar> showComments() {
		List<Komentar> lista = komentarService.findAllComments();
		
		return lista;
    }
	
	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(
            value = "objaviKomentar",
            method = RequestMethod.POST
    )
    public boolean objaviKomentar(@RequestBody String id) {
		Komentar zaObjavljivanje = komentarService.findById(id);
		if(zaObjavljivanje!=null){
			zaObjavljivanje.setObjavljen(true);
			Komentar saved = komentarService.save(zaObjavljivanje);
			return true;	
		}
		
		return false;
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
