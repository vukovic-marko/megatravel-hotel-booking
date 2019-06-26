package tim23.reservationservice.DTO;

import java.util.Date;

public class RezervacijaDTO {

    private Integer idRezervacije;
    private Date datumDolaska;
	private Date datumOdlaska;
    private Integer brojOsoba;
    private Integer idSobe;
	private Integer idKorisnika;


	public Integer getIdKorisnika() {
		return idKorisnika;
	}

	public void setIdKorisnika(Integer idKorisnika) {
		this.idKorisnika = idKorisnika;
	}

	public RezervacijaDTO(Integer idRezervacije, Date datumDolaska, Date datumOdlaska, Integer brojOsoba, Integer soba,
			Integer krajnjiKorisnik) {
		super();
		this.idRezervacije = idRezervacije;
		this.datumDolaska = datumDolaska;
		this.datumOdlaska = datumOdlaska;
		this.brojOsoba = brojOsoba;
		this.idSobe = soba;
		this.idKorisnika = krajnjiKorisnik;
	}

    public Integer getIdSobe() {
		return idSobe;
	}

	public void setIdSobe(Integer idSobe) {
		this.idSobe = idSobe;
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
 

}
