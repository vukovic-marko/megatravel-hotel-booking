//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.13 at 08:11:45 PM CEST 
//


package tim23.hotelservice.model.poruke;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import tim23.hotelservice.model.Adresa;
import tim23.hotelservice.model.Agent;
import tim23.hotelservice.model.TipSmestaja;



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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/entiteti}Agent"/>
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
    "tipoviSmestaja"
})
@XmlRootElement(name = "getTipSmestajaListResponse", namespace = "http://www.ftn.uns.ac.rs/poruke")
public class GetTipSmestajaListResponse {

    @XmlElement(name = "Tipovi_smestaja", required = true)
    protected List<TipSmestaja> tipoviSmestaja;

    /**
     * Gets the value of the agent property.
     * 
     * @return
     *     possible object is
     *     {@link Agent }
     *     
     */
    public List<TipSmestaja> getTipoviSmestaja() {
		return tipoviSmestaja;
	}

    /**
     * Sets the value of the agent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agent }
     *     
     */
    public void setTipoviSmestaja(List<TipSmestaja> tipoviSmestaja) {
		this.tipoviSmestaja = tipoviSmestaja;
	}

}