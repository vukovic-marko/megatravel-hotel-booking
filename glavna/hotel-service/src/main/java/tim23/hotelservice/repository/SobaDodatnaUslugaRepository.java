package tim23.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.hotelservice.model.SobeDodatneUsluge;

public interface SobaDodatnaUslugaRepository extends JpaRepository<SobeDodatneUsluge, Integer>{
	
}
