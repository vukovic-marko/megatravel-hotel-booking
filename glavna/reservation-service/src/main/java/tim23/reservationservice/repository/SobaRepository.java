package tim23.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.reservationservice.model.Soba;
@Repository
public interface SobaRepository extends JpaRepository<Soba, Integer>{
	public Soba findByIdSoba(Integer id);
	public Soba getByIdSoba(Integer id);
}
