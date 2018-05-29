package pi.vezbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.PonudaToPonudaDtoConverter;
import pi.vezbe.service.PonudaService;

@RestController
@RequestMapping(value = "/ponuda")
public class PonudaController {
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired
	private PonudaToPonudaDtoConverter ponudaToPonudaDtoConverter;
	
	@CrossOrigin
	@RequestMapping(
			value = "/getBySmestaj/{idSmestaj}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getBySmestaj(@PathVariable Long idSmestaj) {
		return new ResponseEntity<>(ponudaToPonudaDtoConverter.convert(ponudaService.getBySmestaj(idSmestaj)), HttpStatus.OK);
	}

}
