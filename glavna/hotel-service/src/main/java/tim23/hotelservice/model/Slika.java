package tim23.hotelservice.model;
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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idSlike",
    "urlSlike",
    "idSobe"
})
@XmlRootElement(name = "Slika")
@Entity
@Table (name = "slika")
public class Slika {

    @XmlElement(name = "Id_poruke")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name = "idslike")
	private Integer idSlike;
	
    @XmlElement(name = "Url_slike")
	@Column (name = "urlslike")
	private String urlSlike;
	
    @XmlElement(name = "Id_sobe")
	@ManyToOne
	@JoinColumn(name="idsobe")
	private Soba idSobe;
	
	public Slika() {
		
	}

	public Slika(Integer idSlike, String urlSlike, Soba idSobe) {
		super();
		this.idSlike = idSlike;
		this.urlSlike = urlSlike;
		this.idSobe = idSobe;
	}

	public Integer getIdSlike() {
		return idSlike;
	}

	public void setIdSlike(Integer idSlike) {
		this.idSlike = idSlike;
	}

	public String getUrlSlike() {
		return urlSlike;
	}

	public void setUrlSlike(String urlSlike) {
		this.urlSlike = urlSlike;
	}

	public Soba getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(Soba idSobe) {
		this.idSobe = idSobe;
	}
	
	
}
