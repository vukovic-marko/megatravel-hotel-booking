package tim23.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tim23.authservice.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
	Agent findOneByUsername(String username);
}
