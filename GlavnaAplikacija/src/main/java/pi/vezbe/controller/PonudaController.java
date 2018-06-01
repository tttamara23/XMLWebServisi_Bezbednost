package pi.vezbe.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			value = "/search",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> search(@RequestBody SearchDTO searchDTO) {
		int numberOfPersons;
		int category = 0;
		try{
			numberOfPersons = Integer.parseInt(searchDTO.getNumberOfPersons());
		} catch(Exception e) {
			return new ResponseEntity<>("Number of persons must be number.",HttpStatus.BAD_REQUEST);
		}
		
		if(searchDTO.getCategory() != null) {
			if(!searchDTO.getCategory().equals("")) {
				try{
					category = Integer.parseInt(searchDTO.getCategory());
				} catch(Exception e) {
					return new ResponseEntity<>("Category must be number.",HttpStatus.BAD_REQUEST);
				}
			}	
		}
		if(searchDTO.getAccommodationType() == null) {
			searchDTO.setAccommodationType("");
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
			if(searchDTO.getCategory() == null) {
				ponude = ponudaService.searchWithoutCategory(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType());
			} else if(searchDTO.getCategory().equals("")) {
				ponude = ponudaService.searchWithoutCategory(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType());
			} else {
				ponude = ponudaService.searchWithCategory(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType(), category);
			}
			return new ResponseEntity<>(ponudaToPonudaDtoConverter.convert(ponude), HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
