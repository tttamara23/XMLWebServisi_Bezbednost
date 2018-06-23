package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.SmestajUsluga;

public interface SmestajUslugaRepository extends JpaRepository<SmestajUsluga, Long>{
	List<SmestajUsluga> findAllBySmestajId(Long id);
}
