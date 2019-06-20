package tim23.agent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class AgentConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("tim23.agent.model.poruke");
		return marshaller;
	}
	
	@Bean
	public AgentClient agentClient(Jaxb2Marshaller marshaller) {
		AgentClient client = new AgentClient();
		client.setDefaultUri("http://localhost:8762/hotel-service/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
