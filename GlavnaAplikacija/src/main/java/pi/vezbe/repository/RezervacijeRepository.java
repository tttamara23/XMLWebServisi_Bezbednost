package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Rezervacija;

public interface RezervacijeRepository extends JpaRepository<Rezervacija, Long>{

	List<Rezervacija> findByPonudaSmestajIdAndKorisnikIdAndRealizovano(Long smestajId, Long korisnikId, boolean realizovano);
	List<Rezervacija> findAll();
}
