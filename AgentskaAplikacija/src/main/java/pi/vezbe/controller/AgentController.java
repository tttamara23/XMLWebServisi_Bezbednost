package pi.vezbe.controller;

import java.io.IOException;

import glavna.wsdl.SmestajResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.SmestajDTOToSmestajConverter;
import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.model.Smestaj;
import pi.vezbe.service.SmestajService;
import pi.vezbe.ws.WSClient;

@RestController()
@RequestMapping(value = "/agent")
public class AgentController {
	
	
	@Autowired
	private SmestajDTOToSmestajConverter smestajDtoToSmestajConverter;
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private WSClient WSClient;
	
	
	@CrossOrigin
	@RequestMapping(
            value = "addSmestaj",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> addSmestaj(@RequestBody SmestajDTO smestajDTO) throws IOException {
		if(smestajDTO.getNaziv().equals("") || smestajDTO.getNaziv() == null)	{
			return new ResponseEntity<>("Fill in all required entry fields!", HttpStatus.BAD_REQUEST);
		}
		//Smestaj toSave = smestajDtoToSmestajConverter.convert(smestajDTO);
		SmestajResponse response  = WSClient.smestajWS(smestajDTO);
		Smestaj smestaj = new Smestaj();
		smestaj.setNaziv(response.getNaziv());
		smestaj.setLokacija(response.getLokacija());
		smestaj.setOpis(response.getOpis());
		smestaj.setTip(response.getTip());
		smestajService.save(smestaj);
       // TipSmestaja TipToSave = tipSmestajaDTOToTipSmestajaConverter.convert(tipSmestajaDTO);
        //TipSmestaja saved = tipSmestajaService.save(TipToSave);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
