package pi.vezbe.dto;

public class PonudaDTO {
	
	private Long id;
	private String datumOd;
	private String datumDo;
	private double cena;
	private int brojLezaja;
    private int brojSlobodnihPonuda;
    private Long smestajId;
    private String smestajNaziv;
    
    public PonudaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PonudaDTO(Long id, String datumOd, String datumDo, double cena, int brojLezaja, int brojSlobodnihPonuda,
			Long smestajId, String smestajNaziv) {
		this.id = id;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.cena = cena;
		this.brojLezaja = brojLezaja;
		this.brojSlobodnihPonuda = brojSlobodnihPonuda;
		this.smestajId = smestajId;
		this.smestajNaziv = smestajNaziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(String datumOd) {
		this.datumOd = datumOd;
	}

	public String getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(String datumDo) {
		this.datumDo = datumDo;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getBrojLezaja() {
		return brojLezaja;
	}

	public void setBrojLezaja(int brojLezaja) {
		this.brojLezaja = brojLezaja;
	}

	public int getBrojSlobodnihPonuda() {
		return brojSlobodnihPonuda;
	}

	public void setBrojSlobodnihPonuda(int brojSlobodnihPonuda) {
		this.brojSlobodnihPonuda = brojSlobodnihPonuda;
	}

	public Long getSmestajId() {
		return smestajId;
	}

	public void setSmestajId(Long smestajId) {
		this.smestajId = smestajId;
	}

	public String getSmestajNaziv() {
		return smestajNaziv;
	}

	public void setSmestajNaziv(String smestajNaziv) {
		this.smestajNaziv = smestajNaziv;
	}

}
