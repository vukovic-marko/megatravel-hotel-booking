package tim23.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.authservice.model.KrajnjiKorisnik;

@Repository
public interface KrajnjiKorisnikRepository extends JpaRepository<KrajnjiKorisnik, Long> {
	KrajnjiKorisnik findOneByUsername(String username);
}
