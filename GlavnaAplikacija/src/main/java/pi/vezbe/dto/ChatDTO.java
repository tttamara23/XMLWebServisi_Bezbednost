package pi.vezbe.dto;
import java.util.List;

public class ChatDTO{

	private Long id;
	private List<KorisnikDTO> korisnici;
	
	public ChatDTO(Long id, List<KorisnikDTO> korisnici) {
		this.id = id;
		this.korisnici = korisnici;
	}
	
	public ChatDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<KorisnikDTO> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(List<KorisnikDTO> korisnici) {
		this.korisnici = korisnici;
	}

}