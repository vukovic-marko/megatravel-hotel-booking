package tim23.agent.FromDTO;

import tim23.agent.DTO.SobaDTO;
import tim23.agent.model.Adresa;
import tim23.agent.model.Agent;
import tim23.agent.model.Soba;
import tim23.agent.model.TipSmestaja;

public class FromSobaDTO {
	private Integer broj_kreveta;
	private Integer broj_sobe;
	private String opis;
	private Adresa adresa;
	private Agent agent;
	private TipSmestaja tipSmestaja;
	private Integer idSobe;
	private Double ocena;
	private Boolean odobreno;
	
	public Soba convert() {
		Soba soba=new Soba();
		soba.setIdSoba(idSobe);
		soba.setBrojKreveta(broj_kreveta);
		soba.setBrojSobe(broj_sobe);
		soba.setOpisSmestaja(opis);
		soba.setAdresa(adresa);
		soba.setIdAgenta(agent);
		soba.setTipSmestaja(tipSmestaja);
		soba.setOcena(0d);
		soba.setOdobreno(false);
		return soba;
	}
	
	public FromSobaDTO(SobaDTO soba) {
		super();
		this.idSobe=soba.getIdSobe();
		this.broj_kreveta=soba.getBroj_kreveta();
		this.broj_sobe=soba.getBroj_sobe();
		this.opis=soba.getOpis();
		this.adresa=soba.getAdresa();
		this.agent=soba.getAgent();
		this.tipSmestaja=soba.getTipSmestaja();
	}
	
	public Integer getBroj_kreveta() {
		return broj_kreveta;
	}

	public void setBroj_kreveta(Integer broj_kreveta) {
		this.broj_kreveta = broj_kreveta;
	}

	public Integer getBroj_sobe() {
		return broj_sobe;
	}

	public void setBroj_sobe(Integer broj_sobe) {
		this.broj_sobe = broj_sobe;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public TipSmestaja getTipSmestaja() {
		return tipSmestaja;
	}

	public void setTipSmestaja(TipSmestaja tipSmestaja) {
		this.tipSmestaja = tipSmestaja;
	}

	public Integer getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(Integer idSobe) {
		this.idSobe = idSobe;
	}

	public Double getOcena() {
		return ocena;
	}

	public void setOcena(Double ocena) {
		this.ocena = ocena;
	}

	public Boolean getOdobreno() {
		return odobreno;
	}

	public void setOdobreno(Boolean odobreno) {
		this.odobreno = odobreno;
	}
}
