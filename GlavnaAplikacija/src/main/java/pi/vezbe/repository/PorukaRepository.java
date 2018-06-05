package pi.vezbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Poruka;

public interface PorukaRepository extends JpaRepository<Poruka, Long> {

}
