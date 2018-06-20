package pi.vezbe.dto;


public class RezervacijaDTO {
	private PonudaDTO ponudaDTO;
	private Long id;
	private boolean realizovano;
	private String date;
	private String ime;
	private String prezime;
	

	public RezervacijaDTO(PonudaDTO ponudaDTO, Long id, boolean realizovano, String date,String ime,String prezime) {
		super();
		this.ponudaDTO = ponudaDTO;
		this.id = id;
		this.realizovano = realizovano;
		this.date = date;
		this.ime = ime;
		this.prezime=prezime;
	}
	
	public RezervacijaDTO() {
		
	}
	public PonudaDTO getPonudaDTO() {
		return ponudaDTO;
	}
	public void setPonudaDTO(PonudaDTO ponudaDTO) {
		this.ponudaDTO = ponudaDTO;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isRealizovano() {
		return realizovano;
	}
	public void setRealizovano(boolean realizovano) {
		this.realizovano = realizovano;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	
	
}
