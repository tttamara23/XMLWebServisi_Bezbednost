package pi.vezbe.controller;

import glavna.wsdl.AccommodationXML;
import glavna.wsdl.SmestajResponse;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.converters.ChatToChatDTOConverter;
import pi.vezbe.converters.PonudaDTOToPonudaConverter;
import pi.vezbe.converters.PonudaToPonudaDtoConverter;
import pi.vezbe.converters.PorukaToPorukaDTOConverter;
import pi.vezbe.converters.RezervacijaToRezervacijaDTO;
import pi.vezbe.converters.SmestajDTOToSmestajConverter;
import pi.vezbe.converters.SmestajToSmestajDtoConverter;
import pi.vezbe.converters.UslugaDtoToUslugaConverter;
import pi.vezbe.converters.UslugaToUslugaDtoConverter;
import pi.vezbe.converters.XMLConverter;
import pi.vezbe.dto.ChatDTO;
import pi.vezbe.dto.PonudaDTO;
import pi.vezbe.dto.PorukaChatDTO;
import pi.vezbe.dto.PorukaDTO;
import pi.vezbe.dto.RezervacijaDTO;
import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.dto.UslugaDTO;
import pi.vezbe.dto.ZauzimanjeTerminaDTO;
import pi.vezbe.model.Agent;
import pi.vezbe.model.Chat;
import pi.vezbe.model.Ponuda;
import pi.vezbe.model.Poruka;
import pi.vezbe.model.Rezervacija;
import pi.vezbe.model.Smestaj;
import pi.vezbe.model.SmestajVlasnik;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.model.Usluga;
import pi.vezbe.service.AgentService;
import pi.vezbe.service.ChatService;
import pi.vezbe.service.DodatneUslugeService;
import pi.vezbe.service.PonudaService;
import pi.vezbe.service.PorukaService;
import pi.vezbe.service.RezervacijaService;
import pi.vezbe.service.SmestajService;
import pi.vezbe.service.SmestajVlasnikService;
import pi.vezbe.service.TipSmestajaService;
import pi.vezbe.service.UserService;
import pi.vezbe.service.UslugaService;
import pi.vezbe.ws.WSClient;

@RestController()
@RequestMapping(value = "/agent")
public class AgentController {
	
	
	@Autowired
	private SmestajDTOToSmestajConverter smestajDtoToSmestajConverter;
	
	@Autowired	
	private SmestajToSmestajDtoConverter smestajToSmestajDTOConverter;
	
	@Autowired
	private PonudaDTOToPonudaConverter ponudaDTOToPonudaConverter;
	
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private WSClient WSClient;
	
	@Autowired 
	private TipSmestajaService tipSmestajaService;
	
	@Autowired 
	private AgentService agentService;
	
	@Autowired
	private DodatneUslugeService dodatneUslugeService;
	
	@Autowired
	private UslugaService uslugeService;
	
	@Autowired
	private UslugaToUslugaDtoConverter converterUsluge;
	
	@Autowired
	private UslugaDtoToUslugaConverter converterUslugeDtotoUsluge;
	
	@Autowired 
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private SmestajVlasnikService smestajVlasnikService;
	
	@Autowired
	private RezervacijaToRezervacijaDTO rezervacijaToRezervacijaDtoConverter;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChatService chatService;
	@Autowired
	private ChatToChatDTOConverter chatToChatDTOConverter;
	
	
	@Autowired
	private PorukaService porukeService;
	
	
	@Autowired
	private PorukaToPorukaDTOConverter porukaToPorukaDTO;
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired
	private PonudaToPonudaDtoConverter ponudaToPonudaDtoConverter;
	
	private XMLConverter xmlConverter;
	
