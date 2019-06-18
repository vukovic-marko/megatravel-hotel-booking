package tim23.reservationservice.converterFromDTO;

import java.util.Date;

import tim23.reservationservice.DTO.RezervacijaDTO;
import tim23.reservationservice.model.KrajnjiKorisnik;
import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.model.Soba;

public class FromRezervacijaDTO {

    private Integer idRezervacije;
    private Date datumDolaska;
	private Date datumOdlaska;
    private Integer brojOsoba;
    private Soba soba;
    private KrajnjiKorisnik krajnjiKorisnik;
    private boolean realizovana;
    private Double ocena;
    
    public Rezervacija convert() {
    	Rezervacija rez=new Rezervacija();
    	rez.setIdRezervacije(idRezervacije);
    	rez.setDatumDolaska(datumDolaska);
    	rez.setDatumOdlaska(datumOdlaska);
    	rez.setBrojOsoba(brojOsoba);
    	rez.setIdSobe(soba);
    	rez.setKrajnjiKorisnik(krajnjiKorisnik);
    	rez.setRealizovana(realizovana);
    	rez.setOcena(0d);
    	return rez;
    }
    
	public FromRezervacijaDTO(RezervacijaDTO rez) {
		super();
		this.idRezervacije = rez.getIdRezervacije();
		this.datumDolaska = rez.getDatumDolaska();
		this.datumOdlaska = rez.getDatumOdlaska();
		this.brojOsoba = rez.getBrojOsoba();
		this.soba = rez.getSoba();
		this.krajnjiKorisnik = rez.getKrajnjiKorisnik();

	}
	public Integer getIdRezervacije() {
		return idRezervacije;
	}
	public void setIdRezervacije(Integer idRezervacije) {
		this.idRezervacije = idRezervacije;
	}
	public Date getDatumDolaska() {
		return datumDolaska;
	}
	public void setDatumDolaska(Date datumDolaska) {
		this.datumDolaska = datumDolaska;
	}
	public Date getDatumOdlaska() {
		return datumOdlaska;
	}
	public void setDatumOdlaska(Date datumOdlaska) {
		this.datumOdlaska = datumOdlaska;
	}
	public Integer getBrojOsoba() {
		return brojOsoba;
	}
	public void setBrojOsoba(Integer brojOsoba) {
		this.brojOsoba = brojOsoba;
	}
	public Soba getSoba() {
		return soba;
	}
	public void setSoba(Soba soba) {
		this.soba = soba;
	}
	public KrajnjiKorisnik getKrajnjiKorisnik() {
		return krajnjiKorisnik;
	}
	public void setKrajnjiKorisnik(KrajnjiKorisnik krajnjiKorisnik) {
		this.krajnjiKorisnik = krajnjiKorisnik;
	}
	public boolean isRealizovana() {
		return realizovana;
	}
	public void setRealizovana(boolean realizovana) {
		this.realizovana = realizovana;
	}
	public Double getOcena() {
		return ocena;
	}
	public void setOcena(Double ocena) {
		this.ocena = ocena;
	}

}
