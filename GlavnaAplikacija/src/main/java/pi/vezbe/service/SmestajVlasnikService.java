package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.SmestajVlasnik;
import pi.vezbe.repository.SmestajVlasnikRepository;

@Service
public class SmestajVlasnikService {

	@Autowired
	private SmestajVlasnikRepository smestajVlasnikRepository;

	public List<SmestajVlasnik> findByIdSmestajId(Long idSmestaja) {
		// TODO Auto-generated method stub
		return smestajVlasnikRepository.findBySmestajId(idSmestaja);
	}
	
	public List<SmestajVlasnik> findAll() {
		// TODO Auto-generated method stub
		return smestajVlasnikRepository.findAll();
	}
	
	public SmestajVlasnik save(SmestajVlasnik toSave){
		return smestajVlasnikRepository.save(toSave);
	}
	
}
