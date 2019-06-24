package tim23.agent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tim23.agent.AgentClient;
import tim23.agent.config.JwtConfig;
import tim23.agent.model.Agent;
import tim23.agent.model.Soba;
import tim23.agent.model.poruke.GetAgentResponse;

@RestController
@RequestMapping("/agent")
public class HotelController {

	@Autowired
	private JwtConfig tokenUtils;
	
	@Autowired
	private AgentClient agentClient;

	@GetMapping("/")
	public Agent hello(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);

		GetAgentResponse response = agentClient.get(username);
		
		// Agent a = agentRepository.findByUsername(username);
		// ...

		return response.getAgent();
	}
	
	@GetMapping("/room/{id}")
	public Soba getRoom(@PathParam("id") long id) {
		
		return null;
	}
	
	@PostMapping("/room")
	public void addRoom(Soba soba) {

	}
	
	@PutMapping("/room")
	public Soba updateRoom(Soba soba) {
		
		return null;
	}
	
	@DeleteMapping("/room")
	public void removeRoom(Soba soba) {
		
	}
}
