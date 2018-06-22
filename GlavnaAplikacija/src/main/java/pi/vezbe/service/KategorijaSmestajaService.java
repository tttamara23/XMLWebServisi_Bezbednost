package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.KategorijaSmestaja;
import pi.vezbe.model.TipSmestaja;
import pi.vezbe.repository.KategorijaSmestajaRepository;

@Service
public class KategorijaSmestajaService {
	
	@Autowired
	private KategorijaSmestajaRepository kategorijaSmestajaRepository;
	
	public List<KategorijaSmestaja> findAllKS(){
		return kategorijaSmestajaRepository.findAll();
	}
	
	public KategorijaSmestaja findById(String id){
		Long idKatS = Long.parseLong(id);
		return kategorijaSmestajaRepository.findById(idKatS);
	}
	public KategorijaSmestaja save(KategorijaSmestaja katS) {
		return kategorijaSmestajaRepository.save(katS);
	}
	public void delete(KategorijaSmestaja zaBrisanje) {
		kategorijaSmestajaRepository.delete(zaBrisanje);
	}
	public KategorijaSmestaja findByKategorija(String kategorija){
		return kategorijaSmestajaRepository.findByKategorija(kategorija);
	}
}
