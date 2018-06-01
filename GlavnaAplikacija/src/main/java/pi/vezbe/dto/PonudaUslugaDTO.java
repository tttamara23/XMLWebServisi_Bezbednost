package pi.vezbe.dto;

public class PonudaUslugaDTO {

	private PonudaDTO ponudaDTO;
	private UslugaDTO uslugaDTO;
	
	public PonudaUslugaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PonudaUslugaDTO(PonudaDTO ponudaDTO, UslugaDTO uslugaDTO) {
		this.ponudaDTO = ponudaDTO;
		this.uslugaDTO = uslugaDTO;
	}

	public PonudaDTO getPonudaDTO() {
		return ponudaDTO;
	}

	public void setPonudaDTO(PonudaDTO ponudaDTO) {
		this.ponudaDTO = ponudaDTO;
	}

	public UslugaDTO getUslugaDTO() {
		return uslugaDTO;
	}

	public void setUslugaDTO(UslugaDTO uslugaDTO) {
		this.uslugaDTO = uslugaDTO;
	}
	
}
