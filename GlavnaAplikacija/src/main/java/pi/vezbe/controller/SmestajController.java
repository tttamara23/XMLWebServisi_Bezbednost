package pi.vezbe.controller;

import java.util.Calendar;
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

import pi.vezbe.converters.PonudaToPonudaDtoConverter;
import pi.vezbe.converters.SmestajToSmestajDtoConverter;
import pi.vezbe.dto.PonudaDTO;
import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.model.Ponuda;
import pi.vezbe.model.Smestaj;
import pi.vezbe.service.PonudaService;
import pi.vezbe.service.SmestajService;

@RestController
@RequestMapping(value = "/smestaj")
public class SmestajController {
	
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired
	private SmestajToSmestajDtoConverter smestajToSmestajDtoConverter;
	
	@Autowired
	private PonudaToPonudaDtoConverter ponudaToPonudaDtoConverter;
	
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
	
	@CrossOrigin
	@RequestMapping(
			value = "/getSmestaj/{idSmestaja}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getSmestaj(@PathVariable Long idSmestaja) {
		Smestaj smestaj = smestajService.findById(idSmestaja);
		if(smestaj==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Calendar cal = Calendar.getInstance();
		Date start = cal.getTime();
		
		System.out.println(start.toString());
		List<Ponuda> ponude = ponudaService.getByCurrentDateAndSmestajId(start, idSmestaja);
		SmestajDTO smestajDTO = smestajToSmestajDtoConverter.convert(smestaj);
		List<PonudaDTO> ponudeDTO = ponudaToPonudaDtoConverter.convert(ponude);
		smestajDTO.setPonude(ponudeDTO);
		return new ResponseEntity<>(smestajDTO,HttpStatus.OK);
	}
	
	

}
