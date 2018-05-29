package pi.vezbe.model;

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
        public class Rezervacija {

            protected long id;
            protected boolean realizovano;
            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar datumRezervacije;

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
            public XMLGregorianCalendar getDatumRezervacije() {
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
            public void setDatumRezervacije(XMLGregorianCalendar value) {
                this.datumRezervacije = value;
            }

        }