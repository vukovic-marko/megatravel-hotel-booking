//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:16:54 PM CEST 
//

package tim23.agent.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="Id_rezervacije" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Datum_dolaska" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Datum_odlaska" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Broj_osoba" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Id_sobe" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Krajnji_korisnik" minOccurs="0"/>
 *         &lt;element name="Realizovana" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Ocena" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Komentar" minOccurs="0"/>
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
    "idRezervacije",
    "datumDolaska",
    "datumOdlaska",
    "brojOsoba",
    "soba",
    "krajnjiKorisnik",
    "realizovana",
    "ocena"
})
@XmlRootElement(name = "Rezervacija")
@Entity
@Table (name = "rezervacija")
public class Rezervacija {

    @XmlElement(name = "Id_rezervacije")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idrezervacije")
    private Integer idRezervacije;
    
    @XmlElement(name = "Datum_dolaska", required = true)
    @XmlSchemaType(name = "date")
    @Column (name = "datumdolaska")
    private Date datumDolaska;
    
    @XmlElement(name = "Datum_odlaska", required = true)
    @XmlSchemaType(name = "date")
    @Column (name = "datumodlaska")
    private Date datumOdlaska;
    
    @XmlElement(name = "Broj_osoba", required = true)
    @Column (name = "brojosoba")
    private Integer brojOsoba;
    
    @XmlElement(name = "Id_sobe", required = true)
    @ManyToOne
    @JoinColumn(name= "idsoba")
    private Soba soba;
    
    @XmlElement(name = "Krajnji_korisnik", required = true)
    @ManyToOne
    @JoinColumn(name="idklijenta")
    private KrajnjiKorisnik krajnjiKorisnik;
    
    @XmlElement(name = "Realizovana", required = true)
    @Column (name = "realizovana")
    private Boolean realizovana;
    
    @XmlElement(name = "Ocena")
    @Column (name = "ocena")
    private Double ocena;


	/**
     * Gets the value of the idRezervacije property.
     * 
     */
    public Integer getIdRezervacije() {
        return idRezervacije;
    }

    /**
     * Sets the value of the idRezervacije property.
     * 
     */
    public void setIdRezervacije(Integer value) {
        this.idRezervacije = value;
    }

    /**
     * Gets the value of the datumDolaska property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDatumDolaska() {
        return datumDolaska;
    }

    /**
     * Sets the value of the datumDolaska property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDolaska(Date value) {
        this.datumDolaska = value;
    }

    /**
     * Gets the value of the datumOdlaska property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDatumOdlaska() {
        return datumOdlaska;
    }

    /**
     * Sets the value of the datumOdlaska property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOdlaska(Date value) {
        this.datumOdlaska = value;
    }

    /**
     * Gets the value of the brojOsoba property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBrojOsoba() {
        return brojOsoba;
    }

    /**
     * Sets the value of the brojOsoba property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBrojOsoba(Integer value) {
        this.brojOsoba = value;
    }

    /**
     * Gets the value of the idSobe property.
     * 
     */
    public Soba getIdSobe() {
        return soba;
    }

    /**
     * Sets the value of the idSobe property.
     * 
     */
    public void setIdSobe(Soba value) {
        this.soba = value;
    }

    /**
     * Gets the value of the krajnjiKorisnik property.
     * 
     * @return
     *     possible object is
     *     {@link KrajnjiKorisnik }
     *     
     */
    public KrajnjiKorisnik getKrajnjiKorisnik() {
        return krajnjiKorisnik;
    }

    /**
     * Sets the value of the krajnjiKorisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link KrajnjiKorisnik }
     *     
     */
    public void setKrajnjiKorisnik(KrajnjiKorisnik value) {
        this.krajnjiKorisnik = value;
    }

    /**
     * Gets the value of the realizovana property.
     * 
     */
    public Boolean isRealizovana() {
        return realizovana;
    }

    /**
     * Sets the value of the realizovana property.
     * 
     */
    public void setRealizovana(Boolean value) {
        this.realizovana = value;
    }

    /**
     * Gets the value of the ocena property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOcena() {
        return ocena;
    }

    /**
     * Sets the value of the ocena property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOcena(Double value) {
        this.ocena = value;
    }

}
