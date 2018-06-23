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
import pi.vezbe.model.Ocena;
import pi.vezbe.model.Ponuda;
import pi.vezbe.model.Smestaj;
import pi.vezbe.service.OcenaService;
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
	private OcenaService ocenaService; 
	
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
			value = "/search/{advanced}/{sort}",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> search(@PathVariable("advanced") int advanced, @PathVariable("sort") int sort, @RequestBody SearchDTO searchDTO) {
		int numberOfPersons;
		if(searchDTO.getDestination().equals("") || searchDTO.getDestination() == null) {
			return new ResponseEntity<>("Enter a destination and date to start searching.", HttpStatus.BAD_REQUEST);
		}
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
				return new ResponseEntity<>("Enter a destination and date to start searching.", HttpStatus.BAD_REQUEST);
			} else {
				dateFrom = dateFormat.parse(searchDTO.getDateFrom());
			}
			if(searchDTO.getDateTo().equals("") || searchDTO.getDateTo() == null) {
				return new ResponseEntity<>("Enter a destination and date to start searching.", HttpStatus.BAD_REQUEST);
			} else {
				dateTo = dateFormat.parse(searchDTO.getDateTo());
			}
			
			List<Ponuda> ponude = new ArrayList<Ponuda>();
			if(advanced == 0) {
				List<Ponuda> sve = ponudaService.getAll();
				if(sort == 1) { //cena
					ponude = ponudaService.searchNotAdvancedOrderByCena(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons);
				} else if(sort == 3) {  //kategorija
					ponude = ponudaService.searchNotAdvancedOrderByCategory(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons);
				} else if(sort == 2) { //sortByRating
					ponude = ponudaService.searchNotAdvancedOrderByRating(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons);
					for(int i = 0; i < ponude.size()-1; i++) {
						for(int j = i; j < ponude.size(); j++) {
							if(avgOcena(ponude.get(i).getSmestaj()) < avgOcena(ponude.get(j).getSmestaj())) {
								Ponuda temp = ponude.get(i);
								ponude.set(i, ponude.get(j));
								ponude.set(j, temp);
							}
						}
					}
				}
			} else {
				
				if(sort == 1) {
					ponude = ponudaService.searchAdvancedOrderByCena(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType(), searchDTO.getCategory());
				} else if(sort == 3) {
					ponude = ponudaService.searchAdvancedOrderByCategory(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType(), searchDTO.getCategory());
				} else if(sort == 3) { 
					ponude = ponudaService.searchAdvancedOrderByRating(dateFrom, dateTo, searchDTO.getDestination(), numberOfPersons, searchDTO.getAccommodationType(), searchDTO.getCategory());
					for(int i = 0; i < ponude.size()-1; i++) {
						for(int j = i; j < ponude.size(); j++) {
							if(avgOcena(ponude.get(i).getSmestaj()) < avgOcena(ponude.get(j).getSmestaj())) {
								Ponuda temp = ponude.get(i);
								ponude.set(i, ponude.get(j));
								ponude.set(j, temp);
							}
						}
					}
				}
				
				for(Long l : searchDTO.getSearchServices()) {
					for(int i=ponude.size()-1; i>=0; i--) {
						if(!ponude.get(i).imaUslugu(l)) {
							ponude.remove(i);
						}
					}
				}
			}
			
			for(int i=ponude.size()-1; i>=0; i--) {
				if(ponude.get(i).getDatumOd().before(dateFrom) || ponude.get(i).getDatumDo().after(dateTo)) {
					ponude.remove(i);
				}
			}
			
			return new ResponseEntity<>(ponudaToPonudaDtoConverter.convert(ponude), HttpStatus.OK);
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	public double avgOcena(Smestaj smestaj) {
		List<Ocena> ocene = ocenaService.findBySmestaj(smestaj.getId());
		int ukupno = 0;
		for(Ocena ocena : ocene) {
			ukupno += ocena.getVrednost();
		}
		return ((double)ukupno)/ocene.size();
	}

}
