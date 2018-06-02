package pi.vezbe.dto;

public class KategorijaSmestajaDTO {
	
	private Long id;
	private String kategorija;
	
	public KategorijaSmestajaDTO(){
		
	}

	public KategorijaSmestajaDTO(Long id, String kategorija) {
		super();
		this.id = id;
		this.kategorija = kategorija;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	
	
}
