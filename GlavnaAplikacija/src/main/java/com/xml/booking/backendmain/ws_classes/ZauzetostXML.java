//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 

package com.xml.booking.backendmain.ws_classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for zauzetostXML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zauzetostXML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPonude" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="brojSoba" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zauzetostXML", propOrder = {
    "idPonude",
    "brojSoba"
})
public class ZauzetostXML {

    protected long idPonude;
    protected int brojSoba;

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
     * Gets the value of the brojSoba property.
     * 
     */
    public int getBrojSoba() {
        return brojSoba;
    }

    /**
     * Sets the value of the brojSoba property.
     * 
     */
    public void setBrojSoba(int value) {
        this.brojSoba = value;
    }

}
