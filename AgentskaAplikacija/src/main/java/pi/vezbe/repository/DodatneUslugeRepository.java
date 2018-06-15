package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.DodatneUsluge;

public interface DodatneUslugeRepository extends JpaRepository<DodatneUsluge, Long> {
	public List<DodatneUsluge> findAll();
	public DodatneUsluge findById(Long id);
}