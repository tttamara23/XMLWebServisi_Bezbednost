package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Usluga;

public interface UslugaRepository extends JpaRepository<Usluga, Long>{
	
	List<Usluga> findByIdNotIn(List<Long> id);
}
