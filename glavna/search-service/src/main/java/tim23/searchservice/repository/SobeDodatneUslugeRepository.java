package tim23.searchservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import tim23.searchservice.model.SobeDodatneUsluge;


public interface SobeDodatneUslugeRepository extends JpaRepository<SobeDodatneUsluge, Integer>{
   /*
	public List<SobeDodatneUsluge> findByIdSobe(Integer id);
*/}
