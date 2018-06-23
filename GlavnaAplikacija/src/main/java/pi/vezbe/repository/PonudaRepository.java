package pi.vezbe.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;

import pi.vezbe.model.Ponuda;

public interface PonudaRepository extends JpaRepository<Ponuda, Long> {
	
	List<Ponuda> findBySmestajId(Long smestajId);
	
	List<Ponuda> findByDatumOdGreaterThanAndSmestajIdOrderByDatumOdAsc(Date start,Long idSmestaj);
	
	List<Ponuda> findAll();
	
	/*@Query(value="SELECT pnd FROM Ponuda "
			+ "JOIN Smestaj ON Ponuda.id_smestaj=Smestaj.id "
			+ "JOIN TipSmestaja ON Smestaj.id_tip_smestaja=TipSmestaja.id "
			+ "JOIN KategorijaSmestaja ON Smestaj.id_kategorija_smestaja=KategorijaSmestaja.id "
			+ "WHERE pnd.datumOd GREATER THAN :dateFrom "
			+ "AND pnd.datumDo LESS THAN :dateTo "
			+ "AND UPPER(Smestaj.lokacija) LIKE UPPER(%:lokacija%) "
			+ "AND pnd.brojLezaja=:brojLezaja "
			+ "AND TipSmestaja.id=:idTipSmestaja "
			+ "AND KategorijaSmestaja.id=:idKategorijaSmestaja",
			nativeQuery=true)
	List<Ponuda> search(@Param("dateFrom") Date dateFrom, 
			@Param("dateTo") Date dateTo, 
			@Param("lokacija") String lokacija, 
			@Param("brojLezaja") int brojLezaja,
			@Param("idTipSmestaja") Long idTipSmestaja, 
			@Param("idKategorijaSmestaja") Long idKategorijaSmestaja);*/
	
	//napredna
	List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojLezajaAndSmestajTipSmestajaIdAndSmestajKategorijaSmestajaIdOrderByCena  
	(String naziv, int brojLezaja, Long tip, Long idKategorija);
	
	List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojLezajaAndSmestajTipSmestajaIdAndSmestajKategorijaSmestajaIdOrderBySmestajKategorijaSmestajaId
	(String naziv, int brojLezaja, Long tip, Long idKategorija);
	
	List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojLezajaAndSmestajTipSmestajaIdAndSmestajKategorijaSmestajaId
	(String naziv, int brojLezaja, Long tip, Long idKategorija);
	
	
	
	//nije napredna
	List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojLezajaOrderByCena
	(String naziv, int brojLezaja);
	
	List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojLezajaOrderBySmestajKategorijaSmestajaId
	(String naziv, int brojLezaja);
	
	List<Ponuda> findBySmestajLokacijaContainingIgnoreCaseAndBrojLezaja
	(String naziv, int brojLezaja);
	

}
