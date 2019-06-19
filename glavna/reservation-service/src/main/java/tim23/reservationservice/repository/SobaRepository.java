package tim23.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.reservationservice.model.Soba;

public interface SobaRepository extends JpaRepository<Soba, Integer>{
	public Soba findByIdSoba(Integer id);
}
