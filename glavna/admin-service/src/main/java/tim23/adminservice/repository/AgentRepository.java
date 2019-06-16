package tim23.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tim23.adminservice.model.Agent;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
    Agent findAgentByUsername(String username);
    Boolean existsByUsername(String username);
}