	@CrossOrigin
	@RequestMapping(
            value = "termins",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> termins() throws IOException {
	
		//Smestaj toSave = smestajDtoToSmestajConverter.convert(smestajDTO);
		ArrayList<Smestaj> smestajevi = (ArrayList<Smestaj>) smestajService.getAll();
		//OVDEEE NAMESTI ULOGOVANOG
		long userId = 3L;
		ArrayList<SmestajVlasnik> vlasniciSmestaja = (ArrayList<SmestajVlasnik>) smestajVlasnikService.findByIdVlasnikId(userId);
		for(int i = smestajevi.size()-1; i >= 0; i--){
			int nema = 0; 
			for(int j=0; j< vlasniciSmestaja.size(); j++){
				if(vlasniciSmestaja.get(j).getSmestaj().getId().equals(smestajevi.get(i).getId())){
					nema = 1;
				}
			}
			if(nema==0){
				smestajevi.remove(i);
			}
		}
		List<SmestajDTO> smestajeviDTO = smestajToSmestajDTOConverter.convert(smestajevi);
        return new ResponseEntity<>(smestajeviDTO, HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(
            value = "dodajTermin",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> dodajTermin(@RequestBody PonudaDTO ponuda) throws IOException {
		
		Smestaj smestajPonude = smestajService.findById(ponuda.getSmestajId());
		
		ponuda.setSmestajNaziv(smestajPonude.getNaziv());
		ponudaService.save(ponudaDTOToPonudaConverter.convert(ponuda));
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(
            value = "pregledajTermine",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> pregledajTermine(@RequestBody String id) {
		ArrayList<Ponuda> ponudeUSmestaju = (ArrayList<Ponuda>) ponudaService.getBySmestaj(new Long(id));
		ArrayList<PonudaDTO> ponudeUSmestajuDTO = (ArrayList<PonudaDTO>) ponudaToPonudaDtoConverter.convert(ponudeUSmestaju);
		return new ResponseEntity<>(ponudeUSmestajuDTO,HttpStatus.OK);
    }
	@CrossOrigin
	@RequestMapping(
            value = "nadjiTermin",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> nadjiTermin(@RequestBody String id) {
		Ponuda ponudaZaZauzimanje = ponudaService.findOne(new Long(id));
		PonudaDTO ponudaZaZauzimanjeDTO = ponudaToPonudaDtoConverter.convert(ponudaZaZauzimanje);
		return new ResponseEntity<>(ponudaZaZauzimanjeDTO,HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(
            value = "zauzmiTermin",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> zauzmiTermin(@RequestBody ZauzimanjeTerminaDTO zauzimanjeDTO) {
		Ponuda ponudaZaZauzimanje = ponudaService.findOne(zauzimanjeDTO.getIdTermina());
		if(ponudaZaZauzimanje == null){
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}else{
			if(ponudaZaZauzimanje.getBrojSlobodnihPonuda() < zauzimanjeDTO.getBrojSoba()){
				return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}else{
				int brojSlobodnih = ponudaZaZauzimanje.getBrojSlobodnihPonuda();
				int posleZauzimanja = brojSlobodnih - zauzimanjeDTO.getBrojSoba();
				ponudaZaZauzimanje.setBrojSlobodnihPonuda( posleZauzimanja );
				Ponuda saved = ponudaService.save(ponudaZaZauzimanje);
				return new ResponseEntity<>(smestajToSmestajDTOConverter.convert(ponudaZaZauzimanje.getSmestaj()),HttpStatus.OK);
			}
		}
		
		
    }
	@CrossOrigin
	@RequestMapping(
            value = "rezervacije",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> rezervacije() throws IOException {
	
		List<Rezervacija> sveRezervacije = rezervacijaService.findAll();
		for(int i = sveRezervacije.size()-1; i >= 0; i--){
			if(sveRezervacije.get(i).isRealizovano()){
				sveRezervacije.remove(i);
				
			}
		}
		//OVDEEE NAMESTI ULOGOVANOG
		long userId = 3L;
		List<SmestajVlasnik> lista = smestajVlasnikService.findByIdVlasnikId(userId);
		List<RezervacijaDTO> ret = new ArrayList<RezervacijaDTO>();
		for(int i = 0; i < sveRezervacije.size(); i++){
			for(int j = 0; j<lista.size(); j++){
				if(lista.get(j).getSmestaj().getId().equals(sveRezervacije.get(i).getPonuda().getSmestaj().getId())){
					if(checkIfReservationIsInPast(sveRezervacije.get(i))){
						ret.add(rezervacijaToRezervacijaDtoConverter.convert(sveRezervacije.get(i)));
					}
				}
			}
			
		}
		
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
	
	private boolean checkIfReservationIsInPast(Rezervacija res){
		
		Date datumRez = res.getDatumRezervacije();
		Date now = new Date();
		
		if(now.compareTo(datumRez)>0){
			return true;
		}
		return false;
		
	}
	@CrossOrigin
	@RequestMapping(
            value = "potvrdiRezervaciju",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> potvrdiRezervaciju(@RequestBody String id) {
		Rezervacija zaPotvrditi = rezervacijaService.findOne(new Long(id));
		if(zaPotvrditi == null){
			return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
		}
		zaPotvrditi.setRealizovano(true);
		Rezervacija sacuvana = rezervacijaService.save(zaPotvrditi);
		return new ResponseEntity<>(true,HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(
            value = "chatovi",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> chatovi() throws IOException {
	
		
		//OVDEEE NAMESTI ULOGOVANOG
		long userId = 3L;
		
		List<Chat> sviChatoviAgenta = chatService.findAllByKorisniciId(userId);
		List<ChatDTO> sviChatoviDTO = chatToChatDTOConverter.convert(sviChatoviAgenta);
		
		
        return new ResponseEntity<>(sviChatoviDTO, HttpStatus.OK);
    }
	@CrossOrigin
	@RequestMapping(
            value = "addSmestaj",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> addSmestaj(@RequestBody SmestajDTO smestajDTO) throws IOException {
		if(smestajDTO.getNaziv().equals("") || smestajDTO.getNaziv() == null)	{
			return new ResponseEntity<>("Fill in all required entry fields!", HttpStatus.BAD_REQUEST);
		}
		
		SmestajResponse response  = WSClient.smestajWS(smestajDTO);
		Smestaj uneti = smestajDtoToSmestajConverter.convert(smestajDTO);
		if(response != null){
			Smestaj toSave = new Smestaj();
			AccommodationXML smestajXML = new AccommodationXML();
			smestajXML = response.getAccommodation();
			toSave.setId(smestajXML.getId());
			toSave.setNaziv(smestajXML.getNaziv());
			toSave.setLokacija(smestajXML.getLokacija());
			toSave.setOpis(smestajXML.getOpis());
			XMLConverter xmlConverter = new XMLConverter();
			TipSmestaja tip = xmlConverter.convertTipSmestajaXMLToTipSmestaja(smestajXML.getTipSmestaja());
			toSave.setTipSmestaja(tip);
			smestajService.save(toSave);
	        return new ResponseEntity<>(HttpStatus.CREATED);
		}

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
	
	@CrossOrigin
	@RequestMapping(
            value = "getPorukeIzChata",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> getPorukeIzChata(@RequestBody String id) throws IOException, ParseException {
	
		Chat chat = chatService.findById(new Long(id));
		ChatDTO chatDTO = chatToChatDTOConverter.convert(chat);

		ArrayList<PorukaDTO> sortirane = sortPoruke((ArrayList<PorukaDTO>)chatDTO.getPoruke());
		
        return new ResponseEntity<>(sortirane, HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(
            value = "posaljiPoruku",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> posaljiPoruku(@RequestBody PorukaChatDTO poruka) throws IOException, ParseException {
	
		Chat chat = chatService.findById(new Long(poruka.getIdChat()));
		
		ChatDTO chatDTO = chatToChatDTOConverter.convert(chat);
		//OVDEEE NAMESTI ULOGOVANOG
		long userId = 3L;
		Agent ulogovani = agentService.findOne(userId);
		Poruka porukaZaSlanje = new Poruka();
		porukaZaSlanje.setChat(chat);
		porukaZaSlanje.setPosiljalac(ulogovani);
		porukaZaSlanje.setSadrzaj(poruka.getSadrzajPoruke());
		porukaZaSlanje.setDatumSlanja(new Date());
		porukaZaSlanje.setSeen(false);
		porukeService.save(porukaZaSlanje);
		ArrayList<PorukaDTO> sortirane = sortPoruke((ArrayList<PorukaDTO>)chatDTO.getPoruke());
		
        return new ResponseEntity<>(sortirane, HttpStatus.OK);
    }
	private ArrayList<PorukaDTO> sortPoruke(ArrayList<PorukaDTO> poruke) throws ParseException{
		for(int i = 0; i < poruke.size()-1; i++){
			for(int j = i+1; j<poruke.size(); j++){
				DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				Date datum1=dateFormat.parse(poruke.get(i).getDatum());  
				Date datum2=dateFormat.parse(poruke.get(j).getDatum());  
				
				if(datum1.compareTo(datum2)>=0){
					PorukaDTO temp = poruke.get(i);
					poruke.set(i,poruke.get(j));
					poruke.set(j,temp);
				}
				
			}
		}
		return poruke;
	}
	
	@CrossOrigin
	@RequestMapping(
            value = "ucitajTipSmestaja",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> ucitajTipSmestaja() throws IOException {
	
		
		ArrayList<TipSmestaja> tipovi = (ArrayList<TipSmestaja>) tipSmestajaService.findAllTipS();
		
        return new ResponseEntity<>(tipovi, HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(
            value = "ucitajDodatneUsluge",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> ucitajDodatneUsluge() throws IOException {
	
		ArrayList<Usluga> usluge = (ArrayList<Usluga>) uslugeService.findAll();
		ArrayList<UslugaDTO> uslugeDTO = (ArrayList<UslugaDTO>) converterUsluge.convert(usluge);
        return new ResponseEntity<>(uslugeDTO, HttpStatus.OK);
    }

}
