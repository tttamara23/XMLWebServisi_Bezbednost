//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 


package com.xml.booking.backendmain.ws_classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ponudauslugaXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ponudauslugaXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ponudaid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="uslugaid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ponudauslugaXML", propOrder = {
    "id",
    "ponudaid",
    "uslugaid"
})
public class PonudauslugaXML {

    protected long id;
    protected long ponudaid;
    protected long uslugaid;

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
     * Gets the value of the ponudaid property.
     * 
     */
    public long getPonudaid() {
        return ponudaid;
    }

    /**
     * Sets the value of the ponudaid property.
     * 
     */
    public void setPonudaid(long value) {
        this.ponudaid = value;
    }

    /**
     * Gets the value of the uslugaid property.
     * 
     */
    public long getUslugaid() {
        return uslugaid;
    }

    /**
     * Sets the value of the uslugaid property.
     * 
     */
    public void setUslugaid(long value) {
        this.uslugaid = value;
    }

}
