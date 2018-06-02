package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.KategorijaSmestaja;

public interface KategorijaSmestajaRepository extends JpaRepository<KategorijaSmestaja, Long> {
	public List<KategorijaSmestaja> findAll();
	public KategorijaSmestaja findById(Long id);
}
