package tim23.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.hotelservice.model.DodatneUsluge;

public interface DodatneUslugeRepository extends JpaRepository<DodatneUsluge, Integer>{
	
}
