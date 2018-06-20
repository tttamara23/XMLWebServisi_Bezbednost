package pi.vezbe.controller;

import glavna.wsdl.DBRequestType;
import glavna.wsdl.GetDBResponse;
import glavna.wsdl.KategorijaSmestajaXML;
import glavna.wsdl.LogInResponse;
import glavna.wsdl.TipSmestajaXML;

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
import pi.vezbe.model.KategorijaSmestaja;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.model.Rezervacija;
import pi.vezbe.model.Role;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.service.KategorijaSmestajaService;
import pi.vezbe.service.TipSmestajaService;
import pi.vezbe.service.UserService;
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
	
	@CrossOrigin
	@RequestMapping(
            value = "/loginAgent",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> loginAgent(@RequestBody LoginDTO loginDTO) {
		LogInResponse response  = wsClient.logInWS(loginDTO);
		if(response==null){
			return new ResponseEntity<>("Email or password incorrect!", HttpStatus.BAD_REQUEST);
		}
		//getDB();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public boolean getDB(){
		ArrayList<DBRequestType> requestTypes = new ArrayList<DBRequestType>();
		requestTypes.add(DBRequestType.KATEGORIJA);
		requestTypes.add(DBRequestType.TIP);
		
		GetDBResponse response  = wsClient.getDBWS(requestTypes);
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
