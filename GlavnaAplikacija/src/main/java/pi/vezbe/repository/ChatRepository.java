package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
	
	Chat findByKorisniciIdIn(List<Long> ids);

}
