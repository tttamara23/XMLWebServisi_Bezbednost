package pi.vezbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.annotations.PermissionAnnotation;
import pi.vezbe.converters.SlikaToSlikaDTOConverter;
import pi.vezbe.model.Slika;
import pi.vezbe.service.SlikaService;

@RestController
@RequestMapping(value = "/slika")
public class SlikaController {
	
	@Autowired
	private SlikaService slikaService;
	
	@Autowired
	private SlikaToSlikaDTOConverter slikaToSlikaDTOConverter;
	
	@PermissionAnnotation(name = "GET_IMAGES")
	@CrossOrigin
	@RequestMapping(
            value = "/getBySmestaj/{idSmestaj}",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> getBySmestaj(@PathVariable Long idSmestaj) {
		List<Slika> slike = slikaService.findBySmestaj(idSmestaj);
		return new ResponseEntity<>(slikaToSlikaDTOConverter.convert(slike), HttpStatus.OK);
	}

}
