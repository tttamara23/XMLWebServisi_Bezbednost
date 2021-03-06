package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.PonudaUsluga;
import pi.vezbe.repository.PonudaUslugaRepository;

@Service
public class PonudaUslugaService {

	@Autowired
	private PonudaUslugaRepository ponudaUslugaRepository;
	
	public List<PonudaUsluga> getByPonuda(Long ponudaId) {
		return ponudaUslugaRepository.getByPonudaId(ponudaId);
	}
	
	public List<PonudaUsluga> getAll(){
		return ponudaUslugaRepository.findAll();
	}

	public void save(PonudaUsluga ponudaUsluga) {
		// TODO Auto-generated method stub
		ponudaUslugaRepository.save(ponudaUsluga);
	}
	
}
