package pi.vezbe.dto;

public class KrajnjiKorisnikDTO {
		
	
	private KorisnikDTO korisnikDTO;
	private boolean blokiran;
	
	public KrajnjiKorisnikDTO(){
		korisnikDTO = new KorisnikDTO();
	}
	
	public KrajnjiKorisnikDTO(KorisnikDTO korisnikDTO, boolean blokiran) {
		super();
		this.korisnikDTO = korisnikDTO;
		this.blokiran = blokiran;
	}
	public KorisnikDTO getKorisnikDTO() {
		return korisnikDTO;
	}
	public void setKorisnikDTO(KorisnikDTO korisnikDTO) {
		this.korisnikDTO = korisnikDTO;
	}
	public boolean isBlokiran() {
		return blokiran;
	}
	public void setBlokiran(boolean blokiran) {
		this.blokiran = blokiran;
	}
	
	
		
		
}
