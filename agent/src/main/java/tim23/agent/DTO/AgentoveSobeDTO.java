package tim23.agent.DTO;

import java.util.ArrayList;

public class AgentoveSobeDTO {
	
	private Integer idSobe;
	private Integer brojSobe;
	private Integer brojKreveta;
	private String opis;
	private String nazivTipaSmestaja;
	private AdresaDTO adresa;
	private ArrayList<String> dodatneUsluge = new ArrayList<String>();
	
	public AgentoveSobeDTO() {
		
	}

	public AgentoveSobeDTO(Integer idSobe,Integer brojSobe, Integer brojKreveta, String opis, String nazivTipaSmestaja,
			AdresaDTO adresa,ArrayList<String> dodatneUsluge) {
		super();
		this.idSobe = idSobe;
		this.brojSobe = brojSobe;
		this.brojKreveta = brojKreveta;
		this.opis = opis;
		this.nazivTipaSmestaja = nazivTipaSmestaja;
		this.adresa = adresa;
		this.dodatneUsluge = dodatneUsluge;
	}
	

	public Integer getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(Integer idSobe) {
		this.idSobe = idSobe;
	}

	public ArrayList<String> getDodatneUsluge() {
		return dodatneUsluge;
	}

	public void setDodatneUsluge(ArrayList<String> dodatneUsluge) {
		this.dodatneUsluge = dodatneUsluge;
	}

	public Integer getBrojSobe() {
		return brojSobe;
	}

	public void setBrojSobe(Integer brojSobe) {
		this.brojSobe = brojSobe;
	}

	public Integer getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(Integer brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getNazivTipaSmestaja() {
		return nazivTipaSmestaja;
	}

	public void setNazivTipaSmestaja(String nazivTipaSmestaja) {
		this.nazivTipaSmestaja = nazivTipaSmestaja;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}
	
	

}
