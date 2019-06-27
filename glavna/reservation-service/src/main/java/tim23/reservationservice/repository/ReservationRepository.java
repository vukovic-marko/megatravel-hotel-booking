package tim23.reservationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.reservationservice.model.Rezervacija;
@Repository
public interface ReservationRepository extends JpaRepository<Rezervacija, Integer>{
	public List<Rezervacija> findBySobaIdSoba(Integer id);
	public List<Rezervacija> findAllBySobaIdSoba(Integer id);
	
}
