package pi.vezbe.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Ponuda;
import pi.vezbe.repository.PonudaRepository;

@Service
public class PonudaService {

	@Autowired
	private PonudaRepository ponudaRepository;
	
	public List<Ponuda> getBySmestaj(Long smestajId) {
		return ponudaRepository.findBySmestajId(smestajId);
	}
	
	public List<Ponuda> getByCurrentDateAndSmestajId(Date start,Long idSmestaja){
		return ponudaRepository.findByDatumOdGreaterThanAndSmestajIdOrderByDatumOdAsc(start, idSmestaja);
	}

	public Ponuda findOne(Long idPonuda) {
		// TODO Auto-generated method stub
		return ponudaRepository.findOne(idPonuda);
	}

	public Ponuda save(Ponuda ponuda) {
		// TODO Auto-generated method stub
		return ponudaRepository.save(ponuda);
	}
	
	
	public List<Ponuda> searchAdvanced(Date dateFrom, Date dateTo, String naziv, int brojLezaja, Long tip, Long idKategorija, List<Long> usluge) {
		return ponudaRepository.findByDatumOdGreaterThanAndDatumDoLessThanAndSmestajLokacijaContainingIgnoreCaseAndBrojLezajaAndSmestajTipSmestajaIdAndSmestajKategorijaSmestajaIdAndPonudaUslugaIdContaining(dateFrom, dateTo, naziv, brojLezaja, tip, idKategorija, usluge);
	}
	
	public List<Ponuda> searchNotAdvanced(Date dateFrom, Date dateTo, String naziv, int brojLezaja) {
		return ponudaRepository.findByDatumOdGreaterThanAndDatumDoLessThanAndSmestajLokacijaContainingIgnoreCaseAndBrojLezaja(dateFrom, dateTo, naziv, brojLezaja);
	}
	
}
