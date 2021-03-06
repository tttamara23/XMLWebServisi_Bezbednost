//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.23 at 11:36:44 AM CEST 
//


package pi.vezbe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="naziv">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tip">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="kategorija">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lokacija">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="opis">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="300"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Ponuda">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="datumOd" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="datumDo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="cena">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;totalDigits value="10"/>
 *                         &lt;fractionDigits value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="brojLezaja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="brojSlobodnihPonuda" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Rezervacija">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="realizovano" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="datumRezervacije" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element ref="{}Usluga" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Slika">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="naziv">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" form="qualified"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Smestaj")
@Entity
public class Smestaj {

    @XmlElement(required = true)
    protected String naziv;
    @Id
    protected Long id;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    @JoinColumn(name = "id_tip_smestaja")
	private TipSmestaja tipSmestaja;
    
    @XmlElement(required = true)
    protected String lokacija;
   
    @XmlElement(required = true)
    @Column(length=100000)
    protected String opis;
    
    @XmlElement(name = "Ponuda", required = true)
    @OneToMany(mappedBy = "smestaj", cascade = CascadeType.REMOVE)
    protected List<Ponuda> ponuda;
    
    @XmlElement(name = "Usluga", required = true)
    protected ArrayList<Usluga> usluga;
    
    @XmlElement(name = "Slika", required = true)
    @OneToMany(mappedBy = "smestaj", cascade = CascadeType.REMOVE)
    protected List<Slika> slika;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kategorija_smestaja")
	private KategorijaSmestaja kategorijaSmestaja;
    
    @OneToMany(mappedBy = "smestaj",cascade = CascadeType.REMOVE)
	private List<SmestajVlasnik> smestajVlasnik;
   
    @OneToMany(mappedBy = "smestaj",cascade = CascadeType.REMOVE)
	private List<Ocena> ocene;
   
    @OneToMany(mappedBy = "smestaj", cascade = CascadeType.REMOVE)
	protected List<Komentar> komentari;


	public ArrayList<Usluga> getUsluga() {
		return usluga;
	}

	public void setUsluga(ArrayList<Usluga> usluga) {
		this.usluga = usluga;
	}

	public List<SmestajVlasnik> getSmestajVlasnik() {
		return smestajVlasnik;
	}

	public void setSmestajVlasnik(List<SmestajVlasnik> smestajVlasnik) {
		this.smestajVlasnik = smestajVlasnik;
	}

	public List<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}

	public List<Komentar> getKomentari() {
		return komentari;
	}

	public void setKomentari(List<Komentar> komentari) {
		this.komentari = komentari;
	}

	/**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(Long value) {
        this.id = value;
    }



    public TipSmestaja getTipSmestaja() {
		return tipSmestaja;
	}

	public void setTipSmestaja(TipSmestaja tipSmestaja) {
		this.tipSmestaja = tipSmestaja;
	}

	public KategorijaSmestaja getKategorijaSmestaja() {
		return kategorijaSmestaja;
	}

	public void setKategorijaSmestaja(KategorijaSmestaja kategorijaSmestaja) {
		this.kategorijaSmestaja = kategorijaSmestaja;
	}

	/**
     * Gets the value of the lokacija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLokacija() {
        return lokacija;
    }

    /**
     * Sets the value of the lokacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLokacija(String value) {
        this.lokacija = value;
    }

    /**
     * Gets the value of the opis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpis(String value) {
        this.opis = value;
    }

    /**
     * Gets the value of the ponuda property.
     * 
     * @return
     *     possible object is
     *     {@link Smestaj.Ponuda }
     *     
     */
    public List<Ponuda> getPonuda() {
        return ponuda;
    }

    /**
     * Sets the value of the ponuda property.
     * 
     * @param value
     *     allowed object is
     *     {@link Smestaj.Ponuda }
     *     
     */
    public void setPonuda(List<Ponuda> value) {
        this.ponuda = value;
    }

    /**
     * Gets the value of the slika property.
     * 
     * @return
     *     possible object is
     *     {@link Smestaj.Slika }
     *     
     */
    public List<Slika> getSlika() {
        return slika;
    }

    /**
     * Sets the value of the slika property.
     * 
     * @param value
     *     allowed object is
     *     {@link Smestaj.Slika }
     *     
     */
    public void setSlika(List<Slika> value) {
        this.slika = value;
    }


    


    
}
