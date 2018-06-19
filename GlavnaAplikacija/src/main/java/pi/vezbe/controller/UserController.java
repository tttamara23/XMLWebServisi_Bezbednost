package pi.vezbe.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.annotations.PermissionAnnotation;
import pi.vezbe.converters.RezervacijaToRezervacijaDTO;
import pi.vezbe.dto.ChangePasswordDTO;
import pi.vezbe.dto.LoggedInUserDTO;
import pi.vezbe.dto.LoginDTO;
import pi.vezbe.dto.RegisterDTO;
import pi.vezbe.dto.RezervacijaDTO;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.model.Rezervacija;
import pi.vezbe.model.Role;
import pi.vezbe.service.EmailService;
import pi.vezbe.service.RandomString;
import pi.vezbe.service.RoleService;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RezervacijaToRezervacijaDTO rezervacijaToRezervacijaDTO;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RoleService roleService;
	
	
	
	/*@CrossOrigin
	@RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
	public ResponseEntity<?> handle() {
		return new ResponseEntity<>(HttpStatus.OK);
	}*/
	
	@CrossOrigin
	@RequestMapping(
            value = "/register",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
		if(registerDTO.getIme().equals("") || registerDTO.getIme() == null ||
				registerDTO.getPrezime().equals("") || registerDTO.getPrezime() == null ||
				registerDTO.getEmail().equals("") || registerDTO.getEmail() == null ||
				registerDTO.getKontakt().equals("") || registerDTO.getKontakt() == null ) {
			return new ResponseEntity<>("Fill in all required entry fields!", HttpStatus.BAD_REQUEST);
		}
		try {
			Korisnik korisnik = userService.findByEmail(registerDTO.getEmail());
		} catch(Exception e) {
			/*String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{10,}";
			if(!registerDTO.getPassword().matches(pattern)) {
				return new ResponseEntity<>("Password must be at least ten characters including"
					+ " one uppercase letter, one special character and alphanumeric characters!", HttpStatus.BAD_REQUEST);
			}
			
			if(!registerDTO.getPassword().equals(registerDTO.getPasswordConfirm())) {
				return new ResponseEntity<>("Passwords don't match!", HttpStatus.BAD_REQUEST);
			}*/
			RandomString gen = new RandomString(10, ThreadLocalRandom.current());
	        String newPassword = gen.nextString();
			
			KrajnjiKorisnik krajnjiKorisnik = new KrajnjiKorisnik();
			krajnjiKorisnik.setIme(registerDTO.getIme());
			krajnjiKorisnik.setPrezime(registerDTO.getPrezime());
			krajnjiKorisnik.setEmail(registerDTO.getEmail());
			krajnjiKorisnik.setKontakt(registerDTO.getKontakt());
			
			//deo sa hesiranjem lozinke
			
			byte[] salt = userService.salt();
			krajnjiKorisnik.setSalt(salt);
			byte[] hashedPassword = userService.hashPassword(newPassword, salt);
			try {
				krajnjiKorisnik.setLozinka(new String(hashedPassword, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			krajnjiKorisnik.setBlokiran(false);
			
			 try {

		            emailService.getMail().setTo(krajnjiKorisnik.getEmail());
		            emailService.getMail().setFrom(emailService.getEnv().getProperty("spring.mail.username"));
		            emailService.getMail().setSubject("Setting password for your account");
		            emailService.getMail().setText("Hello " + krajnjiKorisnik.getIme() + ",\n\nThis is your new password:\n\n" + newPassword + "");
		            emailService.sendNotificaitionAsync(krajnjiKorisnik);

		            
		        } catch (Exception exc) {
		            exc.printStackTrace();
		            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		        }
			 
			
			userService.save(krajnjiKorisnik);
			
	        return new ResponseEntity<>(HttpStatus.CREATED);
			
		}
		return new ResponseEntity<>("Email exists!", HttpStatus.BAD_REQUEST);
		
    }
	
	@CrossOrigin
	@RequestMapping(
            value = "/loginRegistered",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> loginRegistered(@RequestBody LoginDTO loginDTO, HttpServletResponse response, HttpServletRequest request) {
		try {
			Korisnik korisnik = userService.findByEmail(loginDTO.getEmail());
			if(!korisnik.getRole().equals(roleService.findById(1L))) {
				return new ResponseEntity<>("You don't have permission to access!", HttpStatus.UNAUTHORIZED);
			}
			
			
			/*List<KrajnjiKorisnik> users = userService.findAll();
			for(KrajnjiKorisnik k : users){
				k.setSalt(userService.salt());
				String pass = k.getLozinka();
				byte[] hashedPassword = userService.hashPassword(pass, k.getSalt());
				String hashPass="";
				try {
					hashPass = new String(hashedPassword,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				k.setLozinka(hashPass);
				Korisnik saved = userService.save(k);
			}*/
			
			String enteredPassword = loginDTO.getPassword();
			byte[] salt = korisnik.getSalt();
			byte[] hashForEnteredPassword = userService.hashPassword(enteredPassword, salt);
			String str = new String(hashForEnteredPassword, "UTF-8");
			String str2 = korisnik.getLozinka();
			if(!str2.equals(str)) {
				return new ResponseEntity<>("Email or password incorrect!", HttpStatus.BAD_REQUEST);
			}
			//response.addCookie(request.getCookies()[0]);
			userService.setCurrentUser(korisnik);
		} catch(Exception e) {
			return new ResponseEntity<>("Email or password incorrect!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(
            value = "/loginAdmin",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> loginAdmin(@RequestBody LoginDTO loginDTO) {
		try {
			Korisnik korisnik = userService.findByEmail(loginDTO.getEmail());
			if(!korisnik.getRole().equals(roleService.findById(2L))) {
				return new ResponseEntity<>("You don't have permission to access!", HttpStatus.UNAUTHORIZED);
			}
			String enteredPassword = loginDTO.getPassword();
			byte[] salt = korisnik.getSalt();
			byte[] hashForEnteredPassword = userService.hashPassword(enteredPassword, salt);
			
			String str = new String(hashForEnteredPassword);
			String str2 = korisnik.getLozinka();
			if(!str2.equals(str)) {
				return new ResponseEntity<>("Email or password incorrect!", HttpStatus.BAD_REQUEST);
			}
			userService.setCurrentUser(korisnik);
		} catch(Exception e) {
			return new ResponseEntity<>("Email or password incorrect!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(
            value = "/loginAgent",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> loginAgent(@RequestBody LoginDTO loginDTO) {
		try {
			Korisnik korisnik = userService.findByEmail(loginDTO.getEmail());
			if(!korisnik.getRole().equals(roleService.findById(3L))) {
				return new ResponseEntity<>("You don't have permission to access!", HttpStatus.UNAUTHORIZED);
			}
			String enteredPassword = loginDTO.getPassword();
			byte[] salt = korisnik.getSalt();
			byte[] hashForEnteredPassword = userService.hashPassword(enteredPassword, salt);
			if(!korisnik.getLozinka().equals(new String(hashForEnteredPassword))) {
				return new ResponseEntity<>("Email or password incorrect!", HttpStatus.BAD_REQUEST);
			}
			userService.setCurrentUser(korisnik);
		} catch(Exception e) {
			return new ResponseEntity<>("Email or password incorrect!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(
            value = "/changePassword",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		Korisnik loggedIn = userService.getCurrentUser();
		String oldPassword = changePasswordDTO.getOldPassword();
		byte[] salt = loggedIn.getSalt();
		byte[] hashedOldPassword = userService.hashPassword(oldPassword, salt);
		
		if(!loggedIn.getLozinka().equals(new String(hashedOldPassword))) {
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
		
		loggedIn.setLozinka(new String((userService.hashPassword(changePasswordDTO.getNewPassword(), loggedIn.getSalt()))));
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
		if(loggedIn.getRole().getId().equals(2L)) {
			role = "ADMIN";
		} else if(loggedIn.getRole().getId().equals(3L)) {
			role = "AGENT";
		} else if(loggedIn.getRole().getId().equals(1L)) {
			role = "REGISTERED";
		}
        return new ResponseEntity<>(new LoggedInUserDTO(loggedIn.getIme(), role, loggedIn.getId()), HttpStatus.OK);
    }
	
	@PermissionAnnotation(name = "GET_RESERVATIONS")
	@CrossOrigin()
    @RequestMapping(
            value = "/getReservations",
            method = RequestMethod.GET)
    public ResponseEntity<?> getReservations() {
		Korisnik loggedIn = userService.getCurrentUser();
		
		/*if(loggedIn == null) {
			return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		}*/
		List<Rezervacija> korisnickeRezervacije = ((KrajnjiKorisnik)loggedIn).getRezervacije();
		List<RezervacijaDTO> korisnickeRezervacijeDTO = rezervacijaToRezervacijaDTO.convert(korisnickeRezervacije);
        return new ResponseEntity<>(korisnickeRezervacijeDTO, HttpStatus.OK);
    }
	
	@PermissionAnnotation(name = "CHECK_RESERVATIONS")
	@CrossOrigin()
	@PreAuthorize("isAuthenticated()")
    @RequestMapping(
            value = "/checkReservations/{idSmestaja}",
            method = RequestMethod.POST)
    public ResponseEntity<?> checkReservations(@PathVariable Long idSmestaja) {
		Korisnik loggedIn = userService.getCurrentUser();
		List<Rezervacija> rezervacije = ((KrajnjiKorisnik)loggedIn).getRezervacije();
		
		for(Rezervacija rezervacija : rezervacije){
			if(rezervacija.getPonuda().getSmestaj().getId() == idSmestaja){
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(false, HttpStatus.OK);
    }
	
	@CrossOrigin()
	@PreAuthorize("isAuthenticated()")
    @RequestMapping(
            value = "/hashPasswords",
            method = RequestMethod.GET)
    public ResponseEntity<?> hashPasswords() {
		List<KrajnjiKorisnik> users = userService.findAll();
		for(KrajnjiKorisnik k : users){
			k.setSalt(userService.salt());
			String pass = k.getLozinka();
			byte[] hashedPassword = userService.hashPassword(pass, k.getSalt());
			String hashPass="";
			try {
				hashPass = new String(hashedPassword,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			k.setLozinka(hashPass);
			Korisnik saved = userService.save(k);
		
			
		}
		return new ResponseEntity<>( HttpStatus.OK);
    }

}
