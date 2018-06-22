package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Chat;
import pi.vezbe.model.Korisnik;
import pi.vezbe.repository.ChatRepository;

@Service
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;
	
	public Chat save(Chat chat) {
		return chatRepository.save(chat);
	}
	
	public Chat findExistingChat(List<Korisnik> id) {
		List<Chat> chats =  chatRepository.findAll();
		for(Chat chat : chats){
			boolean found = true;
			for(Korisnik korisnik : id){
				if(!chat.findKorisnik(korisnik)){
					found = false;
					break;
				}
			}
			if(found==true){
				return chat;
			}
		}
		
		return null;
	}
	
	public List<Chat> findAllByKorisniciId(Long id){
		return chatRepository.findAllByKorisniciId(id);
	}
	
	public Chat findById(Long id){
		return chatRepository.findOne(id);
	}
	public List<Chat> findAll(){
		return chatRepository.findAll();
	}
	
}
