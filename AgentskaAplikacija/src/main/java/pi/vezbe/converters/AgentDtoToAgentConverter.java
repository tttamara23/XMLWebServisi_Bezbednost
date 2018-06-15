package pi.vezbe.converters;

import javax.jws.soap.SOAPBinding;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.AgentDTO;
import pi.vezbe.model.Agent;

@Component
public class AgentDtoToAgentConverter implements Converter<AgentDTO, Agent> {

	@Override
	public Agent convert(AgentDTO source) {
		Agent agent = new Agent();
		agent.setIme(source.getIme());
		agent.setPrezime(source.getPrezime());
		agent.setEmail(source.getEmail());
		agent.setKontakt(source.getKontakt());
		agent.setLozinka(source.getLozinka());
		agent.setPoslovniMaticniBroj(source.getPoslovniMaticniBroj());
		
		return agent;
	}
	

}
