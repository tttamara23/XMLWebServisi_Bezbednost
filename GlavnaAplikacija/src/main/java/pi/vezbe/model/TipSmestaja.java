package pi.vezbe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "naziv"
})
@Entity
public class TipSmestaja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    protected Long id;
	
	@XmlElement(required = true)
    protected String naziv;

	@OneToMany(mappedBy = "tipSmestaja", cascade = CascadeType.MERGE)
    protected List<Smestaj> smestajevi;
	
	public List<Smestaj> getSmestajevi() {
		return smestajevi;
	}

	public void setSmestajevi(List<Smestaj> smestajevi) {
		this.smestajevi = smestajevi;
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
	
	
}
