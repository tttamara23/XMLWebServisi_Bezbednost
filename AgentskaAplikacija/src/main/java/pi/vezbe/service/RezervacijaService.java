package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Rezervacija;
import pi.vezbe.repository.RezervacijeRepository;

@Service
public class RezervacijaService {
	
	@Autowired
	private RezervacijeRepository rezervacijeRepository;

	public Rezervacija save(Rezervacija rezervacija) {
		// TODO Auto-generated method stub
		return rezervacijeRepository.save(rezervacija);
	}
	public Rezervacija findOne(Long idRezervacije) {
		// TODO Auto-generated method stub
		return rezervacijeRepository.findOne(idRezervacije);
	}

	public void delete(Long id ) {
		// TODO Auto-generated method stub
		 rezervacijeRepository.delete(id);
	}
	
	public List<Rezervacija> findAll(){
		return rezervacijeRepository.findAll();
	}


	
}
