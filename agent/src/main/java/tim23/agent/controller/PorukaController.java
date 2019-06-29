package tim23.agent.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.agent.AgentClient;
import tim23.agent.DTO.PorukaDTO;
import tim23.agent.config.JwtConfig;
import tim23.agent.model.Agent;
import tim23.agent.model.poruke.GetPorukaListResponse;
import tim23.agent.repository.AgentRepository;

@RestController
@RequestMapping("/poruke")
public class PorukaController {
	
	@Autowired
	private AgentClient client;
	
	@Autowired
	private JwtConfig tokenUtils;
	
	@Autowired
	private AgentRepository agentRepository;

	@GetMapping("/getAllMessagess")
	public ResponseEntity<?> getAllMessagess(HttpServletRequest request){
		String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		Agent agentPrimalac = agentRepository.findByUsername(username);
		
		GetPorukaListResponse response = client.readMessage(agentPrimalac);
		
		return new ResponseEntity<>(response.getPoruke(),HttpStatus.OK);
	}
	
	@PostMapping("/sendMessage")
	public void sendMessage(@RequestBody PorukaDTO poruka,HttpServletRequest request) {
		String agentUsername = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		client.sendMessage(agentUsername, poruka.getUsername(),
				poruka.getSadrzaj());
		
	}
}
