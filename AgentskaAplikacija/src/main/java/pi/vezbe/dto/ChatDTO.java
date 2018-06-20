package pi.vezbe.dto;
import java.util.ArrayList;
import java.util.List;

public class ChatDTO{

	private Long id;
	private List<KorisnikDTO> korisnici;
	private List<PorukaDTO> poruke;
	private int unseen;
	
	public ChatDTO(Long id, List<KorisnikDTO> korisnici, int unseen) {
		this.id = id;
		this.korisnici = korisnici;
		this.unseen = unseen;
	}
	
	public ChatDTO() {
		// TODO Auto-generated constructor stub
		this.korisnici = new ArrayList<KorisnikDTO>();
	}
	

	public int getUnseen() {
		return unseen;
	}

	public void setUnseen(int unseen) {
		this.unseen = unseen;
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

	public List<PorukaDTO> getPoruke() {
		return poruke;
	}

	public void setPoruke(List<PorukaDTO> poruke) {
		this.poruke = poruke;
	}
	

}