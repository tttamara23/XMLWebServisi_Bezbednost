package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Chat;
import pi.vezbe.model.Korisnik;

public interface ChatRepository extends JpaRepository<Chat, Long> {
	
	List<Chat> findAllByKorisniciId(Long id);

}
