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
import pi.vezbe.converters.PonudaUslugaToPonudaUslugaDtoConverter;
import pi.vezbe.model.PonudaUsluga;
import pi.vezbe.service.PonudaUslugaService;

@RestController()
@RequestMapping(value = "/ponudaUsluga")
public class PonudaUslugaController {
	
	@Autowired
	private PonudaUslugaService ponudaUslugaService;
	
	@Autowired
	private PonudaUslugaToPonudaUslugaDtoConverter ponudaUslugaToPonudaUslugaDtoConverter;
	
	@PermissionAnnotation(name = "GET_PONUDA_USLUGA")
	@CrossOrigin
	@RequestMapping(
            value = "getByPonuda/{idPonuda}",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> getByPonuda(@PathVariable Long idPonuda) {
		List<PonudaUsluga> ponudaUslugaList = ponudaUslugaService.getByPonuda(idPonuda);
		return new ResponseEntity<>(ponudaUslugaToPonudaUslugaDtoConverter.convert(ponudaUslugaList), HttpStatus.OK);
    }

}
