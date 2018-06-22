package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {
	public List<Agent> findAll();
	
}
