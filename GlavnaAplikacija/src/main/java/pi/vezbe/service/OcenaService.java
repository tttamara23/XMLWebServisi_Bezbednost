package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Ocena;
import pi.vezbe.repository.OcenaRepository;

@Service
public class OcenaService {

	@Autowired
	private OcenaRepository ocenaRepository;

	public Ocena save(Ocena ocena) {
		// TODO Auto-generated method stub
		return ocenaRepository.save(ocena);
	}
	
	public List<Ocena> findBySmestaj(Long idSmestaj) {
		return ocenaRepository.findBySmestajId(idSmestaj);
	}
	
	
}
