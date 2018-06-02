package pi.vezbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.KategorijaSmestajaToKategorijaSmestajaDTOConverter;
import pi.vezbe.service.KategorijaSmestajaService;

@RestController
@RequestMapping(value = "/kategorijaSmestaja")
public class KategorijaSmestajaController {
	
	@Autowired
	private KategorijaSmestajaService kategorijaSmestajaService;
	
	@Autowired
	private KategorijaSmestajaToKategorijaSmestajaDTOConverter kategorijaSmestajaToKategorijaSmestajaDTOConverter;
	
	@CrossOrigin
	@RequestMapping(
            value = "getSveKategorije",
            method = RequestMethod.GET
    )
	public ResponseEntity<?> getSveKategorije() {
		return new ResponseEntity<>(kategorijaSmestajaToKategorijaSmestajaDTOConverter.convert(kategorijaSmestajaService.findAllKS()), HttpStatus.OK);
	}

}
