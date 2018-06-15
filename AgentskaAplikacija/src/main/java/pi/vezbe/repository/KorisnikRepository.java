package pi.vezbe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	public <E extends Korisnik> Optional<E> findByEmailIgnoreCase(String email);

	public <E extends Korisnik> Optional<E> findById(Long id);
	
	public List<Korisnik> findAll();

}
