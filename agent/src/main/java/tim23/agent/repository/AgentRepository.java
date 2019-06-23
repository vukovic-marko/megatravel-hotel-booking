package tim23.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.Agent;

public interface AgentRepository  extends JpaRepository<Agent, Integer> {
	boolean existsByUsername(String username);
	public Agent findByUsername(String s);
}
