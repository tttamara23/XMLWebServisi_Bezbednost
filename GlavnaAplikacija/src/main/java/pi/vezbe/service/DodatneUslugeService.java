package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.DodatneUsluge;
import pi.vezbe.model.KategorijaSmestaja;
import pi.vezbe.repository.DodatneUslugeRepository;

@Service
public class DodatneUslugeService {
	@Autowired
	private DodatneUslugeRepository dodatneUslugeRepository;
	
	public List<DodatneUsluge> findAllDU(){
		return dodatneUslugeRepository.findAll();
	}
	
	public DodatneUsluge findById(String id){
		Long idKatS = Long.parseLong(id);
		return dodatneUslugeRepository.findById(idKatS);
	}
	public DodatneUsluge save(DodatneUsluge dodU) {
		return dodatneUslugeRepository.save(dodU);
	}
	public void delete(DodatneUsluge zaBrisanje) {
		dodatneUslugeRepository.delete(zaBrisanje);
	}
}
