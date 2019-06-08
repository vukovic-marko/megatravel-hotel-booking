package tim23.projekatxml.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.entiteti.Soba;
import rs.ac.uns.ftn.korisnik.KrajnjiKorisnik;

@RestController
public class UserController {

	@PostMapping("/user")
	public void registerUser(KrajnjiKorisnik korisnik) {
		// TODO: implement user registration
		//
		//	if (userRepository.getUserByUsername(korisnik.getUsername() == null)
		// 		userRepository.save(user);
	}
	
	@GetMapping("/user")
	public Soba getUser(String username) {
		// TODO: implement getting user details
		//
		//	return userRepository.getUserByUsername(username);
		
		return null;
	}
}
