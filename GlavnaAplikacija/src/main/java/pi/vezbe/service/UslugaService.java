package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.DodatneUsluge;
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
	
	public Usluga findById(String id){
		Long idKatS = Long.parseLong(id);
		return uslugaRepository.findById(idKatS);
	}
	public Usluga save(Usluga dodU) {
		return uslugaRepository.save(dodU);
	}
	public void delete(Usluga zaBrisanje) {
		uslugaRepository.delete(zaBrisanje);
	}
	
}
