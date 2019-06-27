package tim23.agent.DTO;

import java.util.Date;

public class TerminskiPlanCenaDTO {

	private Date pocetakVazenja;
	private Date krajVazenja;
	private Integer idSobe;
	private Double cena;
	
	public TerminskiPlanCenaDTO() {
		
	}

	public TerminskiPlanCenaDTO(Date pocetakVazenja, Date krajVazenja, Integer idSobe, Double cena) {
		super();
		this.pocetakVazenja = pocetakVazenja;
		this.krajVazenja = krajVazenja;
		this.idSobe = idSobe;
		this.cena = cena;
	}

	public Date getPocetakVazenja() {
		return pocetakVazenja;
	}

	public void setPocetakVazenja(Date pocetakVazenja) {
		this.pocetakVazenja = pocetakVazenja;
	}

	public Date getKrajVazenja() {
		return krajVazenja;
	}

	public void setKrajVazenja(Date krajVazenja) {
		this.krajVazenja = krajVazenja;
	}

	public Integer getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(Integer idSobe) {
		this.idSobe = idSobe;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}
	
	
}
