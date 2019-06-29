package tim23.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.hotelservice.model.KrajnjiKorisnik;

public interface KrajnjiKorisnikRepository extends JpaRepository<KrajnjiKorisnik, Integer>{
	KrajnjiKorisnik findByUsername(String username);
}
