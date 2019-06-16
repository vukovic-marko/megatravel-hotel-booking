package tim23.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tim23.adminservice.model.Agent;
import tim23.adminservice.repository.AgentRepository;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public ResponseEntity<Agent> registerAgent(Agent agent) {

        if (!agentRepository.existsByUsername(agent.getUsername())) {
            agentRepository.save(agent);

            return ResponseEntity.ok(agentRepository.findAgentByUsername(agent.getUsername()));
        }

        return ResponseEntity.badRequest().build();
    }
}
