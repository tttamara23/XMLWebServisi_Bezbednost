package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.ChatKorisnik;

public interface ChatKorisnikRepository extends JpaRepository<ChatKorisnik, Long> {

	List<ChatKorisnik> findAllByChatId(Long idChat);

	List<ChatKorisnik> findAllByUcesnikId(Long id);

}
