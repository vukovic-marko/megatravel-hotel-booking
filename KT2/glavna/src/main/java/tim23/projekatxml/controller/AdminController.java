package tim23.projekatxml.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.korisnik.Agent;

@RestController
public class AdminController {
	
	@PostMapping("/admin/register")
	public void registerAgent(Agent agent) {
		// TODO: implement registering agent
		//
		// userRepository.save(agent)
	}
}
