package tim23.agent.DTO;

import tim23.agent.model.Adresa;
import tim23.agent.model.Agent;
import tim23.agent.model.TipSmestaja;

public class SobaDTO {
	public Integer idSobe;
	public Integer broj_kreveta;
	public Integer broj_sobe;
	public String opis;
	public Adresa adresa;
	public Agent agent;
	public TipSmestaja tipSmestaja;
	
	public Integer getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(Integer idSobe) {
		this.idSobe = idSobe;
	}

	public TipSmestaja getTipSmestaja() {
		return tipSmestaja;
	}

	public void setTipSmestaja(TipSmestaja tipSmestaja) {
		this.tipSmestaja = tipSmestaja;
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

	public SobaDTO(Integer idSobe,Integer broj_kreveta,Integer broj_sobe,String opis,Adresa adresa,Agent agent,TipSmestaja tipSmestaja) {
		super();
		this.idSobe=idSobe;
		this.broj_kreveta=broj_kreveta;
		this.broj_sobe=broj_sobe;
		this.opis=opis;
		this.adresa=adresa;
		this.agent=agent;
		this.tipSmestaja=tipSmestaja;
	}
}
