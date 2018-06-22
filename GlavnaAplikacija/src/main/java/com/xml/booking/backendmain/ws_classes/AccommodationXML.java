//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 01:40:14 AM CEST 
//


package com.xml.booking.backendmain.ws_classes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accommodationXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accommodationXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipSmestaja" type="{http://booking.xml.com/backendmain/ws-classes}tipSmestajaXML"/>
 *         &lt;element name="lokacija" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usluge" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="kategorijaSmestaja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="slike" type="{http://booking.xml.com/backendmain/ws-classes}slikaXML" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accommodationXML", propOrder = {
    "id",
    "naziv",
    "tipSmestaja",
    "lokacija",
    "opis",
    "usluge",
    "kategorijaSmestaja",
    "slike"
})
public class AccommodationXML {

    protected long id;
    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(required = true)
    protected TipSmestajaXML tipSmestaja;
    @XmlElement(required = true)
    protected String lokacija;
    @XmlElement(required = true)
    protected String opis;
    @XmlElement(type = Long.class)
    protected List<Long> usluge;
    @XmlElement(required = true)
    protected String kategorijaSmestaja;
    protected List<SlikaXML> slike;

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
     * Gets the value of the tipSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link TipSmestajaXML }
     *     
     */
    public TipSmestajaXML getTipSmestaja() {
        return tipSmestaja;
    }

    /**
     * Sets the value of the tipSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipSmestajaXML }
     *     
     */
    public void setTipSmestaja(TipSmestajaXML value) {
        this.tipSmestaja = value;
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
     * Gets the value of the usluge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usluge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsluge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getUsluge() {
        if (usluge == null) {
            usluge = new ArrayList<Long>();
        }
        return this.usluge;
    }

    /**
     * Gets the value of the kategorijaSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKategorijaSmestaja() {
        return kategorijaSmestaja;
    }

    /**
     * Sets the value of the kategorijaSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKategorijaSmestaja(String value) {
        this.kategorijaSmestaja = value;
    }

    /**
     * Gets the value of the slike property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slike property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlike().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SlikaXML }
     * 
     * 
     */
    public List<SlikaXML> getSlike() {
        if (slike == null) {
            slike = new ArrayList<SlikaXML>();
        }
        return this.slike;
    }

}
