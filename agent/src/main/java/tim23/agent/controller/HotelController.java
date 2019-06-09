package tim23.agent.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.wsdl.Soba;

@RestController
public class HotelController {

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
