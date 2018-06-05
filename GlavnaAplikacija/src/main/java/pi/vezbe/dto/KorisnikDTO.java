package pi.vezbe.dto;

public class KorisnikDTO {
	
	private Long id;
	private String email;
	
	public KorisnikDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public KorisnikDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
