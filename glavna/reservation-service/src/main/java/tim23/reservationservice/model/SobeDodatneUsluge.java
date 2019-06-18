package tim23.reservationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "soba",
    "dodatnaUsluga"
})
@Entity
public class SobeDodatneUsluge {
	
    @XmlElement(name = "Id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@XmlElement(name = "Id_sobe")
	@ManyToOne
	@JoinColumn(name="id_sobe")
	private Soba soba;
	
    @XmlElement(name = "Id_usluge")
	@ManyToOne
	@JoinColumn(name="id_usluge")
	private DodatneUsluge dodatnaUsluga;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public DodatneUsluge getDodatnaUsluga() {
		return dodatnaUsluga;
	}

	public void setDodatnaUsluga(DodatneUsluge dodatnaUsluga) {
		this.dodatnaUsluga = dodatnaUsluga;
	}

	public SobeDodatneUsluge(Soba soba, DodatneUsluge dodatnaUsluga) {
		super();
		this.soba = soba;
		this.dodatnaUsluga = dodatnaUsluga;
	}
	
	public SobeDodatneUsluge() {
		
	}

}
