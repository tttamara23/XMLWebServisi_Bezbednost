package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.SmestajUsluga;
import pi.vezbe.repository.SmestajUslugaRepository;

@Service
public class SmestajUslugaService {
	
	@Autowired
	private SmestajUslugaRepository smestajUslugaRepo;
	
	public List<SmestajUsluga> findAllBySmestajId(Long id){
		return smestajUslugaRepo.findAllBySmestajId(id);
	}

	public SmestajUsluga save(SmestajUsluga smestajUsluga) {
		// TODO Auto-generated method stub
		return smestajUslugaRepo.save(smestajUsluga);
	}

}
