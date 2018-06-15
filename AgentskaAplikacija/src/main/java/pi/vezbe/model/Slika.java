package pi.vezbe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
     *       &lt;sequence>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *         &lt;element name="naziv">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" form="qualified"/>
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
        "naziv",
        "data"
    })
    @Entity
    public  class Slika {
    	@Id
    	@GeneratedValue(strategy=GenerationType.AUTO)
        protected Long id;
    	
        @XmlElement(required = true)
        protected String naziv;
        
        @XmlElement(required = true)
        protected byte[] data;
        
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_smestaj", nullable = false)
        private Smestaj smestaj;

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
         * Gets the value of the data property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getData() {
            return data;
        }

        /**
         * Sets the value of the data property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setData(byte[] value) {
            this.data = value;
        }

		public Smestaj getSmestaj() {
			return smestaj;
		}

		public void setSmestaj(Smestaj smestaj) {
			this.smestaj = smestaj;
		}

    }
