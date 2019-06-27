package tim23.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.reservationservice.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer>{
	public Agent findByIdKorisnika(Integer id);

}
