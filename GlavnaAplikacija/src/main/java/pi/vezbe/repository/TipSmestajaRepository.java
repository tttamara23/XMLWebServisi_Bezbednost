package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.TipSmestaja;

public interface TipSmestajaRepository extends JpaRepository<TipSmestaja, Long> {
	public List<TipSmestaja> findAll();
	public TipSmestaja findById(Long id);
}
