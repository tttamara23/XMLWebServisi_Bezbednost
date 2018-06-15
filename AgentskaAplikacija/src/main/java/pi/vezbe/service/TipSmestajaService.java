package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.TipSmestaja;
import pi.vezbe.repository.TipSmestajaRepository;

@Service
public class TipSmestajaService {
	@Autowired
	private TipSmestajaRepository tipSmestajaRepository;
	
	public List<TipSmestaja> findAllTipS(){
		return tipSmestajaRepository.findAll();
	}
	
	public TipSmestaja findById(String id){
		Long idTipa = Long.parseLong(id);
		return tipSmestajaRepository.findById(idTipa);
	}
	public TipSmestaja save(TipSmestaja tipS) {
		return tipSmestajaRepository.save(tipS);
	}
}
