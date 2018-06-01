package pi.vezbe.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.PonudaToPonudaDtoConverter;
import pi.vezbe.dto.PonudaDTO;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.model.Ponuda;
import pi.vezbe.model.Rezervacija;
import pi.vezbe.service.PonudaService;
import pi.vezbe.service.RezervacijaService;
import pi.vezbe.service.UserService;

@RestController
@RequestMapping(value = "/rezervacija")
public class RezervacijeController {
	
	@Autowired
	private RezervacijaService rezervacijeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired
	private PonudaToPonudaDtoConverter ponudaToPonudaDtoConverter;
	
	@CrossOrigin
	@RequestMapping(
            value = "/reserve/{idPonuda}",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> reserve(@PathVariable Long idPonuda) {
		Ponuda ponuda = ponudaService.findOne(idPonuda);
		
		if(ponuda.getBrojSlobodnihPonuda()>0){
			ponuda.setBrojSlobodnihPonuda(ponuda.getBrojSlobodnihPonuda()-1);
		}else{
			return new ResponseEntity<>("No available rooms",HttpStatus.BAD_REQUEST);
		}
		Rezervacija rezervacija = new Rezervacija();
		Calendar cal = Calendar.getInstance();
		Date datumRezervacije = cal.getTime();
		rezervacija.setDatumRezervacije(datumRezervacije);
		rezervacija.setPonuda(ponuda);
		rezervacija.setKorisnik((KrajnjiKorisnik)userService.getCurrentUser());
		
		ponuda.getRezervacija().add(rezervacija);
		
		Ponuda ponudaRet = ponudaService.save(ponuda);
		Rezervacija rezervacijaRet = rezervacijeService.save(rezervacija);
		PonudaDTO ponudaRetDTO = ponudaToPonudaDtoConverter.convert(ponudaRet);
		return new ResponseEntity<>(ponudaRetDTO,HttpStatus.OK);
	}

	
	
}
