package pi.vezbe.dto;

public class SmestajDTO {
	
	private Long id;
	private String naziv;
	private String tip;
	private int kategorija;
	private String lokacija;
	private String opis;
	
	public SmestajDTO(Long id, String naziv, String tip, int kategorija, String lokacija, String opis) {
		this.id = id;
		this.naziv = naziv;
		this.tip = tip;
		this.kategorija = kategorija;
		this.lokacija = lokacija;
		this.opis = opis;
	}
	
	public SmestajDTO() {
		// TODO Auto-generated constructor stub
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getKategorija() {
		return kategorija;
	}

	public void setKategorija(int kategorija) {
		this.kategorija = kategorija;
	}

	public String getLokacija() {
		return lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

}
