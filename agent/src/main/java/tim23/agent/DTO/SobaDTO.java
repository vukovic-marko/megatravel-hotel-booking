package tim23.agent.DTO;

import java.util.ArrayList;

public class SobaDTO {
	private Integer idSobe;
	private Integer broj_kreveta;
	private Integer broj_sobe;
	private String opis;
	private Integer adresa;
	private Integer agent;
	private Integer tipSmestaja;
	private Integer kategorija;
	private ArrayList<Integer> dodatneUsluge;
	
	public Integer getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(Integer idSobe) {
		this.idSobe = idSobe;
	}

	public Integer getTipSmestaja() {
		return tipSmestaja;
	}

	public void setTipSmestaja(Integer tipSmestaja) {
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

	public Integer getAdresa() {
		return adresa;
	}

	public void setAdresa(Integer adresa) {
		this.adresa = adresa;
	}

	public Integer getAgent() {
		return agent;
	}

	public void setAgent(Integer agent) {
		this.agent = agent;
	}
	
	public SobaDTO() {
		
	}
	
	public ArrayList<Integer> getDodatneUsluge() {
		return dodatneUsluge;
	}

	public void setDodatneUsluge(ArrayList<Integer> dodatneUsluge) {
		this.dodatneUsluge = dodatneUsluge;
	}

	public SobaDTO(Integer idSobe,Integer broj_kreveta,Integer broj_sobe,
			String opis,Integer adresa,Integer agent,Integer tipSmestaja,Integer kategorija,ArrayList<Integer> dodatneUsluge) {
		this.dodatneUsluge = dodatneUsluge;
		this.idSobe=idSobe;
		this.broj_kreveta=broj_kreveta;
		this.broj_sobe=broj_sobe;
		this.opis=opis;
		this.adresa=adresa;
		this.agent=agent;
		this.tipSmestaja=tipSmestaja;
		this.kategorija=kategorija;
	}

	public Integer getKategorija() {
		return kategorija;
	}

	public void setKategorija(Integer kategorija) {
		this.kategorija = kategorija;
	}
}
