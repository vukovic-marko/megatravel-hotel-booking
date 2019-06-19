package tim23.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tim23.adminservice.model.Agent;
import tim23.adminservice.model.Authority;
import tim23.adminservice.model.Uloga;
import tim23.adminservice.repository.AgentRepository;
import tim23.adminservice.repository.AuthorityRepository;

import java.util.ArrayList;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public ResponseEntity<Agent> registerAgent(Agent agent) {

        if (!agentRepository.existsByUsername(agent.getUsername())) {

            Authority a = authorityRepository.getByName("AGENT");

            agent.setAuthorities(new ArrayList<Authority>() {{add(a);}});
            agent.setUloga(Uloga.AGENT);
            agent.setPassword(encoder.encode(agent.getPassword()));

            agentRepository.save(agent);

            return ResponseEntity.ok(agentRepository.findAgentByUsername(agent.getUsername()));
        }

        return ResponseEntity.badRequest().build();
    }
}
