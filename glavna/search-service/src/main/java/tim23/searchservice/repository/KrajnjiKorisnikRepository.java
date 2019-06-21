package tim23.searchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.searchservice.model.KrajnjiKorisnik;

@Repository
public interface KrajnjiKorisnikRepository extends JpaRepository<KrajnjiKorisnik, Integer> {
	boolean existsByUsername(String username);
}
