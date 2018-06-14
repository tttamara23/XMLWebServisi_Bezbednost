package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Slika;
import pi.vezbe.repository.SlikaRepository;

@Service
public class SlikaService {

	@Autowired
	private SlikaRepository slikaRepository;
	
	public List<Slika> findBySmestaj(Long idSmestaj) {
		return slikaRepository.findBySmestajId(idSmestaj);
	}
	
}
