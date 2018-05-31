package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pi.vezbe.model.Smestaj;

public interface SmestajRepository extends JpaRepository<Smestaj, Long> {
	
	@Query(value="SELECT DISTINCT lokacija FROM Smestaj")
	public List<Smestaj> findLocations();
	
	public List<Smestaj> findByLokacija(String lokacija);

}
