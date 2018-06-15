package pi.vezbe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PonudaUsluga {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ponuda", nullable = false)
	private Ponuda ponuda;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usluga", nullable = false)
	private Usluga usluga;
	
	public PonudaUsluga() {
		// TODO Auto-generated constructor stub
	}

	public PonudaUsluga(Long id, Ponuda ponuda, Usluga usluga) {
		this.id = id;
		this.ponuda = ponuda;
		this.usluga = usluga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ponuda getPonuda() {
		return ponuda;
	}

	public void setPonuda(Ponuda ponuda) {
		this.ponuda = ponuda;
	}

	public Usluga getUsluga() {
		return usluga;
	}

	public void setUsluga(Usluga usluga) {
		this.usluga = usluga;
	}
	
	

}
