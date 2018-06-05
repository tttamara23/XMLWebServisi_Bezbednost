package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.SmestajVlasnikDTO;
import pi.vezbe.model.SmestajVlasnik;
@Component
public class SmestajVlasnikToSmestajVlasnikDTOConverter implements Converter<SmestajVlasnik, SmestajVlasnikDTO>{

	
	@Autowired
	private SmestajToSmestajDtoConverter smestajToSmestajDTOConverter;
	@Autowired
	private AgentToAgentDTOConverter agentToAgentDTOConverter;
	
	@Override
	public SmestajVlasnikDTO convert(SmestajVlasnik source) {
		// TODO Auto-generated method stub
		if(source==null){
			return null;
		}
		
		SmestajVlasnikDTO smestajVlasnikDTO = new SmestajVlasnikDTO();
		smestajVlasnikDTO.setSmestajDTO(smestajToSmestajDTOConverter.convert(source.getSmestaj()));
		smestajVlasnikDTO.setVlasnikDTO(agentToAgentDTOConverter.convert(source.getAgent()));
	return smestajVlasnikDTO;
	}

	public List<SmestajVlasnikDTO> convert(List<SmestajVlasnik> vlasnici) {
		// TODO Auto-generated method stub
		List<SmestajVlasnikDTO> ret = new ArrayList<SmestajVlasnikDTO>();
		for(SmestajVlasnik smestajVlasnik : vlasnici) {
			ret.add(convert(smestajVlasnik));
		}
		return ret;
	}

}
