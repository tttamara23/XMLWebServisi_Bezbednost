//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 08:33:56 PM CEST 
//


package com.xml.booking.backendmain.ws_classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="ponuda" type="{http://booking.xml.com/backendmain/ws-classes}ponudaXML"/>
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
    "ponuda"
})
@XmlRootElement(name = "ponudaResponse")
public class PonudaResponse {

    @XmlElement(required = true)
    protected PonudaXML ponuda;

    /**
     * Gets the value of the ponuda property.
     * 
     * @return
     *     possible object is
     *     {@link PonudaXML }
     *     
     */
    public PonudaXML getPonuda() {
        return ponuda;
    }

    /**
     * Sets the value of the ponuda property.
     * 
     * @param value
     *     allowed object is
     *     {@link PonudaXML }
     *     
     */
    public void setPonuda(PonudaXML value) {
        this.ponuda = value;
    }

}
