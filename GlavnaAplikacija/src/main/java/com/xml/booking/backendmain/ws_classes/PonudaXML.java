//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 01:40:14 AM CEST 
//


package com.xml.booking.backendmain.ws_classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ponudaXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ponudaXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="brojLezaja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="brojSlobodnihPonuda" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="datumOd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datumDo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="smestajId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ponudaXML", propOrder = {
    "id",
    "brojLezaja",
    "brojSlobodnihPonuda",
    "datumOd",
    "datumDo",
    "cena",
    "smestajId"
})
public class PonudaXML {

    protected long id;
    protected int brojLezaja;
    protected int brojSlobodnihPonuda;
    @XmlElement(required = true)
    protected String datumOd;
    @XmlElement(required = true)
    protected String datumDo;
    protected double cena;
    protected long smestajId;

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
     * Gets the value of the datumOd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumOd() {
        return datumOd;
    }

    /**
     * Sets the value of the datumOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumOd(String value) {
        this.datumOd = value;
    }

    /**
     * Gets the value of the datumDo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumDo() {
        return datumDo;
    }

    /**
     * Sets the value of the datumDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumDo(String value) {
        this.datumDo = value;
    }

    /**
     * Gets the value of the cena property.
     * 
     */
    public double getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     * 
     */
    public void setCena(double value) {
        this.cena = value;
    }

    /**
     * Gets the value of the smestajId property.
     * 
     */
    public long getSmestajId() {
        return smestajId;
    }

    /**
     * Sets the value of the smestajId property.
     * 
     */
    public void setSmestajId(long value) {
        this.smestajId = value;
    }

}
