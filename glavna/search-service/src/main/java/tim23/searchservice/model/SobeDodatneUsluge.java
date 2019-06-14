package tim23.searchservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SobeDodatneUsluge {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_sobe")
	private Soba soba;
	
	@ManyToOne
	@JoinColumn(name="id_usluge")
	private DodatneUsluge dodatnaUsluga;

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
