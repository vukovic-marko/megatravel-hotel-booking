package tim23.projekatxml.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.entiteti.Soba;

@RestController
@RequestMapping("/hotel/")
public class HotelController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello!";
	}
	
	@GetMapping("/room/all")
	public List<Soba> getRooms(String username) {
		//	TODO: implement getting rooms
		//
		//	read agent from database:
		//		User user = userRepository.getUserByUsername(username);
		//
		//	return user.getSobe();
		
		return null;
	}
	
	@PostMapping("/room/search")
	public List<Soba> searchRooms(/*SearchQueryDTO search*/ Integer brojKreveta /*,...*/) {
		// TODO: implement searching rooms
		//
		// return roomRepository.getRoomsByNumberOfBeds(brojKreveta);
		
		return null;
	}
	
	@GetMapping("/room/{id}")
	public Soba getRoom(@PathParam("id") Integer idSobe) {
		// TODO: implement getting room details
		//
		// return roomRepository.getRoomById(idSobe);
		
		return null;
	}
}
