package tim23.hotelservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello from hotel-service!";
	}
}
