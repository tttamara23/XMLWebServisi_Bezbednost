package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Poruka;

public interface PorukaRepository extends JpaRepository<Poruka, Long> {
	
	List<Poruka> findByChatIdOrderByDatumSlanja(Long idChat);

}
