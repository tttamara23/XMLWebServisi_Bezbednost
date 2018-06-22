package pi.vezbe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_chat", "id_ucesnik"})
})
public class ChatKorisnik {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Long id;
 

 	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_chat", nullable = false)
	private Chat chat;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ucesnik", nullable = false)
	private Korisnik ucesnik;
	
	public ChatKorisnik(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Korisnik getUcesnik() {
		return ucesnik;
	}

	public void setUcesnik(Korisnik ucesnik) {
		this.ucesnik = ucesnik;
	}

	public ChatKorisnik(Long id, Chat chat, Korisnik ucesnik) {
		
		this.id = id;
		this.chat = chat;
		this.ucesnik = ucesnik;
	}
	
}
