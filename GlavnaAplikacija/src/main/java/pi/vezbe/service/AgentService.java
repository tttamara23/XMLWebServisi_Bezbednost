package pi.vezbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Agent;
import pi.vezbe.repository.AgentRepository;

@Service
public class AgentService {
	
	@Autowired
	private AgentRepository agentRepository;

	public Agent findOne(Long id) {
		return agentRepository.findOne(id);
	}

	public Agent save(Agent agent) {
		return agentRepository.save(agent);
	}

}
