package tim23.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim23.adminservice.model.KategorijaSmestaja;

@Repository
public interface KategorijaSmestajaRepository extends JpaRepository<KategorijaSmestaja, Integer> {
	Boolean existsByNaziv(String naziv);
}
