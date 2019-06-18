package tim23.searchservice.dto;

public class PonudaDTO {

	private String datumPolaska;
	private String datumOdlaska;
	private Integer brojOsoba;
	private String mesto;
	
	public PonudaDTO() {
		
	}
	
	
	public PonudaDTO(String datumPolaska, String datumOdlaska, Integer brojOsoba, String mesto) {
		super();
		this.datumPolaska = datumPolaska;
		this.datumOdlaska = datumOdlaska;
		this.brojOsoba = brojOsoba;
		this.mesto = mesto;
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
