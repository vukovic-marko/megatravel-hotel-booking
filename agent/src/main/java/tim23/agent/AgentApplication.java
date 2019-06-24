package tim23.agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import tim23.agent.config.JwtConfig;
import tim23.agent.model.Agent;
import tim23.agent.model.poruke.GetAgentListRequest;
import tim23.agent.model.poruke.GetAgentListResponse;
import tim23.agent.repository.AgentRepository;

@SpringBootApplication
public class AgentApplication implements ApplicationListener<ApplicationReadyEvent> {
	
	@Autowired
	private AgentClient client;
	
	@Autowired
	private AgentRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(AgentApplication.class, args);
	}
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {		
		GetAgentListResponse response = client.getList("");
		
		List<Agent> agents = response.getAgent();
		for (Agent a: agents) {
			repo.save(a);
		}
 
		return;
	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

}
