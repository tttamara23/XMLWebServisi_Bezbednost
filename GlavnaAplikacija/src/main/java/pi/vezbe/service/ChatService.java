package pi.vezbe.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.lang.Collections;
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
		ArrayList<Long> id1 = new ArrayList<Long>();
		ArrayList<Long> id2;
		
		for(Korisnik korisnik : id) {
			id1.add(korisnik.getId());
		}
		for(ChatKorisnik chatKorisnik : chatsKorisnik){
			Chat chat = chatRepository.findOne(chatKorisnik.getChat().getId());
			id2 = new ArrayList<Long>();
			for(ChatKorisnik k : chat.getChatKorisnik()) {
				id2.add(k.getUcesnik().getId());
			}
			if(id1.containsAll(id2)) {
				return chat;
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
