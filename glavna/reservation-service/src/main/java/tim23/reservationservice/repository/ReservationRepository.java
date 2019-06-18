package tim23.reservationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.model.Soba;

public interface ReservationRepository extends JpaRepository<Rezervacija, Integer>{
	public List<Rezervacija> findBySobaIdSoba(Integer id);
}
