package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Poruka;
import pi.vezbe.repository.PorukaRepository;

@Service
public class PorukaService {

	@Autowired
	private PorukaRepository porukaRepository;
	
	public Poruka save(Poruka poruka) {
		return porukaRepository.save(poruka);
	}
	
	public List<Poruka> findByChat(Long idChat) {
		return porukaRepository.findByChatIdOrderByDatumSlanja(idChat);
	}
	
}
