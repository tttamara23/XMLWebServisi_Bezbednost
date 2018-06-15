package pi.vezbe.dto;

public class AgentDTO {
	
	private Long id;
	private String ime;
	private String prezime;
	private String email;
	private String lozinka;
	private String kontakt;
	private String poslovniMaticniBroj;
	
	public AgentDTO() {}

	public AgentDTO(Long id, String ime, String prezime, String email, String lozinka, String kontakt,
			String poslovniMaticniBroj) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.kontakt = kontakt;
		this.poslovniMaticniBroj = poslovniMaticniBroj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getPoslovniMaticniBroj() {
		return poslovniMaticniBroj;
	}

	public void setPoslovniMaticniBroj(String poslovniMaticniBroj) {
		this.poslovniMaticniBroj = poslovniMaticniBroj;
	}
	
	

}
