package pi.vezbe.controller;

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
import pi.vezbe.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RezervacijaToRezervacijaDTO rezervacijaToRezervacijaDTO;
	
	@CrossOrigin
	@RequestMapping(
            value = "/register",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
		if(registerDTO.getIme().equals("") || registerDTO.getIme() == null ||
				registerDTO.getPrezime().equals("") || registerDTO.getPrezime() == null ||
				registerDTO.getEmail().equals("") || registerDTO.getEmail() == null ||
				registerDTO.getKontakt().equals("") || registerDTO.getKontakt() == null ||
				registerDTO.getPassword().equals("") || registerDTO.getPassword() == null ||
				registerDTO.getPasswordConfirm().equals("") || registerDTO.getPasswordConfirm() == null) {
			return new ResponseEntity<>("Fill in all required entry fields!", HttpStatus.BAD_REQUEST);
		}
		try {
			Korisnik korisnik = userService.findByEmail(registerDTO.getEmail());
		} catch(Exception e) {
			String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{10,}";
			if(!registerDTO.getPassword().matches(pattern)) {
				return new ResponseEntity<>("Password must be at least ten characters including"
					+ " one uppercase letter, one special character and alphanumeric characters!", HttpStatus.BAD_REQUEST);
			}
			
			if(!registerDTO.getPassword().equals(registerDTO.getPasswordConfirm())) {
				return new ResponseEntity<>("Passwords don't match!", HttpStatus.BAD_REQUEST);
			}
			
			KrajnjiKorisnik krajnjiKorisnik = new KrajnjiKorisnik();
			krajnjiKorisnik.setIme(registerDTO.getIme());
			krajnjiKorisnik.setPrezime(registerDTO.getPrezime());
			krajnjiKorisnik.setEmail(registerDTO.getEmail());
			krajnjiKorisnik.setKontakt(registerDTO.getKontakt());
			krajnjiKorisnik.setLozinka(registerDTO.getPassword());
			krajnjiKorisnik.setBlokiran(false);
			
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
			if(!korisnik.getRole().equals(Role.REGISTERED)) {
				return new ResponseEntity<>("You don't have permission to access!", HttpStatus.UNAUTHORIZED);
			}
			if(!korisnik.getLozinka().equals(loginDTO.getPassword())) {
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
			if(!korisnik.getRole().equals(Role.ADMIN)) {
				return new ResponseEntity<>("You don't have permission to access!", HttpStatus.UNAUTHORIZED);
			}
			if(!korisnik.getLozinka().equals(loginDTO.getPassword())) {
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
			if(!korisnik.getRole().equals(Role.AGENT)) {
				return new ResponseEntity<>("You don't have permission to access!", HttpStatus.UNAUTHORIZED);
			}
			if(!korisnik.getLozinka().equals(loginDTO.getPassword())) {
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
		List<RezervacijaDTO> korisnickeRezervacijeDTO = rezervacijaToRezervacijaDTO.convert(korisnickeRezervacije);
        return new ResponseEntity<>(korisnickeRezervacijeDTO, HttpStatus.OK);
    }

}
