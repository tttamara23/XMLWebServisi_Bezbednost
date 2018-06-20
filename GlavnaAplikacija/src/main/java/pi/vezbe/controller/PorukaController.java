package pi.vezbe.controller;

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
import pi.vezbe.converters.ChatToChatDTOConverter;
import pi.vezbe.converters.PorukaToPorukaDTOConverter;
import pi.vezbe.dto.ChatDTO;
import pi.vezbe.dto.KorisnikDTO;
import pi.vezbe.model.Chat;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.Poruka;
import pi.vezbe.service.ChatService;
import pi.vezbe.service.PorukaService;
import pi.vezbe.service.UserService;

@RestController()
@RequestMapping(value = "/poruka")
public class PorukaController {
	
	@Autowired
	private PorukaService porukaService;

	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PorukaToPorukaDTOConverter porukaToPorukaDTOConverter;
	
	@Autowired
	private ChatToChatDTOConverter chatToChatDTOConverter;
	
	@PermissionAnnotation(name = "SEND_MESSAGE")
	@CrossOrigin
	@RequestMapping(
            value = "/sendMessage/{idPrimalac}",
            method = RequestMethod.POST
    )
	public ResponseEntity<?> sendMessage(@PathVariable Long idPrimalac, @RequestBody String sadrzaj) {
		Korisnik ulogovani = userService.getCurrentUser();
		List<Korisnik> ids = new ArrayList<Korisnik>();
		Korisnik primalac = userService.findById(idPrimalac);
		ids.add(ulogovani);
		ids.add(primalac);
		Chat chat = chatService.findExistingChat(ids);
		
		if(chat == null) {
			
			chat = new Chat();
			chat.getKorisnici().add(ulogovani);
			chat.getKorisnici().add(primalac);
			chatService.save(chat);
			
			ulogovani.getChats().add(chat);
			userService.save(ulogovani);
			
			primalac.getChats().add(chat);
			userService.save(primalac);
			
		}
		
		Poruka poruka = new Poruka();
		poruka.setChat(chat);
		poruka.setDatumSlanja(new Date());
		poruka.setPosiljalac(ulogovani);
		poruka.setSadrzaj(sadrzaj);
		
		try{
			porukaService.save(poruka);
		} catch(Exception e) {
			return new ResponseEntity<>("Message too long!", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(chatToChatDTOConverter.convert(chat), HttpStatus.OK);
	}
	
	@PermissionAnnotation(name = "GET_MESSAGES")
	@CrossOrigin
	@RequestMapping(
            value = "/getPoruke/{idChat}",
            method = RequestMethod.GET
    )
	public ResponseEntity<?> getPoruke(@PathVariable Long idChat) {
		List<Poruka> poruke = porukaService.findByChat(idChat);
		Chat chat = chatService.findById(idChat);
		ChatDTO chatDTO = chatToChatDTOConverter.convert(chat);
		for(KorisnikDTO korisnik : chatDTO.getKorisnici()){
			if(korisnik.getId().equals(userService.getCurrentUser().getId())){
				chatDTO.getKorisnici().remove(korisnik);
				break;
			}
		}
		chatDTO.setPoruke(porukaToPorukaDTOConverter.convert(poruke));
		return new ResponseEntity<>(chatDTO, HttpStatus.OK);
		
	}
	
	@PermissionAnnotation(name = "SEND_MESSAGE")
	@CrossOrigin
	@RequestMapping(
            value = "/posaljiPorukuUChat/{idChat}",
            method = RequestMethod.POST
    )
	public ResponseEntity<?> posaljiPorukuUChat(@PathVariable Long idChat, @RequestBody String sadrzaj) {
		Chat chat = chatService.findById(idChat);
		Korisnik ulogovani = userService.getCurrentUser();
		
		if(!chat.findKorisnik(ulogovani)) {
			return new ResponseEntity<>("You are not in this chat!", HttpStatus.BAD_REQUEST);
		}
		
		Poruka poruka = new Poruka();
		poruka.setPosiljalac(ulogovani);
		poruka.setSadrzaj(sadrzaj);
		poruka.setDatumSlanja(new Date());
		poruka.setChat(chat);
		Poruka saved;
		
		try {
			saved = porukaService.save(poruka);
		}catch(Exception e) {
			return new ResponseEntity<>("Message too long!", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(porukaToPorukaDTOConverter.convert(saved), HttpStatus.OK);
		
	}
	
	@PermissionAnnotation(name = "SEEN_MESSAGES")
	@CrossOrigin
	@RequestMapping(
            value = "/seen/{idChat}",
            method = RequestMethod.PUT
    )
	public ResponseEntity<?> seen(@PathVariable Long idChat) {
		List<Poruka> poruke = porukaService.seen(idChat, userService.getCurrentUser().getId());
		for(Poruka poruka : poruke) {
			poruka.setSeen(true);
			porukaService.save(poruka);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
