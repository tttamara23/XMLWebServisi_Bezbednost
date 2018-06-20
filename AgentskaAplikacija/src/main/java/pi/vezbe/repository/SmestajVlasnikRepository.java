package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.SmestajVlasnik;

public interface SmestajVlasnikRepository  extends JpaRepository<SmestajVlasnik, Long>{

	List<SmestajVlasnik> findBySmestajId(Long idSmestaja);
	List<SmestajVlasnik> findByAgentId(Long idVlasnika);

}
