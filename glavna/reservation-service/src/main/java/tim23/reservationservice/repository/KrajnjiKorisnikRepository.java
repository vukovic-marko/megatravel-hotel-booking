package tim23.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.reservationservice.model.KrajnjiKorisnik;

public interface KrajnjiKorisnikRepository  extends JpaRepository<KrajnjiKorisnik, Integer>{
	public KrajnjiKorisnik findByUsername(String username);
	public KrajnjiKorisnik getByIdKorisnika(Integer id);
}
