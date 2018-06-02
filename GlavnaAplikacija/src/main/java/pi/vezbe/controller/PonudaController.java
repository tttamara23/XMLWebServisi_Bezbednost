package pi.vezbe.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

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
import pi.vezbe.dto.SearchDTO;
import pi.vezbe.model.Ponuda;
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
	
	@CrossOrigin
	@RequestMapping(
			value = "/search/{advanced}",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> search(@PathVariable("advanced") int advanced, @RequestBody SearchDTO searchDTO) {
		int numberOfPersons;
		try{
			numberOfPersons = Integer.parseInt(searchDTO.getNumberOfPersons());
		} catch(Exception e) {
			return new ResponseEntity<>("Number of persons must be number.",HttpStatus.BAD_REQUEST);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dateFrom;
			Date dateTo;
			if(searchDTO.getDateFrom().equals("") || searchDTO.getDateFrom() == null) {
				dateFrom = new Date(Long.MIN_VALUE);
			} else {
				dateFrom = dateFormat.parse(searchDTO.getDateFrom());
			}
			if(searchDTO.getDateTo().equals("") || searchDTO.getDateTo() == null) {
				dateTo = new Date(Long.MAX_VALUE);
			} else {
				dateTo = dateFormat.parse(searchDTO.getDateTo());
			}
			
			List<Ponuda> ponude = new ArrayList<Ponuda>();
			if(advanced == 0) {
				ponude = ponudaService.searchNotAdvanced(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons);
			} else {
				ponude = ponudaService.searchAdvanced(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType(), searchDTO.getCategory(), searchDTO.getSearchServices());
			}
			return new ResponseEntity<>(ponudaToPonudaDtoConverter.convert(ponude), HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
