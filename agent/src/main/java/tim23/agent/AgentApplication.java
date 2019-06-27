package tim23.agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import tim23.agent.FromDTO.FromSobaDTO;
import tim23.agent.FromDTO.SobaConverter;
import tim23.agent.FromDTO.TerminskiPlanCenaConverter;
import tim23.agent.config.JwtConfig;
import tim23.agent.model.Adresa;
import tim23.agent.model.Agent;
import tim23.agent.model.DodatneUsluge;
import tim23.agent.model.TipSmestaja;
import tim23.agent.model.poruke.GetAdresaListResponse;
import tim23.agent.model.poruke.GetAgentListResponse;
import tim23.agent.model.poruke.GetDodatneUslugeListResponse;
import tim23.agent.model.poruke.GetTipSmestajaListResponse;
import tim23.agent.repository.AdresaRepository;
import tim23.agent.repository.AgentRepository;
import tim23.agent.repository.DodatneUslugeRepository;
import tim23.agent.repository.TipSmestajaRepository;

@SpringBootApplication
public class AgentApplication implements ApplicationListener<ApplicationReadyEvent> {
	
	@Autowired
	private AgentClient client;
	
	@Autowired
	private AgentRepository repo;
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	@Autowired
	private TipSmestajaRepository tipSmestajaRepository;
	
	@Autowired
	private DodatneUslugeRepository dodatneUslugeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgentApplication.class, args);
	}
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {		
		GetAgentListResponse responseAgenti = client.getList("");
		GetAdresaListResponse responseAdrese = client.getAdrese();
		GetTipSmestajaListResponse responseTipoviSmestaja = client.getTip();
		GetDodatneUslugeListResponse responseDodatneUsluge = client.getDodatneUsluge();
		
		List<Agent> agents = responseAgenti.getAgent();
		for (Agent a: agents) {
			repo.save(a);
		}
		
		List<Adresa> adrese = responseAdrese.getAdrese();
		for (Adresa a: adrese) {
			adresaRepository.save(a);
		}
		
		List<TipSmestaja> tipoviSmestaja = responseTipoviSmestaja.getTipoviSmestaja();
		for (TipSmestaja t: tipoviSmestaja) {
			tipSmestajaRepository.save(t);
		}
		
		List<DodatneUsluge> dodatneUsluge = responseDodatneUsluge.getDodatneUsluge();
		for (DodatneUsluge usluga: dodatneUsluge) {
			dodatneUslugeRepository.save(usluga);
		}
 
		return;
	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}
	
	@Bean
	public FromSobaDTO fromSobaDTO() {
		return new FromSobaDTO();
	}
	
	@Bean
	public SobaConverter sobaConverter() {
		return new SobaConverter();
	}
	
	@Bean
	public TerminskiPlanCenaConverter terminskiPlanCenaConverter() {
		return new TerminskiPlanCenaConverter();
	}

}
