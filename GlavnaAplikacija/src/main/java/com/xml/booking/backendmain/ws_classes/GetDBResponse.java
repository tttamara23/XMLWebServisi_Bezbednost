//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 02:25:47 PM CEST 
//


package com.xml.booking.backendmain.ws_classes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="tipoviSmestaja" type="{http://booking.xml.com/backendmain/ws-classes}tipSmestajaXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="kategorijaSmestaja" type="{http://booking.xml.com/backendmain/ws-classes}kategorijaSmestajaXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="korisnici" type="{http://booking.xml.com/backendmain/ws-classes}korisnikXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="smestajevi" type="{http://booking.xml.com/backendmain/ws-classes}accommodationXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ponude" type="{http://booking.xml.com/backendmain/ws-classes}ponudaXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usluge" type="{http://booking.xml.com/backendmain/ws-classes}uslugaXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ponudeusluge" type="{http://booking.xml.com/backendmain/ws-classes}ponudauslugaXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="poruke" type="{http://booking.xml.com/backendmain/ws-classes}porukaXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="chatovi" type="{http://booking.xml.com/backendmain/ws-classes}chatXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="chatKorisnikList" type="{http://booking.xml.com/backendmain/ws-classes}chatKorisnikXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rezervacije" type="{http://booking.xml.com/backendmain/ws-classes}rezervacijaXML" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="smestajVlasnikList" type="{http://booking.xml.com/backendmain/ws-classes}smestajVlasnikXML" maxOccurs="unbounded" minOccurs="0"/>
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
    "tipoviSmestaja",
    "kategorijaSmestaja",
    "korisnici",
    "smestajevi",
    "ponude",
    "usluge",
    "ponudeusluge",
    "poruke",
    "chatovi",
    "chatKorisnikList",
    "rezervacije",
    "smestajVlasnikList"
})
@XmlRootElement(name = "getDBResponse")
public class GetDBResponse {

    protected List<TipSmestajaXML> tipoviSmestaja;
    protected List<KategorijaSmestajaXML> kategorijaSmestaja;
    protected List<KorisnikXML> korisnici;
    protected List<AccommodationXML> smestajevi;
    protected List<PonudaXML> ponude;
    protected List<UslugaXML> usluge;
    protected List<PonudauslugaXML> ponudeusluge;
    protected List<PorukaXML> poruke;
    protected List<ChatXML> chatovi;
    protected List<ChatKorisnikXML> chatKorisnikList;
    protected List<RezervacijaXML> rezervacije;
    protected List<SmestajVlasnikXML> smestajVlasnikList;

    /**
     * Gets the value of the tipoviSmestaja property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoviSmestaja property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoviSmestaja().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipSmestajaXML }
     * 
     * 
     */
    public List<TipSmestajaXML> getTipoviSmestaja() {
        if (tipoviSmestaja == null) {
            tipoviSmestaja = new ArrayList<TipSmestajaXML>();
        }
        return this.tipoviSmestaja;
    }

    /**
     * Gets the value of the kategorijaSmestaja property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kategorijaSmestaja property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKategorijaSmestaja().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KategorijaSmestajaXML }
     * 
     * 
     */
    public List<KategorijaSmestajaXML> getKategorijaSmestaja() {
        if (kategorijaSmestaja == null) {
            kategorijaSmestaja = new ArrayList<KategorijaSmestajaXML>();
        }
        return this.kategorijaSmestaja;
    }

    /**
     * Gets the value of the korisnici property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the korisnici property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKorisnici().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KorisnikXML }
     * 
     * 
     */
    public List<KorisnikXML> getKorisnici() {
        if (korisnici == null) {
            korisnici = new ArrayList<KorisnikXML>();
        }
        return this.korisnici;
    }

    /**
     * Gets the value of the smestajevi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smestajevi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSmestajevi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccommodationXML }
     * 
     * 
     */
    public List<AccommodationXML> getSmestajevi() {
        if (smestajevi == null) {
            smestajevi = new ArrayList<AccommodationXML>();
        }
        return this.smestajevi;
    }

    /**
     * Gets the value of the ponude property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ponude property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPonude().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PonudaXML }
     * 
     * 
     */
    public List<PonudaXML> getPonude() {
        if (ponude == null) {
            ponude = new ArrayList<PonudaXML>();
        }
        return this.ponude;
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
     * {@link UslugaXML }
     * 
     * 
     */
    public List<UslugaXML> getUsluge() {
        if (usluge == null) {
            usluge = new ArrayList<UslugaXML>();
        }
        return this.usluge;
    }

    /**
     * Gets the value of the ponudeusluge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ponudeusluge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPonudeusluge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PonudauslugaXML }
     * 
     * 
     */
    public List<PonudauslugaXML> getPonudeusluge() {
        if (ponudeusluge == null) {
            ponudeusluge = new ArrayList<PonudauslugaXML>();
        }
        return this.ponudeusluge;
    }

    /**
     * Gets the value of the poruke property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poruke property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoruke().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PorukaXML }
     * 
     * 
     */
    public List<PorukaXML> getPoruke() {
        if (poruke == null) {
            poruke = new ArrayList<PorukaXML>();
        }
        return this.poruke;
    }

    /**
     * Gets the value of the chatovi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chatovi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChatovi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChatXML }
     * 
     * 
     */
    public List<ChatXML> getChatovi() {
        if (chatovi == null) {
            chatovi = new ArrayList<ChatXML>();
        }
        return this.chatovi;
    }

    /**
     * Gets the value of the chatKorisnikList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chatKorisnikList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChatKorisnikList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChatKorisnikXML }
     * 
     * 
     */
    public List<ChatKorisnikXML> getChatKorisnikList() {
        if (chatKorisnikList == null) {
            chatKorisnikList = new ArrayList<ChatKorisnikXML>();
        }
        return this.chatKorisnikList;
    }

    /**
     * Gets the value of the rezervacije property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rezervacije property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRezervacije().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RezervacijaXML }
     * 
     * 
     */
    public List<RezervacijaXML> getRezervacije() {
        if (rezervacije == null) {
            rezervacije = new ArrayList<RezervacijaXML>();
        }
        return this.rezervacije;
    }

    /**
     * Gets the value of the smestajVlasnikList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smestajVlasnikList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSmestajVlasnikList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SmestajVlasnikXML }
     * 
     * 
     */
    public List<SmestajVlasnikXML> getSmestajVlasnikList() {
        if (smestajVlasnikList == null) {
            smestajVlasnikList = new ArrayList<SmestajVlasnikXML>();
        }
        return this.smestajVlasnikList;
    }

}
