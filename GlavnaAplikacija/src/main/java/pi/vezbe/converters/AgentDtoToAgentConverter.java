package pi.vezbe.converters;

import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.AgentDTO;
import pi.vezbe.model.Agent;
import pi.vezbe.service.Encryptor;
import pi.vezbe.service.RoleService;

@Component
public class AgentDtoToAgentConverter implements Converter<AgentDTO, Agent> {

	@Autowired
	private RoleService roleService;
	
	@Override
	public Agent convert(AgentDTO source) {
		Agent agent = new Agent();
		agent.setIme(source.getIme());
		agent.setPrezime(source.getPrezime());
		agent.setEmail(source.getEmail());
		agent.setKontakt(source.getKontakt());
		//agent.setLozinka(source.getLozinka());
		agent.setRole(roleService.findById(3L));
		agent.setPoslovniMaticniBroj(Encryptor.encrypt(source.getPoslovniMaticniBroj()));
		
		return agent;
	}
	

}
