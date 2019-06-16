package tim23.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tim23.adminservice.config.JwtConfig;
import tim23.adminservice.model.Administrator;
import tim23.adminservice.model.Agent;
import tim23.adminservice.repository.AdministratorRepository;
import tim23.adminservice.repository.AgentRepository;
import tim23.adminservice.service.AgentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private JwtConfig tokenUtils;

	@Autowired
	private AgentService agentService;

	@Autowired
	private AdministratorRepository administratorRepository;

	@GetMapping("/")
	public Administrator hello(HttpServletRequest request) {

		System.out.println("pogodjen");

		String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));

		Administrator a = administratorRepository.findByUsername(username);

		return a;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Agent> registerAgent(@RequestBody Agent agent, HttpServletRequest request) {

		//System.out.println(agent.getIdKorisnika());
		System.out.println(agent.getIme());
		System.out.println(agent.getPrezime());
		System.out.println(agent.getUsername());
		System.out.println(agent.getPassword());
		System.out.println(agent.getUloga());

		return agentService.registerAgent(agent);
	}
}
