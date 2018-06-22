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
    "kategorija"
})
@Entity
public class KategorijaSmestaja {
	
	@Id
	
    protected Long id;
	
	@XmlElement(required = true)
    protected String kategorija;
	
	@OneToMany(mappedBy = "kategorijaSmestaja", cascade = CascadeType.REMOVE)
    protected List<Smestaj> smestaji;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	
	
}
