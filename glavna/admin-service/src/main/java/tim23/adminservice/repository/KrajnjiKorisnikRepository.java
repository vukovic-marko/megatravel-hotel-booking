package tim23.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim23.adminservice.model.KrajnjiKorisnik;

@Repository
public interface KrajnjiKorisnikRepository extends JpaRepository<KrajnjiKorisnik, Integer> {
    KrajnjiKorisnik findByUsername(String username);
    Boolean existsByUsername(String username);
}
