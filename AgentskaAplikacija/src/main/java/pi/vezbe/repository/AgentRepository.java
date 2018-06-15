package pi.vezbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
