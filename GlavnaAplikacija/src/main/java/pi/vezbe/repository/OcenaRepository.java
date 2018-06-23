package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Long>{

	Ocena save(Ocena ocena);
	List<Ocena> findBySmestajId(Long idSmestaj);

}
