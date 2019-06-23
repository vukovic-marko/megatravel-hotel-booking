package tim23.hotelservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tim23.hotelservice.config.JwtConfig;
import tim23.hotelservice.model.KrajnjiKorisnik;
import tim23.hotelservice.repository.AgentRepository;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private JwtConfig tokenUtils;
	
	@Autowired
	private AgentRepository ar;

	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);

		// KrajnjiKorisnik k = krajnjiKorisnikRepository.findByUsername(username);
		// ...

		return username;
	}
	
    @CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/uloga")
	   public boolean proveriUlogu(HttpServletRequest request) {
		   String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		   return ar.existsByUsername(username);
	   }
}
