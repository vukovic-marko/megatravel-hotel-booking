package tim23.adminservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.adminservice.model.Agent;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello!";
	}
	
	@PostMapping("/register")
	public void registerAgent(Agent agent) {
		// TODO: implement registering agent
		//
		// userRepository.save(agent)
	}
}
