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
	
	public Chat findByKorisniciIn(List<Korisnik> id) {
		return chatRepository.findAllByKorisniciIn(id);
	}
	
}
