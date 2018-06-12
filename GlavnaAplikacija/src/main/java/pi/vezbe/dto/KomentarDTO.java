package pi.vezbe.dto;

public class KomentarDTO {

	private Long id;
	private String opis;
	private String datumKomentara;
	private String imeAutora;
	private String prezimeAutora;
	private SmestajDTO smestajDTO;
	
	public KomentarDTO(){
		
	}

	public KomentarDTO(Long id, String opis, String datumKomentara,
			String imeAutora, String prezimeAutora, SmestajDTO smestajDTO) {
		
		this.id = id;
		this.opis = opis;
		this.datumKomentara = datumKomentara;
		this.imeAutora = imeAutora;
		this.prezimeAutora = prezimeAutora;
		this.smestajDTO = smestajDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getDatumKomentara() {
		return datumKomentara;
	}

	public void setDatumKomentara(String datumKomentara) {
		this.datumKomentara = datumKomentara;
	}

	public String getImeAutora() {
		return imeAutora;
	}

	public void setImeAutora(String imeAutora) {
		this.imeAutora = imeAutora;
	}

	public String getPrezimeAutora() {
		return prezimeAutora;
	}

	public void setPrezimeAutora(String prezimeAutora) {
		this.prezimeAutora = prezimeAutora;
	}

	public SmestajDTO getSmestajDTO() {
		return smestajDTO;
	}

	public void setSmestajDTO(SmestajDTO smestajDTO) {
		this.smestajDTO = smestajDTO;
	}
	
}
