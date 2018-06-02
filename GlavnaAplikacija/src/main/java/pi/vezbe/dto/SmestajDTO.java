package pi.vezbe.dto;

import java.util.ArrayList;
import java.util.List;

public class SmestajDTO {
	
	private Long id;
	private String naziv;
	private TipSmestajaDTO tip;
	private KategorijaSmestajaDTO kategorija;
	private String lokacija;
	private String opis;
	private List<PonudaDTO> ponude;
	
	public SmestajDTO(Long id, String naziv, TipSmestajaDTO tip, KategorijaSmestajaDTO kategorija, String lokacija, String opis) {
		this.id = id;
		this.naziv = naziv;
		this.tip = tip;
		this.kategorija = kategorija;
		this.lokacija = lokacija;
		this.opis = opis;
		ponude = new ArrayList<PonudaDTO>();
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

	public TipSmestajaDTO getTip() {
		return tip;
	}

	public void setTip(TipSmestajaDTO tip) {
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
	
	

}
