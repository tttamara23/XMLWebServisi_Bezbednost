package pi.vezbe.dto;

public class RegisterDTO {
	
	private String ime;
	private String prezime;
	private String email;
	private String kontakt;
	private String password;
	private String passwordConfirm;
	
	public RegisterDTO(String ime, String prezime, String email, String kontakt, String password,
			String passwordConfirm) {
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.kontakt = kontakt;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
	
	public RegisterDTO() {
		
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

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
