package tim23.reservationservice.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim23.reservationservice.model.Soba;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello from reservations!";
	}
	
	@PostMapping("/")
	public void makeAReservation(/*ReservationDTO reservation*/ Soba soba, Date datumDolaska, Date datumOdlaska) {
		//	TODO: implement making a reservation
		// 
		//	reservationRepository.save(reservation);
	}
}
