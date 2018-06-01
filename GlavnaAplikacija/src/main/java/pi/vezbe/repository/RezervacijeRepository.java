package pi.vezbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Rezervacija;

public interface RezervacijeRepository extends JpaRepository<Rezervacija, Long>{

	
}
