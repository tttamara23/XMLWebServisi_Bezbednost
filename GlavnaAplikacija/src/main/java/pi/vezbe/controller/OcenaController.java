package pi.vezbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.SmestajToSmestajDtoConverter;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.model.Ocena;
import pi.vezbe.model.Smestaj;
import pi.vezbe.service.OcenaService;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.UserService;

@RestController
@RequestMapping(value = "/ocena")
public class OcenaController {
	
	@Autowired
	private OcenaService ocenaService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private SmestajToSmestajDtoConverter converter;
	
	@CrossOrigin
	@RequestMapping(
			value = "/oceniSmestaj/{idSmestaj}/{value}",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> oceniSmestaj(@PathVariable Long idSmestaj, @RequestBody String value) {
		
		int val = Integer.parseInt(value);
		Korisnik loggedIn = userService.getCurrentUser();
		Smestaj smestaj = smestajService.findById(idSmestaj);
		Ocena ocena = new Ocena();
		ocena.setAutor((KrajnjiKorisnik)loggedIn);
		ocena.setSmestaj(smestaj);
		ocena.setVrednost(val);
		Ocena saved = ocenaService.save(ocena);
		if(saved!=null){
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
