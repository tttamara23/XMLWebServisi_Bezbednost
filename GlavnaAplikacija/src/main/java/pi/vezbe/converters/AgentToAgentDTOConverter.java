package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.AgentDTO;
import pi.vezbe.model.Agent;
import pi.vezbe.service.Encryptor;

@Component
public class AgentToAgentDTOConverter implements Converter<Agent, AgentDTO>{

	@Override
	public AgentDTO convert(Agent arg0) {
		// TODO Auto-generated method stub
		if(arg0==null){
			return null;
		}
		
		AgentDTO agentDTO = new AgentDTO();
		agentDTO.setIme(arg0.getIme());
		agentDTO.setPrezime(arg0.getPrezime());
		agentDTO.setEmail(arg0.getEmail());
		agentDTO.setKontakt(arg0.getKontakt());
		agentDTO.setLozinka(arg0.getLozinka());
		String key = "Bar12345Bar12345"; // 128 bit key
	     String initVector = "RandomInitVector"; // 16 bytes IV
	        
		agentDTO.setPoslovniMaticniBroj(arg0.getPoslovniMaticniBroj());
		
		agentDTO.setId(arg0.getId());
		
		return agentDTO;
	}
	
	public List<AgentDTO> convert(List<Agent> source) {
		List<AgentDTO> ret = new ArrayList<AgentDTO>();
		for(Agent agent : source) {
			ret.add(convert(agent));
		}
		return ret;
	}

}
