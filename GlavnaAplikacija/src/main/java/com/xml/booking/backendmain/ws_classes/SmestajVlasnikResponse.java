//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 


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
 *         &lt;element name="svResponse" type="{http://booking.xml.com/backendmain/ws-classes}smestajVlasnikXML"/>
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
    "svResponse"
})
@XmlRootElement(name = "smestajVlasnikResponse")
public class SmestajVlasnikResponse {

    @XmlElement(required = true)
    protected SmestajVlasnikXML svResponse;

    /**
     * Gets the value of the svResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SmestajVlasnikXML }
     *     
     */
    public SmestajVlasnikXML getSvResponse() {
        return svResponse;
    }

    /**
     * Sets the value of the svResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmestajVlasnikXML }
     *     
     */
    public void setSvResponse(SmestajVlasnikXML value) {
        this.svResponse = value;
    }

}