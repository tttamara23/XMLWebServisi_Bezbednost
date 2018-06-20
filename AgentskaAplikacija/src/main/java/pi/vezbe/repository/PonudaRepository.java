package pi.vezbe.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Ponuda;

public interface PonudaRepository extends JpaRepository<Ponuda, Long> {
	
	List<Ponuda> findBySmestajId(Long smestajId);
	
	List<Ponuda> findByDatumOdGreaterThanAndSmestajIdOrderByDatumOdAsc(Date start,Long idSmestaj);
	
	/*List<Ponuda> findByDatumOdGreaterThanAndDatumDoLessThanAndSmestajLokacijaContainingIgnoreCaseAndBrojLezajaAndSmestajTipContainingIgnoreCaseAndSmestajKategorija     
		(Date dateFrom, Date dateTo, String naziv, int brojLezaja, String tip, int kategorija);
	
	List<Ponuda> findByDatumOdGreaterThanAndDatumDoLessThanAndSmestajLokacijaContainingIgnoreCaseAndBrojLezajaAndSmestajTipContainingIgnoreCase 
	(Date dateFrom, Date dateTo, String naziv, int brojLezaja, String tip);*/

}
