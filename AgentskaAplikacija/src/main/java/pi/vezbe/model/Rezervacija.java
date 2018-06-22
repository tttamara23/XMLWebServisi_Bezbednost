package pi.vezbe.model;

import java.util.Date;

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
         *       &lt;all>
         *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="realizovano" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="datumRezervacije" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
        @Entity
        public class Rezervacija {
        	@Id
            protected Long id;
        	
            protected boolean realizovano;
            
            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected Date datumRezervacije;
            
            @ManyToOne(fetch = FetchType.EAGER)
            @JoinColumn(name = "id_ponuda", nullable = false)
        	private Ponuda ponuda;
            
            @ManyToOne(fetch = FetchType.EAGER)
            @JoinColumn(name = "id_korisnika", nullable = false)
        	private KrajnjiKorisnik korisnik;

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
             * Gets the value of the realizovano property.
             * 
             */
            public boolean isRealizovano() {
                return realizovano;
            }

            /**
             * Sets the value of the realizovano property.
             * 
             */
            public void setRealizovano(boolean value) {
                this.realizovano = value;
            }

            /**
             * Gets the value of the datumRezervacije property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public Date getDatumRezervacije() {
                return datumRezervacije;
            }

            /**
             * Sets the value of the datumRezervacije property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDatumRezervacije(Date value) {
                this.datumRezervacije = value;
            }

			public Ponuda getPonuda() {
				return ponuda;
			}

			public void setPonuda(Ponuda ponuda) {
				this.ponuda = ponuda;
			}

			public KrajnjiKorisnik getKorisnik() {
				return korisnik;
			}

			public void setKorisnik(KrajnjiKorisnik krajnjiKorisnik) {
				this.korisnik = krajnjiKorisnik;
			}

			
            

        }