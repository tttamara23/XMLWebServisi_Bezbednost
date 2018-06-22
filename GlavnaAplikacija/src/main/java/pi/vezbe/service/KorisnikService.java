package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Korisnik;
import pi.vezbe.repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	public List<Korisnik> findAll(){
		return korisnikRepository.findAll();
	}
}
