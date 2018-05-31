package pi.vezbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.SmestajToSmestajDtoConverter;
import pi.vezbe.service.SmestajService;

@RestController
@RequestMapping(value = "/smestaj")
public class SmestajController {
	
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private SmestajToSmestajDtoConverter smestajToSmestajDtoConverter;
	
	@CrossOrigin
	@RequestMapping(
			value = "/getLocations",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getLocations() {
		return new ResponseEntity<>(smestajService.getLocations(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(
			value = "/getByLocation",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> getByLocation(@RequestBody String location) {
		return new ResponseEntity<>(smestajToSmestajDtoConverter.convert(smestajService.getByLocation(location)), HttpStatus.OK);
	}

}
