//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 12:43:00 PM CEST 
//


package com.xml.booking.backendmain.ws_classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for smestajVlasnikXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="smestajVlasnikXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idSmestaja" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idVlasnika" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smestajVlasnikXML", propOrder = {
    "id",
    "idSmestaja",
    "idVlasnika"
})
public class SmestajVlasnikXML {

    protected long id;
    protected long idSmestaja;
    protected long idVlasnika;

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
     * Gets the value of the idSmestaja property.
     * 
     */
    public long getIdSmestaja() {
        return idSmestaja;
    }

    /**
     * Sets the value of the idSmestaja property.
     * 
     */
    public void setIdSmestaja(long value) {
        this.idSmestaja = value;
    }

    /**
     * Gets the value of the idVlasnika property.
     * 
     */
    public long getIdVlasnika() {
        return idVlasnika;
    }

    /**
     * Sets the value of the idVlasnika property.
     * 
     */
    public void setIdVlasnika(long value) {
        this.idVlasnika = value;
    }

}
