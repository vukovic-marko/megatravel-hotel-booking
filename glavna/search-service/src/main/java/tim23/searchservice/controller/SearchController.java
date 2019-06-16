package tim23.searchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tim23.searchservice.config.JwtConfig;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private JwtConfig tokenUtils;

	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(token);

		//KrajnjiKorisnik k = krajnjiKorisnikRepository.findByUsername(username);
		// ...

		return username;
	}
}
