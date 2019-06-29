package tim23.agent.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.agent.AgentClient;
import tim23.agent.config.JwtConfig;
import tim23.agent.model.Rezervacija;
import tim23.agent.model.poruke.GetReservationListResponse;
import tim23.agent.repository.RezervacijaRepository;

@RestController
@RequestMapping("/rezervacija")
public class RezervacijaController {
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	@Autowired
	private JwtConfig tokenUtils;
	
	@Autowired
	private AgentClient client;

	@PostMapping("/realizacija/{id}")
	public void realizuj(@PathVariable Integer id) {
		client.realizujRezervaciju(id);
	}
	
	@GetMapping("/mojeRez")
	public ResponseEntity<?> mojeRez(HttpServletRequest request) {
		String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		GetReservationListResponse response =  client.getReservationList(username);
		return new ResponseEntity<>(response.getReservations(),HttpStatus.OK);
	}
}
