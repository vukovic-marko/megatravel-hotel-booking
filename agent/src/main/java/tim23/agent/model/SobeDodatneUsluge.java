package tim23.agent.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SobeDodatneUsluge {
	
	@OneToMany(mappedBy = "idSoba")
	private Soba soba;
	
	@OneToMany(mappedBy = "id")
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
