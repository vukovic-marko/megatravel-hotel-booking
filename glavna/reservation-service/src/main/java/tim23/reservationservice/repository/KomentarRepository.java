package tim23.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.reservationservice.model.Komentar;
import tim23.reservationservice.model.Rezervacija;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Integer> {
	
	boolean existsByRezervacija(Rezervacija rezervacija);
}
