package pi.vezbe.dto;

import java.util.ArrayList;
import java.util.List;

public class SmestajDTO {
	
	private Long id;
	private String naziv;
	private String tip;
	private KategorijaSmestajaDTO kategorija;
	private String lokacija;
	private String opis;
	private List<PonudaDTO> ponude;
	private List<UslugaDTO> usluge;
	
	
	public SmestajDTO(Long id, String naziv, String tip, KategorijaSmestajaDTO kategorija, String lokacija, String opis) {
		this.id = id;
		this.naziv = naziv;
		this.tip = tip;
		this.kategorija = kategorija;
		this.lokacija = lokacija;
		this.opis = opis;
		
		ponude = new ArrayList<PonudaDTO>();
		setUsluge(new ArrayList<UslugaDTO>());
	}
	
	public SmestajDTO() {
		// TODO Auto-generated constructor stub
		ponude = new ArrayList<PonudaDTO>();
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

	public KategorijaSmestajaDTO getKategorija() {
		return kategorija;
	}

	public void setKategorija(KategorijaSmestajaDTO kategorija) {
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

	public List<PonudaDTO> getPonude() {
		return ponude;
	}

	public void setPonude(List<PonudaDTO> ponude) {
		this.ponude = ponude;
	}
	
	public List<UslugaDTO> getUsluge() {
		return usluge;
	}

	public void setUsluge(List<UslugaDTO> usluge) {
		this.usluge = usluge;
	}
	
	

}
