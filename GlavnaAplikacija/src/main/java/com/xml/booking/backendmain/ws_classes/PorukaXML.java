//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 05:31:07 PM CEST 
//


package com.xml.booking.backendmain.ws_classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for porukaXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="porukaXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datumSlanja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idChata" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idPosiljaoca" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="seen" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "porukaXML", propOrder = {
    "id",
    "sadrzaj",
    "datumSlanja",
    "idChata",
    "idPosiljaoca",
    "seen"
})
public class PorukaXML {

    protected long id;
    @XmlElement(required = true)
    protected String sadrzaj;
    @XmlElement(required = true)
    protected String datumSlanja;
    protected long idChata;
    protected long idPosiljaoca;
    protected boolean seen;

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
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSadrzaj(String value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the datumSlanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumSlanja() {
        return datumSlanja;
    }

    /**
     * Sets the value of the datumSlanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumSlanja(String value) {
        this.datumSlanja = value;
    }

    /**
     * Gets the value of the idChata property.
     * 
     */
    public long getIdChata() {
        return idChata;
    }

    /**
     * Sets the value of the idChata property.
     * 
     */
    public void setIdChata(long value) {
        this.idChata = value;
    }

    /**
     * Gets the value of the idPosiljaoca property.
     * 
     */
    public long getIdPosiljaoca() {
        return idPosiljaoca;
    }

    /**
     * Sets the value of the idPosiljaoca property.
     * 
     */
    public void setIdPosiljaoca(long value) {
        this.idPosiljaoca = value;
    }

    /**
     * Gets the value of the seen property.
     * 
     */
    public boolean isSeen() {
        return seen;
    }

    /**
     * Sets the value of the seen property.
     * 
     */
    public void setSeen(boolean value) {
        this.seen = value;
    }

}
