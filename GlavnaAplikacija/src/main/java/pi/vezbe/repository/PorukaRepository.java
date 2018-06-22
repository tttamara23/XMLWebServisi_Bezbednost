package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Chat;
import pi.vezbe.model.Poruka;

public interface PorukaRepository extends JpaRepository<Poruka, Long> {
	
	List<Poruka> findByChatIdOrderByDatumSlanja(Long idChat);
	int countByChatIdAndPosiljalacIdNotAndSeen(Long idChat, Long idKorisnik, boolean seen);
	List<Poruka> findByChatIdAndPosiljalacIdNotAndSeen(Long idChat, Long idKorisnik, boolean seen);
	List<Poruka> findAll();
}
