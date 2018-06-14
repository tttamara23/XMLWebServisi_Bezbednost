package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Slika;

public interface SlikaRepository extends JpaRepository<Slika, Long> {
	
	List<Slika> findBySmestajId(Long idSmestaj);

}
