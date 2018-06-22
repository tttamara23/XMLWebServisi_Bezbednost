package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.ChatKorisnik;
import pi.vezbe.repository.ChatKorisnikRepository;

@Service
public class ChatKorisnikService {
	
	@Autowired
	private ChatKorisnikRepository chatKorisnikRepo;

	public List<ChatKorisnik> findAll() {
		// TODO Auto-generated method stub
		return chatKorisnikRepo.findAll();
	}

	public void save(ChatKorisnik newChatKorisnik) {
		// TODO Auto-generated method stub
		chatKorisnikRepo.save(newChatKorisnik);
	}

	public List<ChatKorisnik> findByChatId(Long idChat) {
		// TODO Auto-generated method stub
		return chatKorisnikRepo.findAllByChatId(idChat);
	}

	public List<ChatKorisnik> findByUcesnikId(Long id) {
		// TODO Auto-generated method stub
		return chatKorisnikRepo.findAllByUcesnikId(id);
	}
	
	

}
