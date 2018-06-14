package pi.vezbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Ocena;
import pi.vezbe.model.Ponuda;

public interface OcenaRepository extends JpaRepository<Ocena, Long>{

	Ocena save(Ocena ocena);

}
