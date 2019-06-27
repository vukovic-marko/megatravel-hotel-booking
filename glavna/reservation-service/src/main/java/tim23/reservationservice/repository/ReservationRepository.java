package tim23.reservationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.model.Soba;
@Repository
public interface ReservationRepository extends JpaRepository<Rezervacija, Integer>{
	public List<Rezervacija> findBySobaIdSoba(Integer id);
	public List<Rezervacija> findAllBySobaIdSoba(Integer id);
	public List<Rezervacija> findAllByKrajnjiKorisnikUsername(String username);
	public Rezervacija getByIdRezervacije(Integer id);
	public Soba getBySobaIdSoba(Integer id);
	
}
