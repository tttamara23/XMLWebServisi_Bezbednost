package pi.vezbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.TipSmestajaToTipSmestajaDTO;
import pi.vezbe.service.TipSmestajaService;

@RestController
@RequestMapping(value = "/tipSmestaja")
public class TipSmestajaController {

	@Autowired
	private TipSmestajaService tipSmestajaService;
	
	@Autowired
	private TipSmestajaToTipSmestajaDTO tipSmestajaToTipSmestajaDTOConverter;
	
	@CrossOrigin
	@RequestMapping(
            value = "getSviTipovi",
            method = RequestMethod.GET
    )
	public ResponseEntity<?> getSviTipovi() {
		return new ResponseEntity<>(tipSmestajaToTipSmestajaDTOConverter.convert(tipSmestajaService.findAllTipS()), HttpStatus.OK);
	}
	
}
