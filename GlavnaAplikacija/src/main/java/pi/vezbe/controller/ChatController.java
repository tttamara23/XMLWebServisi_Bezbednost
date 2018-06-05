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

import pi.vezbe.converters.ChatToChatDTOConverter;
import pi.vezbe.converters.KategorijaSmestajaToKategorijaSmestajaDTOConverter;
import pi.vezbe.model.Chat;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.Poruka;
import pi.vezbe.service.ChatService;
import pi.vezbe.service.PorukaService;
import pi.vezbe.service.UserService;

@RestController()
@RequestMapping(value = "/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PorukaService porukaService;
	
	@Autowired 
	private ChatToChatDTOConverter chatToChatDTOConverter;
	
	@Autowired
	private KategorijaSmestajaToKategorijaSmestajaDTOConverter kategorijaSmestajaToKategorijaSmestajaDTOConverter;
	
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
		Chat chat = chatService.findByKorisniciIn(ids);
		
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
		
		porukaService.save(poruka);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
