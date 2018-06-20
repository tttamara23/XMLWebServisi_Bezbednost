package pi.vezbe.controller;

import java.util.ArrayList;
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
import pi.vezbe.converters.AgentToAgentDTOConverter;
import pi.vezbe.converters.SmestajToSmestajDtoConverter;
import pi.vezbe.converters.SmestajVlasnikToSmestajVlasnikDTOConverter;
import pi.vezbe.dto.SmestajVlasnikDTO;
import pi.vezbe.model.Smestaj;
import pi.vezbe.model.SmestajVlasnik;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.SmestajVlasnikService;


@RestController
@RequestMapping(value = "/smestajVlasnik")
public class SmestajVlasnikController {
	
	@Autowired
	private SmestajVlasnikService smestajVlasnikService;
	
	@Autowired
	private SmestajService 	smestajService;
	
	@Autowired
	private SmestajVlasnikToSmestajVlasnikDTOConverter  smestajVlasnikToSmestajVlasnikDtoCOnverter;
	
	@PermissionAnnotation(name = "GET_VLASNIK_SMESTAJ")
	@CrossOrigin
	@RequestMapping(
			value = "/getVlasnik/{idSmestaja}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getSmestaj(@PathVariable Long idSmestaja) {
		Smestaj smestaj = smestajService.findById(idSmestaja);
		if(smestaj==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<SmestajVlasnik> vlasnici = smestajVlasnikService.findByIdSmestajId(idSmestaja);
			if(vlasnici==null){
				return new ResponseEntity<>(new ArrayList<SmestajVlasnik>(),HttpStatus.OK);
			}
		List<SmestajVlasnikDTO> vlasniciDTO = smestajVlasnikToSmestajVlasnikDtoCOnverter.convert(vlasnici);
		
		return new ResponseEntity<>(vlasniciDTO,HttpStatus.OK);
	}
}
