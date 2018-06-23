package pi.vezbe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SmestajUsluga {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_smestaj", nullable = false)
	private Smestaj smestaj;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usluga", nullable = false)
	private Usluga usluga;
	
	public SmestajUsluga(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Smestaj getIdSmestaja() {
		return smestaj;
	}

	public void setIdSmestaja(Smestaj idSmestaja) {
		this.smestaj = idSmestaja;
	}

	public Usluga getIdUsluge() {
		return usluga;
	}

	public void setIdUsluge(Usluga idUsluge) {
		this.usluga = idUsluge;
	}

	public SmestajUsluga(Long id, Smestaj idSmestaja, Usluga idUsluge) {
		
		this.id = id;
		this.smestaj = idSmestaja;
		this.usluga = idUsluge;
	}
	
}
