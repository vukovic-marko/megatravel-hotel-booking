package tim23.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim23.adminservice.model.Komentar;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Integer> {
    Komentar findByIdKomentara(Integer id);
}
