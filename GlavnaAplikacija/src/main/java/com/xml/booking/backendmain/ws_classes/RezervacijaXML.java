//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 02:25:47 PM CEST 
//


package com.xml.booking.backendmain.ws_classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rezervacijaXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rezervacijaXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="realizovana" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="datumRezervacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idPonude" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idKorisnika" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rezervacijaXML", propOrder = {
    "id",
    "realizovana",
    "datumRezervacije",
    "idPonude",
    "idKorisnika"
})
public class RezervacijaXML {

    protected long id;
    protected boolean realizovana;
    @XmlElement(required = true)
    protected String datumRezervacije;
    protected long idPonude;
    protected long idKorisnika;

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
     * Gets the value of the realizovana property.
     * 
     */
    public boolean isRealizovana() {
        return realizovana;
    }

    /**
     * Sets the value of the realizovana property.
     * 
     */
    public void setRealizovana(boolean value) {
        this.realizovana = value;
    }

    /**
     * Gets the value of the datumRezervacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumRezervacije() {
        return datumRezervacije;
    }

    /**
     * Sets the value of the datumRezervacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumRezervacije(String value) {
        this.datumRezervacije = value;
    }

    /**
     * Gets the value of the idPonude property.
     * 
     */
    public long getIdPonude() {
        return idPonude;
    }

    /**
     * Sets the value of the idPonude property.
     * 
     */
    public void setIdPonude(long value) {
        this.idPonude = value;
    }

    /**
     * Gets the value of the idKorisnika property.
     * 
     */
    public long getIdKorisnika() {
        return idKorisnika;
    }

    /**
     * Sets the value of the idKorisnika property.
     * 
     */
    public void setIdKorisnika(long value) {
        this.idKorisnika = value;
    }

}
