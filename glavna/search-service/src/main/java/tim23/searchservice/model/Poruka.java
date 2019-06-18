//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:16:54 PM CEST 
//


package tim23.searchservice.model;

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
 *         &lt;element name="Id_poruka" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_posiljaoca" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_primaoca" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Tip_posiljaoca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tip_primaoca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "idPoruka",
    "idPosiljaoca",
    "idPrimaoca",
    "tipPosiljaoca",
    "tipPrimaoca",
    "sadrzaj"
})
@XmlRootElement(name = "Poruka")
@Entity
@Table (name = "poruka")
public class Poruka {

    @XmlElement(name = "Id_poruka")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idporuka")
    private Integer idPoruka;
    
    @XmlElement(name = "Klijent_posiljalac")
    @ManyToOne
    @JoinColumn(name="klijentposiljac")
    private KrajnjiKorisnik klijentPosiljalac;
    
    @XmlElement(name = "Klijent_primalac")
    @ManyToOne
    @JoinColumn(name="klijentprimalac")
    private KrajnjiKorisnik klijentPrimalac;
    
    @XmlElement(name = "Agent_posiljalac")
    @ManyToOne
    @JoinColumn(name="agentposiljac")
    private Agent agentPosiljac;
    
    @XmlElement(name = "Agent_primalac")
    @ManyToOne
    @JoinColumn(name="agentprimalac")
    private Agent agentPrimalac;
    
//    @XmlElement(name = "Id_primaoca")
//    private Integer idPrimaoca;
//    @XmlElement(name = "Tip_posiljaoca", required = true)
//    private String tipPosiljaoca;
//    @XmlElement(name = "Tip_primaoca", required = true)
//    private String tipPrimaoca;
    
    @XmlElement(name = "Sadrzaj", required = true)
    @Column (name = "sadrzaj")
    private String sadrzaj;

    /**
     * Gets the value of the idPoruka property.
     * 
     */
    public Integer getIdPoruka() {
        return idPoruka;
    }

    /**
     * Sets the value of the idPoruka property.
     * 
     */
    public void setIdPoruka(Integer value) {
        this.idPoruka = value;
    }
    
    
    public KrajnjiKorisnik getKlijentPosiljalac() {
		return klijentPosiljalac;
	}

	public void setKlijentPosiljalac(KrajnjiKorisnik klijentPosiljalac) {
		this.klijentPosiljalac = klijentPosiljalac;
	}

	public KrajnjiKorisnik getKlijentPrimalac() {
		return klijentPrimalac;
	}

	public void setKlijentPrimalac(KrajnjiKorisnik klijentPrimalac) {
		this.klijentPrimalac = klijentPrimalac;
	}

	public Agent getAgentPosiljac() {
		return agentPosiljac;
	}

	public void setAgentPosiljac(Agent agentPosiljac) {
		this.agentPosiljac = agentPosiljac;
	}

	public Agent getAgentPrimalac() {
		return agentPrimalac;
	}

	public void setAgentPrimalac(Agent agentPrimalac) {
		this.agentPrimalac = agentPrimalac;
	}

//	public Integer getIdPrimaoca() {
//		return idPrimaoca;
//	}

//	public void setIdPrimaoca(Integer idPrimaoca) {
//		this.idPrimaoca = idPrimaoca;
//	}
//
//	public void setIdPoruka(Integer idPoruka) {
//		this.idPoruka = idPoruka;
//	}

	/**
     * Gets the value of the tipPosiljaoca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
//    public String getTipPosiljaoca() {
//        return tipPosiljaoca;
//    }

    /**
     * Sets the value of the tipPosiljaoca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
//    public void setTipPosiljaoca(String value) {
//        this.tipPosiljaoca = value;
//    }

    /**
     * Gets the value of the tipPrimaoca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
//    public String getTipPrimaoca() {
//        return tipPrimaoca;
//    }

    /**
     * Sets the value of the tipPrimaoca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
//    public void setTipPrimaoca(String value) {
//        this.tipPrimaoca = value;
//    }

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

}
