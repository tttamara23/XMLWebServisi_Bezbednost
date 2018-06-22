package pi.vezbe.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="datumOd" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="datumDo" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="cena">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;totalDigits value="10"/>
     *               &lt;fractionDigits value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="brojLezaja" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="brojSlobodnihPonuda" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="Rezervacija">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="realizovano" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="datumRezervacije" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element ref="{}Usluga" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "datumOd",
        "datumDo",
        "cena",
        "brojLezaja",
        "brojSlobodnihPonuda",
        "rezervacija",
        "usluga"
    })
    @Entity
    public class Ponuda {
    	
    	@Id
    	
        protected Long id;
    	
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected Date datumOd;
        
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected Date datumDo;
        
        @XmlElement(required = true)
        protected BigDecimal cena;
        
        protected int brojLezaja;
        
        protected int brojSlobodnihPonuda;
        
        @XmlElement(name = "Rezervacija", required = true)
        @OneToMany(mappedBy = "ponuda", cascade = CascadeType.REMOVE)
        protected List<Rezervacija> rezervacija;
        
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_smestaj", nullable = false)
        private Smestaj smestaj;
        
        @OneToMany(mappedBy = "ponuda", cascade = CascadeType.REMOVE)
        protected List<PonudaUsluga> ponudaUsluga;

        /**
         * Gets the value of the id property.
         * 
         */
        public long getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setId(long value) {
            this.id = value;
        }

        /**
         * Gets the value of the datumOd property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public Date getDatumOd() {
            return datumOd;
        }

        /**
         * Sets the value of the datumOd property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumOd(Date value) {
            this.datumOd = value;
        }

        /**
         * Gets the value of the datumDo property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public Date getDatumDo() {
            return datumDo;
        }

        /**
         * Sets the value of the datumDo property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumDo(Date value) {
            this.datumDo = value;
        }

        /**
         * Gets the value of the cena property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getCena() {
            return cena;
        }

        /**
         * Sets the value of the cena property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setCena(BigDecimal value) {
            this.cena = value;
        }

        /**
         * Gets the value of the brojLezaja property.
         * 
         */
        public int getBrojLezaja() {
            return brojLezaja;
        }

        /**
         * Sets the value of the brojLezaja property.
         * 
         */
        public void setBrojLezaja(int value) {
            this.brojLezaja = value;
        }

        /**
         * Gets the value of the brojSlobodnihPonuda property.
         * 
         */
        public int getBrojSlobodnihPonuda() {
            return brojSlobodnihPonuda;
        }

        /**
         * Sets the value of the brojSlobodnihPonuda property.
         * 
         */
        public void setBrojSlobodnihPonuda(int value) {
            this.brojSlobodnihPonuda = value;
        }

        /**
         * Gets the value of the rezervacija property.
         * 
         * @return
         *     possible object is
         *     {@link Smestaj.Ponuda.Rezervacija }
         *     
         */
        public List<Rezervacija> getRezervacija() {
            return rezervacija;
        }

        /**
         * Sets the value of the rezervacija property.
         * 
         * @param value
         *     allowed object is
         *     {@link Smestaj.Ponuda.Rezervacija }
         *     
         */
        public void setRezervacija(List<Rezervacija> value) {
            this.rezervacija = value;
        }

		public Smestaj getSmestaj() {
			return smestaj;
		}

		public void setSmestaj(Smestaj smestaj) {
			this.smestaj = smestaj;
		}

		public List<PonudaUsluga> getPonudaUsluga() {
			return ponudaUsluga;
		}

		public void setPonudaUsluga(List<PonudaUsluga> ponudaUsluga) {
			this.ponudaUsluga = ponudaUsluga;
		}

		public void setId(Long id) {
			this.id = id;
		}

    }