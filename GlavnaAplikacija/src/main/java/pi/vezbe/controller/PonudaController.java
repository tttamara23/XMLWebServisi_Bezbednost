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

import pi.vezbe.annotations.PermissionAnnotation;
import pi.vezbe.converters.PonudaToPonudaDtoConverter;
import pi.vezbe.dto.SearchDTO;
import pi.vezbe.model.Ponuda;
import pi.vezbe.model.Usluga;
import pi.vezbe.service.PonudaService;
import pi.vezbe.service.UslugaService;

@RestController
@RequestMapping(value = "/ponuda")
public class PonudaController {
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired
	private UslugaService uslugaService; 
	
	@Autowired
	private PonudaToPonudaDtoConverter ponudaToPonudaDtoConverter;
	
	@PermissionAnnotation(name = "GET_PONUDA")
	@CrossOrigin
	@RequestMapping(
			value = "/getBySmestaj/{idSmestaj}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getBySmestaj(@PathVariable Long idSmestaj) {
		return new ResponseEntity<>(ponudaToPonudaDtoConverter.convert(ponudaService.getBySmestaj(idSmestaj)), HttpStatus.OK);
	}
	
	@PermissionAnnotation(name = "SEARCH_PONUDA")
	@CrossOrigin
	@RequestMapping(
			value = "/search/{advanced}/{sort}",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> search(@PathVariable("advanced") int advanced, @PathVariable("sort") int sort, @RequestBody SearchDTO searchDTO) {
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
				if(sort == 1) { //cena
					ponude = ponudaService.searchNotAdvancedOrderByCena(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons);
				} else if(sort == 3) {  //kategorija
					ponude = ponudaService.searchNotAdvancedOrderByCategory(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons);
				}
			} else {
				List<Usluga> usl = uslugaService.findByIdNotIn(searchDTO.getSearchServices());
				
				if(sort == 1) {
					ponude = ponudaService.searchAdvancedOrderByCena(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType(), searchDTO.getCategory(), usl);
				} else if(sort == 3) {
					ponude = ponudaService.searchAdvancedOrderByCategory(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType(), searchDTO.getCategory(), usl);
				}
			}
			return new ResponseEntity<>(ponudaToPonudaDtoConverter.convert(ponude), HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
