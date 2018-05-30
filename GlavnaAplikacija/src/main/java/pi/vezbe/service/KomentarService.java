package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Komentar;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.repository.KomentarRepository;
@Service
public class KomentarService {

	@Autowired
	private KomentarRepository komentarRepository;
	
	public List<Komentar> findAllComments(){
		List<Komentar> svi = komentarRepository.findAll();
		for(int i = svi.size()-1; i >= 0; i--){
			if(svi.get(i).isObjavljen()){
				svi.remove(i);
			}
		}
		return svi;
	}
	
	public Komentar findById(String id){
		Long idKom = Long.parseLong(id);
		return komentarRepository.findById(idKom);
	}
	public Komentar save(Komentar komentar) {
		return komentarRepository.save(komentar);
	}
}
