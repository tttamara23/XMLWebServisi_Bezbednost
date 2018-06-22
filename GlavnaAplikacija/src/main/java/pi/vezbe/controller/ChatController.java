package pi.vezbe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.annotations.PermissionAnnotation;
import pi.vezbe.converters.ChatToChatDTOConverter;
import pi.vezbe.converters.KategorijaSmestajaToKategorijaSmestajaDTOConverter;
import pi.vezbe.converters.KorisnikToKorisnikDTOConverter;
import pi.vezbe.dto.ChatDTO;
import pi.vezbe.model.Chat;
import pi.vezbe.model.ChatKorisnik;
import pi.vezbe.model.Korisnik;
import pi.vezbe.service.ChatKorisnikService;
import pi.vezbe.service.ChatService;
import pi.vezbe.service.PorukaService;
import pi.vezbe.service.UserService;

@RestController()
@RequestMapping(value = "/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatKorisnikService chatKorsnikService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PorukaService porukaService;
	
	@Autowired 
	private ChatToChatDTOConverter chatToChatDTOConverter;
	
	@Autowired 
	private KorisnikToKorisnikDTOConverter korisnikToKorisnikDTOConverter;
	
	@Autowired
	private KategorijaSmestajaToKategorijaSmestajaDTOConverter kategorijaSmestajaToKategorijaSmestajaDTOConverter;
	
	
	@PermissionAnnotation(name = "GET_CHATS")
	@CrossOrigin
	@RequestMapping(
            value = "/findAllByKorisniciId",
            method = RequestMethod.GET
    )
	public ResponseEntity<?> findAllByKorisniciId(){
		Korisnik korisnik = userService.getCurrentUser();
		//List<Chat> chats = chatService.findAllByKorisniciId(korisnik.getId());
		List<ChatDTO> chatsDTO = new ArrayList<ChatDTO>();
		List<ChatKorisnik> chatKorisniciStotiPut = chatKorsnikService.findByUcesnikId(korisnik.getId());
		for(ChatKorisnik ck : chatKorisniciStotiPut){
			ChatDTO chatDTO = new ChatDTO();
			chatDTO.setId(ck.getChat().getId());
			chatDTO.setUnseen(porukaService.countUnseen(ck.getChat().getId(), korisnik.getId()));
			
			List<ChatKorisnik> ckKorisnici = chatKorsnikService.findByChatId(ck.getChat().getId());
			for(ChatKorisnik ck2 : ckKorisnici){
				if(!ck2.getUcesnik().getId().equals(korisnik.getId())){
					chatDTO.getKorisnici().add(korisnikToKorisnikDTOConverter.convert(ck2.getUcesnik()));				
				}
			}
			chatsDTO.add(chatDTO);
		}
		
		return new ResponseEntity<>(chatsDTO,HttpStatus.OK);
	}

}
