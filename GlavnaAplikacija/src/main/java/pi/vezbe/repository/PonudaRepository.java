package pi.vezbe.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Ponuda;

public interface PonudaRepository extends JpaRepository<Ponuda, Long> {
	
	List<Ponuda> findBySmestajId(Long smestajId);
	
	List<Ponuda> findByDatumOdGreaterThanAndSmestajIdOrderByDatumOdAsc(Date start,Long idSmestaj);
	
	List<Ponuda> findByDatumOdGreaterThanAndDatumDoLessThanAndSmestajLokacijaContainingIgnoreCaseAndBrojLezajaAndSmestajTipSmestajaIdAndSmestajKategorijaSmestajaId   
		(Date dateFrom, Date dateTo, String naziv, int brojLezaja, Long tip, Long idKategorija);
	
	List<Ponuda> findByDatumOdGreaterThanAndDatumDoLessThanAndSmestajLokacijaContainingIgnoreCaseAndBrojLezajaAndSmestajTipSmestajaId 
	(Date dateFrom, Date dateTo, String naziv, int brojLezaja, Long tip);

}
