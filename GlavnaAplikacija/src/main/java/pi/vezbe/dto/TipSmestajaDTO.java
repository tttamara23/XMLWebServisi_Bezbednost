package pi.vezbe.dto;

public class TipSmestajaDTO {
	private Long id;
	private String naziv;
	
	public TipSmestajaDTO(){
		
	}
	
	public TipSmestajaDTO(Long id, String naziv) {
		super();
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
