package pi.vezbe.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.annotations.PermissionAnnotation;
import pi.vezbe.converters.KomentarToKomentarDTOConverter;
import pi.vezbe.model.Komentar;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.model.Smestaj;
import pi.vezbe.service.KomentarService;
import pi.vezbe.service.RezervacijaService;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.UserService;

@RestController
@RequestMapping(value = "/komentar")
public class KomentarController {
	
	@Autowired
	private KomentarService komentarService;
	
	@Autowired
	private KomentarToKomentarDTOConverter komentarToKomentarDTOConverter;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@CrossOrigin
	@RequestMapping(
			value = "/getBySmestaj/{idSmestaj}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getBySmestaj(@PathVariable Long idSmestaj) {
		return new ResponseEntity<>(komentarToKomentarDTOConverter.convert(komentarService.findBySmestajAndObjavljen(idSmestaj)), HttpStatus.OK);
	}
	
	@PermissionAnnotation(name = "ADD_COMMENT")
	@CrossOrigin
	@RequestMapping(
			value = "/comment/{idSmestaj}",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> comment(@PathVariable Long idSmestaj, @RequestBody String sadrzaj) {
		Komentar komentar = new Komentar();
		if(userService.getCurrentUser() instanceof KrajnjiKorisnik) {
			komentar.setAutor((KrajnjiKorisnik)userService.getCurrentUser());
		} else {
			return new ResponseEntity<>("You do not have permission to comment!", HttpStatus.UNAUTHORIZED);
		}
		if(rezervacijaService.findBySmestajAndKorisnikAndRealizovano(idSmestaj, userService.getCurrentUser().getId(), true).isEmpty()) {
			return new ResponseEntity<>("You do not have permission to comment!", HttpStatus.UNAUTHORIZED);
		}
		komentar.setDatumKomentara(new Date());
		komentar.setObjavljen(false);
		komentar.setOpis(sadrzaj);
		Smestaj smestaj = smestajService.findById(idSmestaj);
		if(smestaj == null) {
			return new ResponseEntity<>("Accommodation doesn's exist!", HttpStatus.BAD_REQUEST);
		}
		komentar.setSmestaj(smestaj);
		Komentar saved = komentarService.save(komentar);
		return new ResponseEntity<>(komentarToKomentarDTOConverter.convert(saved), HttpStatus.OK);
		
	}

}
