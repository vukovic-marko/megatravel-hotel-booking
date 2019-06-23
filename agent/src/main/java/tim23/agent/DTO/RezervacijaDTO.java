package tim23.agent.DTO;

import java.util.Date;

import tim23.agent.model.KrajnjiKorisnik;
import tim23.agent.model.Soba;

public class RezervacijaDTO {

    private Integer idRezervacije;
    private Date datumDolaska;
	private Date datumOdlaska;
    private Integer brojOsoba;
    private Soba soba;
    private KrajnjiKorisnik krajnjiKorisnik;


	public RezervacijaDTO(Integer idRezervacije, Date datumDolaska, Date datumOdlaska, Integer brojOsoba, Soba soba,
			KrajnjiKorisnik krajnjiKorisnik) {
		super();
		this.idRezervacije = idRezervacije;
		this.datumDolaska = datumDolaska;
		this.datumOdlaska = datumOdlaska;
		this.brojOsoba = brojOsoba;
		this.soba = soba;
		this.krajnjiKorisnik = krajnjiKorisnik;
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
}
