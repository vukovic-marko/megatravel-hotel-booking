package tim23.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim23.adminservice.model.TipSmestaja;

@Repository
public interface TipSmestajaRepository extends JpaRepository<TipSmestaja, Integer> {
    TipSmestaja findByIdTipa(Integer id);
}
