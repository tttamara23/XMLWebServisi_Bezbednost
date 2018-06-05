package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Usluga;
import pi.vezbe.repository.UslugaRepository;

@Service
public class UslugaService {

	@Autowired
	private UslugaRepository uslugaRepository;

	public List<Usluga> findAll() {
		// TODO Auto-generated method stub
		return uslugaRepository.findAll();
	}
	
	public List<Usluga> findByIdNotIn(List<Long> id) {
		// TODO Auto-generated method stub
		return uslugaRepository.findByIdNotIn(id);
	}
	
	
}
