package pi.vezbe.dto;

public class UslugaDTO {
	
	private Long id;
	private String naziv;
	
	public UslugaDTO() {
		// TODO Auto-generated constructor stub
	}

	public UslugaDTO(Long id, String naziv) {
		this.id = id;
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
