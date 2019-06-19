package tim23.searchservice.dto;

import java.util.ArrayList;
import java.util.Date;

public class PonudaDTO {

	private String datumPolaska;
	private String datumOdlaska;
	private Integer brojOsoba;
	private String mesto;
	private ArrayList<String> nazivDodatneUsluge;
	
	public PonudaDTO() {
		
	}
	
	
	public PonudaDTO(String datumPolaska, String datumOdlaska, Integer brojOsoba, String mesto,
			ArrayList<String> dodatneUsluge) {
		super();
		this.datumPolaska = datumPolaska;
		this.datumOdlaska = datumOdlaska;
		this.brojOsoba = brojOsoba;
		this.mesto = mesto;
		this.nazivDodatneUsluge = dodatneUsluge;
	}

	

	public ArrayList<String> getNazivDodatneUsluge() {
		return nazivDodatneUsluge;
	}


	public void setNazivDodatneUsluge(ArrayList<String> nazivDodatneUsluge) {
		this.nazivDodatneUsluge = nazivDodatneUsluge;
	}


	public String getDatumPolaska() {
		return datumPolaska;
	}

	public void setDatumPolaska(String datumPolaska) {
		this.datumPolaska = datumPolaska;
	}

	public String getDatumOdlaska() {
		return datumOdlaska;
	}

	public void setDatumOdlaska(String datumOdlaska) {
		this.datumOdlaska = datumOdlaska;
	}

	public Integer getBrojOsoba() {
		return brojOsoba;
	}

	public void setBrojOsoba(Integer brojOsoba) {
		this.brojOsoba = brojOsoba;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	
	
}
