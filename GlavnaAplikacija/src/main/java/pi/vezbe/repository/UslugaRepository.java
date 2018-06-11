package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.DodatneUsluge;
import pi.vezbe.model.Usluga;

public interface UslugaRepository extends JpaRepository<Usluga, Long>{
	public List<Usluga> findAll();
	public Usluga findById(Long id);
	List<Usluga> findByIdNotIn(List<Long> id);
}
