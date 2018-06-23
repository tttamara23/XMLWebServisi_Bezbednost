package pi.vezbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.annotations.PermissionAnnotation;
import pi.vezbe.converters.UslugaToUslugaDtoConverter;
import pi.vezbe.dto.UslugaDTO;
import pi.vezbe.model.Usluga;
import pi.vezbe.service.UslugaService;

@RestController
@RequestMapping(value = "/usluga")
public class UslugaController {
	
	@Autowired
	private UslugaService uslugaService;
	
	@Autowired
	private UslugaToUslugaDtoConverter  uslugaToUslugaDtoConverter;
	
	@CrossOrigin
	@RequestMapping(
            value = "/getUsluge",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> getUsluge() {
		List<Usluga> usluge = uslugaService.findAll();
		List<UslugaDTO> uslugeDTO = uslugaToUslugaDtoConverter.convert(usluge);
		return new ResponseEntity<>(uslugeDTO,HttpStatus.OK);
	}

}
