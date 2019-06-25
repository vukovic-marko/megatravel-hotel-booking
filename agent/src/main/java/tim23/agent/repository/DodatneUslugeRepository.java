package tim23.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.DodatneUsluge;

public interface DodatneUslugeRepository extends JpaRepository<DodatneUsluge, Integer>{
	
}
