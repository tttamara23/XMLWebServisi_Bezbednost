package pi.vezbe.dto;

import org.springframework.stereotype.Component;

@Component
public class SmestajVlasnikDTO {
	private SmestajDTO smestajDTO;
	private AgentDTO vlasnikDTO;
	public SmestajDTO getSmestajDTO() {
		return smestajDTO;
	}
	public void setSmestajDTO(SmestajDTO smestajDTO) {
		this.smestajDTO = smestajDTO;
	}
	public AgentDTO getVlasnikDTO() {
		return vlasnikDTO;
	}
	public void setVlasnikDTO(AgentDTO vlasnikDTO) {
		this.vlasnikDTO = vlasnikDTO;
	}
	public SmestajVlasnikDTO(SmestajDTO smestajDTO, AgentDTO vlasnikDTO) {
		super();
		this.smestajDTO = smestajDTO;
		this.vlasnikDTO = vlasnikDTO;
	}
	public SmestajVlasnikDTO() {
		super();
	}
	
	
	
	
}
