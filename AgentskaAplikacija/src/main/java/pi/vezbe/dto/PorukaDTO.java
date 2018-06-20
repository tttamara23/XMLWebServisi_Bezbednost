package pi.vezbe.dto;

public class PorukaDTO {
	
	private Long id;
	private String sadrzaj;
	private boolean poslata;
	private String datum;
	private KorisnikDTO posiljalac;
	
	public PorukaDTO(Long id, String sadrzaj, boolean poslata, String datum) {
		this.id = id;
		this.sadrzaj = sadrzaj;
		this.poslata = poslata;
		this.datum = datum;
	}
	
	public PorukaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public boolean isPoslata() {
		return poslata;
	}

	public void setPoslata(boolean poslata) {
		this.poslata = poslata;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public KorisnikDTO getPosiljalac() {
		return posiljalac;
	}

	public void setPosiljalac(KorisnikDTO posiljalac) {
		this.posiljalac = posiljalac;
	}
	
	

}
