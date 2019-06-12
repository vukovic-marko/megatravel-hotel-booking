package tim23.searchservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello from search!";
	}
}
