package pi.vezbe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Chat_Korisnik", 
        joinColumns = { @JoinColumn(name = "chat_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "korisnik_id") }
    )
	protected List<Korisnik> korisnici;

	
    @OneToMany(mappedBy = "chat", cascade = CascadeType.REMOVE)
	private List<Poruka> poruke;
    
    public Chat() {
		korisnici = new ArrayList<Korisnik>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public List<Poruka> getPoruke() {
		return poruke;
	}

	public void setPoruke(List<Poruka> poruke) {
		this.poruke = poruke;
	}
	
	public boolean findKorisnik(Korisnik korisnik){
		for(Korisnik kor : korisnici){
			if(kor.getId().equals(korisnik.getId())){
				return true;
			}
		}
		return false;
	}
	
}
