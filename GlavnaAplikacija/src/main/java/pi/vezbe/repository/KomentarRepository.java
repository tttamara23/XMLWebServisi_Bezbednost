package pi.vezbe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Komentar;
import pi.vezbe.model.KrajnjiKorisnik;

public interface KomentarRepository extends JpaRepository<Komentar, Long> {
	
	public List<Komentar> findAll();
	public Komentar findById(Long id);
}
