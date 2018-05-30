package pi.vezbe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Korisnik;
import pi.vezbe.model.KrajnjiKorisnik;

public interface KrajnjiKorisnikRepository extends JpaRepository<KrajnjiKorisnik, Long> {


	public List<KrajnjiKorisnik> findAll();
	public <E extends KrajnjiKorisnik> Optional<E> findByEmailIgnoreCase(String email);
	public void delete(KrajnjiKorisnik zaBrisanje);
	
}
