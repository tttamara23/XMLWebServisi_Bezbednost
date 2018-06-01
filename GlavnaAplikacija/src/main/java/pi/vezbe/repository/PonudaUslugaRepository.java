package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.PonudaUsluga;

public interface PonudaUslugaRepository extends JpaRepository<PonudaUsluga, Long> {
	
	public List<PonudaUsluga> getByPonudaId(Long ponudaId);

}
