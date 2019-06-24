package tim23.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.hotelservice.model.TipSmestaja;

@Repository
public interface TipSmestajaRepository extends JpaRepository<TipSmestaja, Integer> {

}
