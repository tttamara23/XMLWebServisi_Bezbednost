package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Chat;
import pi.vezbe.model.ChatKorisnik;
import pi.vezbe.model.Korisnik;
import pi.vezbe.repository.ChatRepository;

@Service
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private ChatKorisnikService chatKorisnikService;
	
	public Chat save(Chat chat) {
		return chatRepository.save(chat);
	}
	
	public Chat findExistingChat(List<Korisnik> id) {
		List<ChatKorisnik> chatsKorisnik =  chatKorisnikService.findAll();
		if(chatsKorisnik == null){
			return null;
		}
		for(ChatKorisnik chat : chatsKorisnik){
			boolean found = true;
			for(Korisnik korisnik : id){
				if(!chat.getUcesnik().getId().equals(korisnik.getId())){
					found = false;
				}
			}
			if(found==true){
				Chat retVal = chatRepository.findOne(chat.getChat().getId());
				return retVal;
			}
		}
		
		return null;
	}
	
	
	
	public Chat findById(Long id){
		return chatRepository.findOne(id);
	}
	public List<Chat> findAll(){
		return chatRepository.findAll();
	}
	
}
