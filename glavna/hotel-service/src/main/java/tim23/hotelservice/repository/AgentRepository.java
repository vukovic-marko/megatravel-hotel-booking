package tim23.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.hotelservice.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
	Agent findByUsername(String username);
}
